package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.adonisarifi.jokebackend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by AdonisArifi on 24.3.2016 - 2016 . FinalProject Build It Bigger
 */
public class EndpointsAsyncTask extends AsyncTask<JokeListener, Void, String> {
    private JokeApi myApi = null;
    private JokeListener jokeListener;

    private Integer index;



    @Override
    protected String doInBackground(JokeListener... params) {
        if (myApi == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://ultimate-hydra-124901.appspot.com/_ah/api/");

            // end options for devappserver

            myApi = builder.build();
        }

        jokeListener = params[0];

        try {
            return myApi.tellUsJoke().execute().getJokeDescription();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(result !=null)
        {

            jokeListener.onResult(result);

        }
    }
}
