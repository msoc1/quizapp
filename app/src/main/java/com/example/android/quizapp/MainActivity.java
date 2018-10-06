package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void checkFirstQuestion() {
        String correctAnswer = "Warsaw";
        String usersAnswer = ((TextView) findViewById(R.id.user_answer)).getText().toString();

        if (correctAnswer.compareToIgnoreCase(usersAnswer) == 0) {
            score++;
        }
    }

    private void checkSecondQuestion() {
        CheckBox firstAnswer = findViewById(R.id.second_question_first_answer);
        CheckBox secondAnswer = findViewById(R.id.second_question_second_answer);
        CheckBox thirdAnswer = findViewById(R.id.second_question_third_answer);
        CheckBox fourthAnswer = findViewById(R.id.second_question_fourth_answer);
        if (firstAnswer.isChecked() && fourthAnswer.isChecked() && !secondAnswer.isChecked() && !thirdAnswer.isChecked()) {
            score += 2;
        }
    }

    private void checkThirdQuestion() {
        RadioButton correctAnswer = findViewById(R.id.third_question_correct_answer);
        if (correctAnswer.isChecked()) {
            score++;
        }
    }

    private void checkFourthQuestion() {
        CheckBox firstAnswer = findViewById(R.id.taco);
        CheckBox secondAnswer = findViewById(R.id.bigos);
        CheckBox thirdAnswer = findViewById(R.id.pierogi);
        CheckBox fourthAnswer = findViewById(R.id.langosz);
        if (thirdAnswer.isChecked() & secondAnswer.isChecked() && !firstAnswer.isChecked() && !fourthAnswer.isChecked()) {
            score += 2;
        }
    }

    public void showScore(View view) {
        checkFirstQuestion();
        checkSecondQuestion();
        checkThirdQuestion();
        checkFourthQuestion();
        CharSequence text = "You have maximum points!";
        if (score == 6) {
            Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT);
            toast.show();
            score = 0;
        } else {
            text = "You have: " + score + " points, something is wrong!";
            Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT);
            toast.show();
            score = 0;
        }
    }

}