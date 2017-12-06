package com.derekudacityclassprojects.jokelib;

import java.util.ArrayList;

public class JavaJoke {
    private final ArrayList<String[]> jokes = new ArrayList<>();
    private int currentJokeIndex = 0;

    public JavaJoke(ArrayList<String[]> jokes) {
        if(jokes != null){
            for(String[] item : jokes){
                this.jokes.add(item);
            }
        }
    }


    public String[] getJoke(){
        return jokes.get(currentJokeIndex++);
    }

}