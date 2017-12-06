package com.derekudacityclassprojects.jokeappproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.derekudacityclassprojects.jokelib.JokesStatic;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        HashMap<String, FirebaseJoke> hashMap = new HashMap<>();
        for(int i = 0 ; i < JokesStatic.JOKES.size(); i++){
            hashMap.put(Integer.toString(i),
                    new FirebaseJoke(
                            JokesStatic.JOKES.get(i)[0],
                            JokesStatic.JOKES.get(i)[1]
                    ));
        }
        FirebaseDatabase.getInstance().getReference().setValue(hashMap,
                new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        Toast.makeText(MainActivity.this, "TOAST", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
