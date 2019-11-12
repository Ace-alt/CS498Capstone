package com.example.andriod.yeswecodeproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_selection);

        //Buttons
        //Back to Home Button
        Button back = (Button) findViewById(R.id.gameBackButton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent backIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(backIntent, 0);
            }

        });


        final TextView musicGameDescription = findViewById(R.id.gameDescription);
        //Quiz Button
        Button quiz = (Button) findViewById(R.id.quizButton);
        quiz.setOnClickListener(new View.OnClickListener() {
            int counter=0;
            public void onClick(View view) {
                musicGameDescription.setText("Play the Quiz!");
                counter++;
                //if clicked twice, goes to game
                if(counter==2){
                    Intent quizIntent = new Intent(view.getContext(), QuizActivity.class);
                    startActivityForResult(quizIntent, 0);
                    counter=0;
                }
            }

        });

        //Music Button
        final Button music = (Button) findViewById(R.id.musicButton);
        music.setOnClickListener(new View.OnClickListener() {
            int counter = 0;
            public void onClick(View view) {
                musicGameDescription.setText("Play the Music Game!");
                counter++;
                //If clicked twice, goes to game
                if(counter==2){
                    Intent musicIntent = new Intent(view.getContext(), MusicActivity.class);
                    startActivityForResult(musicIntent, 0);
                    counter=0;
                }
            }

        });


        //Start Button
        Button start = (Button) findViewById(R.id.gameStartButton);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //will fix later
            }

        });

    }
}
