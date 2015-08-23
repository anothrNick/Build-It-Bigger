package com.nicksjostrom.jokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE = "com.nicksjostrom.jokelibrary.JOKE";

    TextView jokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        jokeText = (TextView) findViewById(R.id.joke_text);

        Intent intent = getIntent();

        if(intent != null) {
            String joke = intent.getStringExtra(JOKE);
            if(joke != null) {
                jokeText.setText(joke);
            }
        }
    }
}
