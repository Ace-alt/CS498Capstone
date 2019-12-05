package com.example.andriod.yeswecodeproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LessonActivity5 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);

        final TextView wordBox = (TextView) findViewById(R.id.textbox);
        final ImageView methodDia = (ImageView) findViewById(R.id.methoddia);
        methodDia.setVisibility(View.VISIBLE);

        final ImageView methodcode = (ImageView) findViewById(R.id.methodcode);

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
                if(lineNum<=8) {
                    wordBox.setText(getResources().getStringArray(R.array.lesson5)[lineNum]);
                    if(lineNum ==2){
                        methodDia.setVisibility(View.INVISIBLE);
                        methodcode.setVisibility(View.VISIBLE);
                    }
                    lineNum++;
                }
            }

        });


    }

}
