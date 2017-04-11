package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle extras = getIntent().getExtras();
        int score = extras.getInt("Score");

        TextView resultsScore = (TextView) findViewById(R.id.results_score);
        TextView resultsAnswer = (TextView) findViewById(R.id.results_answer);
        //Score to int because we need to compare numbers
        String scoreString = Integer.toString(score);
        resultsScore.setText(scoreString);
        if (score < 35) {
            resultsAnswer.setText(getString(R.string.answer1));
        } else if (score > 50) {
            resultsAnswer.setText(getString(R.string.answer3));
        } else {
            resultsAnswer.setText(getString(R.string.answer2));
        }
    }

}
