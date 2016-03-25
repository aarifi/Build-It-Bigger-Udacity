package com.adonisarifi.jokebackend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyJokeModel {

    private Long id;
    private String jokeAuthor;
    private String jokeDescription;

    public String getJokeDescription() {
        return jokeDescription;
    }

    public void setJokeDescription(String jokeDescription) {
        this.jokeDescription = jokeDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJokeAuthor() {
        return jokeAuthor;
    }

    public void setJokeAuthor(String jokeAuthor) {
        this.jokeAuthor = jokeAuthor;
    }




}