package com.example.andriod.yeswecodeproject;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LessonActivity1 extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);

        final TextView wordBox = (TextView) findViewById(R.id.textbox);

        //Animation ImageViews
        ImageView humanpic = (ImageView) findViewById(R.id.humanlangpic);
        ImageView comppic = (ImageView) findViewById(R.id.complangpic);




        //Buttons
        //Back to Lesson Selection Button
        Button back = (Button) findViewById(R.id.backtoLesSelectButton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });

        //Animation Work
        final ObjectAnimator humanAni = ObjectAnimator.ofFloat(humanpic,"translationY",270f);
        humanAni.setDuration(2000);

        final ObjectAnimator compAni = ObjectAnimator.ofFloat(comppic,"translationY",490f);
        compAni.setDuration(2000);


        //Next Line Button
        Button next = (Button) findViewById(R.id.lessonContinue);
        next.setOnClickListener(new View.OnClickListener() {

            int lineNum = 0;
            public void onClick(View view) {
                if(lineNum<=8) {
                    wordBox.setText(getResources().getStringArray(R.array.lesson1)[lineNum]);
                    if(lineNum==3){
                        humanAni.start();
                    }
                    if(lineNum==4){
                        compAni.start();
                    }
                    lineNum++;
                }
            }

        });



    }

}
