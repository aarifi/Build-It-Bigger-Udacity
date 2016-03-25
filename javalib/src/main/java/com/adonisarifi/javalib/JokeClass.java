package com.adonisarifi.javalib;

public class JokeClass {


    public final static String[] myJokes = {
            "Chuck Norris doesn't look both ways before he crosses the street... he just roundhouses any cars that get too close.",
            "1  Why did the cow cross the road?" +
                    "To get to the udder side.",
            "For undercover police work, Chuck Norris pins his badge underneath his shirt, directly into his chest.",
            "Chuck Norris doesn't use web standards as the web will conform to him.",
            "Chuck Norris breaks RSA 128-bit encrypted codes in milliseconds."};

    public String getJoke(Integer index) {
        return myJokes[index];
    }
}
