package com.example.andriod.yeswecodeproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class LesSelectActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lessonRoll;
    Button start;
    int lesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_selection);

        //Activates listview
        lessonRoll = (ListView) findViewById(R.id.lessonList);
        lessonRoll.setOnItemClickListener(this);


        //Back to Home Button
        Button back = (Button) findViewById(R.id.lessonBackButton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();

            }

        });

        //Start Button
        start = (Button) findViewById(R.id.lessonStartButton);
        //disabled until an item is selected from the list
        start.setEnabled(false);
        //selects which lesson to start
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                switch (lesson){
                    case 0:
                        Intent lessonIntent1 = new Intent(view.getContext(), LessonActivity1.class);
                        startActivityForResult(lessonIntent1, 0); break;

                    case 1:
                        Intent lessonIntent2 = new Intent(view.getContext(), LessonActivity2.class);
                        startActivityForResult(lessonIntent2, 0); break;

                    case 2:
                        Intent lessonIntent3 = new Intent(view.getContext(), LessonActivity3.class);
                        startActivityForResult(lessonIntent3, 0); break;

                    case 3:
                        Intent lessonIntent4 = new Intent(view.getContext(), LessonActivity4.class);
                        startActivityForResult(lessonIntent4, 0); break;

                    case 4:
                        Intent lessonIntent5 = new Intent(view.getContext(), LessonActivity5.class);
                        startActivityForResult(lessonIntent5, 0); break;
                }

                start.setEnabled(false);

            }

        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView lessDescription = findViewById(R.id.lessonDescription);

        //changes lessonDescription base on list item
        switch(i){
            case 0: lessDescription.setText(R.string.lessonDescript1); break;
            case 1: lessDescription.setText(R.string.lessonDescript2); break;
            case 2: lessDescription.setText(R.string.lessonDescript3); break;
            case 3: lessDescription.setText(R.string.lessonDescript4); break;
            case 4: lessDescription.setText(R.string.lessonDescript5); break;
        }

        //select the lesson
        lesson = i;
        //allow the start button to be pressed
        start.setEnabled(true);
    }
}

