package com.example.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class JokeDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        TextView tv = (TextView) findViewById(R.id.jokeText);
        Intent jokeIntent = getIntent();
        tv.setText(jokeIntent.getStringExtra(getString(R.string.joke_text)));
    }
}
