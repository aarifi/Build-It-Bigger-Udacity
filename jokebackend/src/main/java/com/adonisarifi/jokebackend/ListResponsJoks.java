package com.adonisarifi.jokebackend;

import java.util.List;

/**
 * Created by AdonisArifi on 19.3.2016 - 2016 . Build It Bigger
 */
public class ListResponsJoks {

    private boolean statusi;

    private List<MyJokeModel> myJokeModel;

    public boolean isStatusi() {
        return statusi;
    }

    public void setStatusi(boolean statusi) {
        this.statusi = statusi;
    }

    public List<MyJokeModel> getMyJokeModel() {
        return myJokeModel;
    }

    public void setMyJokeModel(List<MyJokeModel> myJokeModel) {
        this.myJokeModel = myJokeModel;
    }
}
