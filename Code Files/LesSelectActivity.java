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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class LesSelectActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lessonRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_selection);

        //Activates listview
        lessonRoll = (ListView) findViewById(R.id.lessonList);
        lessonRoll.setOnItemClickListener(this);


        //Buttons
        //Back to Home Button
        Button back = (Button) findViewById(R.id.lessonBackButton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent backIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(backIntent, 0);
            }

        });

        //Start Button
        Button start = (Button) findViewById(R.id.lessonStartButton);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(view.getContext(), LessonActivity.class);
                startActivityForResult(startIntent, 0);
            }

        });

    }

    //Displays Description of Lesson when item on list is selected.
    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id){

        TextView lessDescription = findViewById(R.id.lessonDescription);
        lessDescription.setText("This is a test!");
    }
}

