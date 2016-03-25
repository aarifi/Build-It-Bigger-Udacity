/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.adonisarifi.jokebackend;

import com.adonisarifi.javalib.JokeClass;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "jokebackend.adonisarifi.com",
                ownerName = "jokebackend.adonisarifi.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "tellUsJoke")
    public MyJokeModel tellUsJoke() {
        MyJokeModel response = new MyJokeModel();
        JokeClass jokeClass = new JokeClass();
        Random random = new Random();
        response.setJokeDescription(jokeClass.getJoke(random.nextInt(jokeClass.myJokes.length)));
        return response;
    }

    @ApiMethod(name = "storJoke")
    public void storJoke(@Named("id") Long id, @Named("jokeAuthor") String jokeAuthor, @Named("jokeDescription") String jokeDescription) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Transaction txn = datastoreService.beginTransaction();
        try {
            MyJokeModel response = new MyJokeModel();
            Key key = KeyFactory.createKey("JokeParent", "todo.txt");
            Entity entity = new Entity("MyBean", id, key);


            entity.setProperty("id", id);
            entity.setProperty("jokeAuthor", jokeAuthor);
            entity.setProperty("jokeDescription", jokeDescription);

            datastoreService.put(entity);
            txn.commit();


        } finally {
            if (txn.isActive()) {
                txn.rollback();
            }
        }
    }

    @ApiMethod(name = "getJoke")
    public ListResponsJoks getJoke() {
        ListResponsJoks listResponsJoks = new ListResponsJoks();
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey("JokeParent", "todo.txt");
        Query query = new Query(key);
        List<Entity> resuList = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
        ArrayList<MyJokeModel> myJokeModels = new ArrayList<MyJokeModel>();
        for (Entity bean : resuList) {
            MyJokeModel myJokeModel = new MyJokeModel();
            myJokeModel.setId(bean.getKey().getId());
            myJokeModel.setJokeAuthor((String) bean.getProperty("jokeAuthor"));
            myJokeModel.setJokeDescription((String) bean.getProperty("jokeDescription"));
            myJokeModels.add(myJokeModel);
            listResponsJoks.setMyJokeModel(myJokeModels);

        }

        if (resuList.size() >= 1) {
            listResponsJoks.setStatusi(true);
        } else {
            listResponsJoks.setStatusi(false);
        }
        return listResponsJoks;
    }

}
