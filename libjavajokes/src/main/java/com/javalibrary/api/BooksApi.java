package com.javalibrary.api;

import com.javalibrary.model.ListResponsJoke;

import retrofit.http.GET;

/**
 * Created by AdonisArifi on 15.12.2015 - 2015 . alexandria
 */
public interface BooksApi {

//https://www.googleapis.com/books/v1/volumes?q=isbn:9780553804577&country=US

    @GET("/")
    ListResponsJoke getListResponsJoke();

}
