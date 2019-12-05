package com.example.andriod.yeswecodeproject;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LessonActivity2 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);

        final TextView wordBox = (TextView) findViewById(R.id.textbox);
        final ImageView math = (ImageView) findViewById(R.id.chalkmath);
        final ImageView apple = (ImageView) findViewById(R.id.appleprice);
        final ImageView varExample = (ImageView) findViewById(R.id.varExample);


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
                    wordBox.setText(getResources().getStringArray(R.array.lesson2)[lineNum]);
                    switch (lineNum){
                        case 1: math.setVisibility(View.VISIBLE); break;
                        case 2: math.setVisibility(View.INVISIBLE);
                        apple.setVisibility(View.VISIBLE); break;
                        case 7: varExample.setVisibility(View.VISIBLE); break;
                    }

                    lineNum++;
                }
            }

        });


    }

}
