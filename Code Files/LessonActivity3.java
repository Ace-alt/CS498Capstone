package com.example.andriod.yeswecodeproject;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LessonActivity3 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);

        final TextView wordBox = (TextView) findViewById(R.id.textbox);
        final ImageView returnpic = (ImageView) findViewById(R.id.returnpic);
        final ImageView stringpic = (ImageView) findViewById(R.id.stringpic);
        final ImageView mainpic = (ImageView) findViewById(R.id.mainpic);
        final ImageView rootpic = (ImageView) findViewById(R.id.rootpic);

        returnpic.setVisibility(View.VISIBLE);
        stringpic.setVisibility(View.VISIBLE);
        mainpic.setVisibility(View.VISIBLE);
        rootpic.setVisibility(View.VISIBLE);


        //Buttons
        //Back to Lesson Selection Button
        Button back = (Button) findViewById(R.id.backtoLesSelectButton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });

        //Animation set 1
        final ObjectAnimator returnAni = ObjectAnimator.ofFloat(returnpic,"rotation",0f,-15f);
        returnAni.setDuration(2000);
        final ObjectAnimator stringAni = ObjectAnimator.ofFloat(stringpic,"rotation",0f,15f);
        stringAni.setDuration(2000);
        final ObjectAnimator mainAni = ObjectAnimator.ofFloat(mainpic,"rotation",0f,-15f);
        mainAni.setDuration(2000);
        final ObjectAnimator rootAni = ObjectAnimator.ofFloat(rootpic,"rotation",0f,15f);
        rootAni.setDuration(2000);

        returnAni.start();
        mainAni.start();
        rootAni.start();
        stringAni.start();

        //Animation set 2
        final ImageView truepic = (ImageView) findViewById(R.id.truepic);
        final ImageView falsepic = (ImageView) findViewById(R.id.falsepic);
        final ImageView ifpic = (ImageView) findViewById(R.id.ifpic);
        final ImageView elsepic = (ImageView) findViewById(R.id.elsepic);


        //Animation set 3 & 4
        final ImageView rainpic = (ImageView) findViewById(R.id.rainpic);
        final ImageView raincode = (ImageView) findViewById(R.id.raincode);

        //Next Line Button
        Button next = (Button) findViewById(R.id.lessonContinue);
        next.setOnClickListener(new View.OnClickListener() {
            int lineNum = 0;
            public void onClick(View view) {
                if(lineNum<=7) {
                    wordBox.setText(getResources().getStringArray(R.array.lesson3)[lineNum]);
                    switch(lineNum){
                        case 1:
                            //remove old animations
                            returnpic.setVisibility(View.INVISIBLE);
                            stringpic.setVisibility(View.INVISIBLE);
                            mainpic.setVisibility(View.INVISIBLE);
                            rootpic.setVisibility(View.INVISIBLE);
                            //display new images
                            truepic.setVisibility(View.VISIBLE);
                            falsepic.setVisibility(View.VISIBLE);
                            ifpic.setVisibility(View.VISIBLE);
                            elsepic.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            truepic.setVisibility(View.INVISIBLE);
                            falsepic.setVisibility(View.INVISIBLE);
                            ifpic.setVisibility(View.INVISIBLE);
                            elsepic.setVisibility(View.INVISIBLE);

                            rainpic.setVisibility(View.VISIBLE);
                            break;

                        case 3:
                            rainpic.setVisibility(View.INVISIBLE);

                            raincode.setVisibility(View.VISIBLE);
                            break;
                    }
                    lineNum++;
                }
            }

        });


    }
}
