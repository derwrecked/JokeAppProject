package com.derekudacityclassprojects.jokeappproject;

import android.os.AsyncTask;
import android.os.Handler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

/**
 * Created by pittsd on 12/6/2017.
 */

public class GetJokesFromFirebaseAsyncTask extends AsyncTask<Void, Integer, Integer>{
    private GetAllJokesCallback callback;
    private Timer timer = new Timer();
    public GetJokesFromFirebaseAsyncTask(GetAllJokesCallback callback) {
        this.callback = callback;
    }

    final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private final ArrayList<String[]> allJokes = new ArrayList<>();
    @Override
    protected Integer doInBackground(Void... voids) {
        final boolean[] waitFlag = new boolean[]{true};
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        SimpleTimer(30, waitFlag);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FirebaseJoke joke;
                for(DataSnapshot snap : dataSnapshot.getChildren()){
                    joke = snap.getValue(FirebaseJoke.class);
                    allJokes.add(new String[]{joke.jokeStart, joke.jokeEnd});
                }
                waitFlag[1] = false;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // NA
                waitFlag[1] = false;
            }
        });

        while (waitFlag[1]){}
        databaseReference = null;
        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        if(!allJokes.isEmpty()){
            callback.updateUI(allJokes);
        }
    }

    /**
     * Used for timeout with firebase requests.
     * @param seconds
     * @param waitflag
     */
    public void SimpleTimer(int seconds, final boolean[] waitflag){
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if(waitflag != null && waitflag.length != 0){
                    waitflag[1] = false;
                }
            }
        }, seconds * 1000);
    }


    public interface GetAllJokesCallback{
        void updateUI(ArrayList<String[]> arrayList);
    }

}
