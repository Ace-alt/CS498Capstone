package com.example.andriod.yeswecodeproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //my Buttons
        //Lesson Selection
        Button lessons = (Button) findViewById(R.id.LessonButton);
        lessons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent lesIntent = new Intent(view.getContext(), LesSelectActivity.class);
                startActivityForResult(lesIntent, 0);
            }

        });

        //Game Selection
        Button games = (Button) findViewById(R.id.GamesButton);
        games.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent gameIntent = new Intent(view.getContext(), GameSelectActivity.class);
                startActivityForResult(gameIntent, 0);
            }

        });

        //Info Button
        Button info = (Button) findViewById(R.id.InfoButton);
        info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text ="CS Capstone Project by Alana Allbritton";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        });

        //Quit Button
        Button quit = (Button) findViewById(R.id.QuitButton);
        quit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.exit(0);
            }

        });



    }


}
