package com.derekudacityclassprojects.jokeappproject;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by pittsd on 12/6/2017.
 */

@IgnoreExtraProperties
public class FirebaseJoke {
    public String jokeStart;
    public String jokeEnd;

    public FirebaseJoke() {
    }

    public FirebaseJoke(String jokeStart, String jokeEnd) {
        this.jokeStart = jokeStart;
        this.jokeEnd = jokeEnd;
    }
}
