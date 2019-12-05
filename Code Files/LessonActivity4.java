package com.example.andriod.yeswecodeproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import pl.droidsonroids.gif.GifImageView;

public class LessonActivity4 extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);

        final TextView wordBox = (TextView) findViewById(R.id.textbox);
        final GifImageView circle = (GifImageView) findViewById(R.id.circle);
        circle.setVisibility(View.VISIBLE);
        final ImageView loop = (ImageView) findViewById(R.id.loop);


        //Buttons
        //Back to Lesson Selection Button
        Button back = (Button) findViewById(R.id.backtoLesSelectButton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });

        //Next Line Button
        Button next = (Button) findViewById(R.id.lessonContinue);
        next.setOnClickListener(new View.OnClickListener() {
            int lineNum = 0;
            public void onClick(View view) {
                if(lineNum<=5) {
                    wordBox.setText(getResources().getStringArray(R.array.lesson4)[lineNum]);
                    if(lineNum==1){
                        circle.setVisibility(View.INVISIBLE);
                        loop.setVisibility(View.VISIBLE);
                    }
                    lineNum++;
                }
            }

        });


    }




}
