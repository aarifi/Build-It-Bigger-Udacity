package com.javalibrary.model;

/**
 * Created by AdonisArifi on 16.3.2016 - 2016 . Build It Bigger
 */
public class ListResponsJoke {

    private JokeModel value;
    private String type;

    public JokeModel getValue() {
        return value;
    }

    public void setValue(JokeModel value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
