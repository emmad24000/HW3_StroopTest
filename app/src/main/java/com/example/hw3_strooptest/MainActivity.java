package com.example.hw3_strooptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] colorsString;
    TextView displayString;
    TextView correctNumb;
    TextView incorrectNumb;
    int green;
    int red;
    int blue;
    int totalCorrect = 0;
    int totalIncorrect = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayString = findViewById(R.id.displayString);
        correctNumb = findViewById(R.id.correctNumb);
        incorrectNumb = findViewById(R.id.incorrectNumb);
        colorsString = getResources().getStringArray(R.array.textColors);
        green = getResources().getColor(R.color.greenButton);
        blue = getResources().getColor(R.color.blueButton);
        red = getResources().getColor(R.color.redButton);
        if(savedInstanceState != null){
            displayString.setText(savedInstanceState.getString("currentText"));
            displayString.setTextColor(savedInstanceState.getInt("currentColor"));
            totalCorrect = savedInstanceState.getInt("correct");
            totalIncorrect = savedInstanceState.getInt("incorrect");
        }else generateString();
    }
    @Override
    protected void onPause() {
        super.onPause();
        correctNumb.setText("0");
        incorrectNumb.setText("0");
    }
    @Override
    protected void onResume() {
        correctNumb.setText(String.valueOf(totalCorrect));
        incorrectNumb.setText(String.valueOf(totalIncorrect));
        super.onResume();
    }
    public void selectRed(View view) {
        if(displayString.getCurrentTextColor() == red){
           totalCorrect++;
           correctNumb.setText(String.valueOf(totalCorrect));
            generateString();
        }else{
            totalIncorrect++;
            incorrectNumb.setText(String.valueOf(totalIncorrect));
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentColor",displayString.getCurrentTextColor());
        outState.putString("currentText", (String) displayString.getText());
        outState.putInt("correct",totalCorrect);
        outState.putInt("incorrect",totalIncorrect);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public void selectGreen(View view) {
        if(displayString.getCurrentTextColor() == green){
            totalCorrect++;
            correctNumb.setText(String.valueOf(totalCorrect));
            generateString();
        }else{
            totalIncorrect++;
            incorrectNumb.setText(String.valueOf(totalIncorrect));
        }
    }
    public void selectBlue(View view) {
        if(displayString.getCurrentTextColor() == blue){
            totalCorrect++;
            correctNumb.setText(String.valueOf(totalCorrect));
            generateString();
        }else{
            totalIncorrect++;
            incorrectNumb.setText(String.valueOf(totalIncorrect));
        }
    }
    public void generateString(){
        int rand = (int) (Math.random() * (3));
        int randColor = (int)(Math.random()*(3));
        if(randColor == 0) displayString.setTextColor(green);
        else if(randColor == 1) displayString.setTextColor(red);
        else if(randColor == 2) displayString.setTextColor(blue);
        displayString.setText(colorsString[rand]);
    }
}