package com.example.andriod.yeswecodeproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        updateQuestion();

        //Buttons
        //Back to Game Selection Button

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent backIntent = new Intent(view.getContext(), GameSelectActivity.class);
                startActivityForResult(backIntent, 0);
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
        scorebox.setText("Score: "+score);
    }

    private void updateQuestion(){
        question.setText(questions.getQuestion(questionNum));

        choiceA.setText(questions.getChoiceA(questionNum));
        choiceB.setText(questions.getChoiceB(questionNum));
        choiceC.setText(questions.getChoiceC(questionNum));
        choiceD.setText(questions.getChoiceD(questionNum));

        answer = questions.getCorrectAnswer(questionNum);
        questionNum++;
    }
}
