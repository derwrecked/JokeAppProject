package com.derekudacityclassprojects.displayjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {
    public final static String EXTRA_JOKE = "EXTRA_JOKE";
    public final static String EXTRA_JOKE_ANSWER = "EXTRA_JOKE_ANSWER";
    private String joke;
    private String answer;
    private Button getAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        joke = getIntent().getStringExtra(EXTRA_JOKE);
        answer = getIntent().getStringExtra(EXTRA_JOKE_ANSWER);
        if(joke == null || answer == null){
            finish();
        }

        final TextView jokeTextView = findViewById(R.id.display_activity_joke_text_view);
        jokeTextView.setText(joke);
        final TextView answerTextView = findViewById(R.id.display_activity_joke_punchline_text_view);
        getAnswer = findViewById(R.id.display_activity_get_punchline_button);
        getAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerTextView.getText().toString().isEmpty()){
                    answerTextView.setText(answer);
                }
            }
        });
    }
}