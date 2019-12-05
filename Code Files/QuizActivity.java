package com.example.andriod.yeswecodeproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    private TextView question;
    private TextView scorebox;
    private String answer;
    private int score = 0;
    private Questions questions = new Questions();
    private int questionNum = 0;
    private Button choiceA;
    private Button choiceB;
    private Button choiceC;
    private Button choiceD;

    ImageView question1;
    ImageView question2;
    ImageView question34;
    ImageView question5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        question = (TextView) findViewById(R.id.questionbox);
        scorebox = (TextView) findViewById(R.id.scorebox);
        Button back = (Button) findViewById(R.id.backtogameSelectButton);
        choiceA = (Button) findViewById(R.id.choiceA);
        choiceB = (Button) findViewById(R.id.choiceB);
        choiceC = (Button) findViewById(R.id.choiceC);
        choiceD = (Button) findViewById(R.id.choiceD);

        question1 = (ImageView) findViewById(R.id.question1Image);
        question2 = (ImageView) findViewById(R.id.question2Image);
        question34 = (ImageView) findViewById(R.id.question34Image);
        question5 = (ImageView) findViewById(R.id.question5Image);

        updateQuestion();

        //Back to Game Selection Button

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
                score = 0;
                questionNum = 1;
            }

        });


        //Multiple Choice Buttons

        choiceA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(choiceA.getText()==answer){
                    score = score +10;
                    scoreUpdate(score);
                    updateQuestion();
                }
            }

        });

        choiceB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(choiceB.getText()==answer){
                    score = score +10;
                    scoreUpdate(score);
                    updateQuestion();
                }
            }

        });

        choiceC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(choiceC.getText()==answer){
                    score = score +10;
                    scoreUpdate(score);
                    updateQuestion();
                }
            }

        });

        choiceD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(choiceD.getText()==answer){
                    score = score +10;
                    scoreUpdate(score);
                    updateQuestion();
                }
            }

        });


    }


    private void scoreUpdate(int points){
        scorebox.setText("Score: "+score+"/50");
    }

    private void updateQuestion(){

        if(questionNum==0){ question1.setVisibility(View.VISIBLE);}
        if(questionNum==1){  question1.setVisibility(View.INVISIBLE); question2.setVisibility(View.VISIBLE);}
        if(questionNum==2){ question2.setVisibility(View.INVISIBLE);question34.setVisibility(View.VISIBLE);}
        if(questionNum==4){ question34.setVisibility(View.INVISIBLE);question5.setVisibility(View.VISIBLE);}

        if(questionNum<5){
            question.setText(questions.getQuestion(questionNum));

            choiceA.setText(questions.getChoiceA(questionNum));
            choiceB.setText(questions.getChoiceB(questionNum));
            choiceC.setText(questions.getChoiceC(questionNum));
            choiceD.setText(questions.getChoiceD(questionNum));

            answer = questions.getCorrectAnswer(questionNum);
            questionNum++;
        }
    }
}
