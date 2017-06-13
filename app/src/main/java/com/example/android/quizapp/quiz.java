package com.example.android.quizapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    //variable score keep track on points you have
    int score = 0;

    //This method is called when you submit your answer
    public void submit(View view) {

        //Get age  from question 1
        EditText ageField = (EditText) findViewById(R.id.age_field);
        Editable ageEditable = ageField.getText();
        String ageString = ageEditable.toString();
        //Age string to int because we have to compare numbers. Before we check if string is not NULL.
        if (!ageString.matches("")) {
            int age = Integer.parseInt(ageString);
            if (age > 39) {
                score = score + 15;
            }
        }

        //Logic for RadioButtons and CheckBoxes, we need all answers because we will check whether the user marked all the questions later
        RadioButton answer2 = (RadioButton) findViewById(R.id.radio2_yes);
        RadioButton answer2no = (RadioButton) findViewById(R.id.radio2_no);

        if (answer2.isChecked()) {
            score = score + 20;
        }

        RadioButton answer3 = (RadioButton) findViewById(R.id.radio3_yes);
        RadioButton answer3no = (RadioButton) findViewById(R.id.radio3_no);

        if (answer3.isChecked()) {
            score = score + 15;
        }

        RadioButton answer4 = (RadioButton) findViewById(R.id.radio4_yes);
        RadioButton answer4no = (RadioButton) findViewById(R.id.radio4_no);

        if (answer4.isChecked()) {
            score = score + 10;
        }

        RadioButton answer5 = (RadioButton) findViewById(R.id.radio5_yes);
        RadioButton answer5no = (RadioButton) findViewById(R.id.radio5_no);

        if (answer5.isChecked()) {
            score = score + 5;
        }

        CheckBox answer6a = (CheckBox) findViewById(R.id.checkbox_q6_yes1);
        CheckBox answer6b = (CheckBox) findViewById(R.id.checkbox_q6_yes2);
        CheckBox answer6no = (CheckBox) findViewById(R.id.checkbox_q6_no);

        if ((answer6a.isChecked() || answer6b.isChecked()) && !answer6no.isChecked()) {
            score = score + 5;
        }

        RadioButton answer7 = (RadioButton) findViewById(R.id.radio7_yes);
        RadioButton answer7no = (RadioButton) findViewById(R.id.radio7_no);

        if (answer7.isChecked()) {
            score = score + 10;
        }

        RadioButton answer8 = (RadioButton) findViewById(R.id.radio8_yes);
        RadioButton answer8no = (RadioButton) findViewById(R.id.radio8_no);

        if (answer8.isChecked()) {
            score = score + 10;
        }

        RadioButton answer9 = (RadioButton) findViewById(R.id.radio9_yes);
        RadioButton answer9no = (RadioButton) findViewById(R.id.radio9_no);

        if (answer9.isChecked()) {
            score = score + 10;
        }

        RadioButton answer10 = (RadioButton) findViewById(R.id.radio10_yes);
        RadioButton answer10no = (RadioButton) findViewById(R.id.radio10_no);

        if (answer10.isChecked()) {
            score = score + 15;
        }

        //check if user answer all questions and entered age
        if (ageString.matches("")) {
            Toast.makeText(getApplicationContext(), getString(R.string.giveAnswers), Toast.LENGTH_SHORT).show();
            score = 0; //because if you hit submit button again program counts points 2 times
            return;
        }
        if (!((answer2.isChecked()) || (answer2no.isChecked()))) {
            Toast.makeText(getApplicationContext(), getString(R.string.giveAnswers), Toast.LENGTH_SHORT).show();
            score = 0;
            return;
        }
        if (!((answer3.isChecked()) || (answer3no.isChecked()))) {
            Toast.makeText(getApplicationContext(), getString(R.string.giveAnswers), Toast.LENGTH_SHORT).show();
            score = 0;
            return;
        }
        if (!((answer4.isChecked()) || (answer4no.isChecked()))) {
            Toast.makeText(getApplicationContext(), getString(R.string.giveAnswers), Toast.LENGTH_SHORT).show();
            score = 0;
            return;
        }
        if (!((answer5.isChecked()) || (answer5no.isChecked()))) {
            Toast.makeText(getApplicationContext(), getString(R.string.giveAnswers), Toast.LENGTH_SHORT).show();
            score = 0;
            return;
        }
        if (!(((answer6a.isChecked()) || (answer6b.isChecked())) || (answer6no.isChecked()))) {
            Toast.makeText(getApplicationContext(), getString(R.string.giveAnswers), Toast.LENGTH_SHORT).show();
            score = 0;
            return;
        }
        if (!((answer7.isChecked()) || (answer7no.isChecked()))) {
            Toast.makeText(getApplicationContext(), getString(R.string.giveAnswers), Toast.LENGTH_SHORT).show();
            score = 0;
            return;
        }
        if (!((answer8.isChecked()) || (answer8no.isChecked()))) {
            Toast.makeText(getApplicationContext(), getString(R.string.giveAnswers), Toast.LENGTH_SHORT).show();
            score = 0;
            return;
        }
        if (!((answer9.isChecked()) || (answer9no.isChecked()))) {
            Toast.makeText(getApplicationContext(), getString(R.string.giveAnswers), Toast.LENGTH_SHORT).show();
            score = 0;
            return;
        }
        if (!((answer10.isChecked()) || (answer10no.isChecked()))) {
            Toast.makeText(getApplicationContext(), getString(R.string.giveAnswers), Toast.LENGTH_SHORT).show();
            score = 0;
            return;
        }

        //Toast just for meet the project criteria, result with the description is displayed in "results activity"
        Toast.makeText(getApplicationContext(), getString(R.string.results) + " " + score, Toast.LENGTH_SHORT).show();

        //Start new activity and pass score to it
        Intent i = new Intent(this, results.class);
        i.putExtra("Score", score);
        startActivity(i);
        score = 0;

    }


}
