package com.example.andriod.yeswecodeproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

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

    }


}
