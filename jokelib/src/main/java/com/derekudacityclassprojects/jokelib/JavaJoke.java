package com.derekudacityclassprojects.jokelib;

import java.util.ArrayList;

public class JavaJoke {
    private ArrayList<String[]> jokes = new ArrayList<>();
    private int currentJokeIndex = 0;

    public JavaJoke(ArrayList<String[]> jokes) {
        if(jokes != null && !jokes.isEmpty()){
            this.jokes = jokes;
        }else{
            this.jokes = JokesStatic.JOKES;
        }
    }

    public void setJokes(ArrayList<String[]> jokes){
        if(jokes != null){
            this.jokes = jokes;
        }
    }


    public String[] getJoke(){
        return jokes.get(currentJokeIndex++);
    }

}