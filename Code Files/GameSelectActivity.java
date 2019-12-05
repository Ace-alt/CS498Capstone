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
        final TextView gameDescription = findViewById(R.id.gameDescription);

        //Button List
        final Button back = (Button) findViewById(R.id.gameBackButton);
        final Button quiz = (Button) findViewById(R.id.quizButton);
        final Button music = (Button) findViewById(R.id.musicButton);
        final Button start = (Button) findViewById(R.id.gameStartButton);

        //Back to Home Button
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });


        //Quiz Button
        quiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                music.setEnabled(false);
                start.setEnabled(true);
                gameDescription.setText(R.string.quizDescript);
            }

        });

        //Music Button
        music.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                quiz.setEnabled(false);
                start.setEnabled(true);
                gameDescription.setText(R.string.gameDescript);

            }

        });

        //Start Button
        //starts deactivated. Only activated my music or quiz
        start.setEnabled(false);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(music.isEnabled()){
                    Intent musicIntent = new Intent(view.getContext(), MusicActivity.class);
                    startActivityForResult(musicIntent, 0);
                    start.setEnabled(false);
                }
                if(quiz.isEnabled()){
                    Intent quizIntent = new Intent(view.getContext(), QuizActivity.class);
                    startActivityForResult(quizIntent, 0);
                    start.setEnabled(false);
                }
                quiz.setEnabled(true);
                music.setEnabled(true);
            }

        });

    }
}
