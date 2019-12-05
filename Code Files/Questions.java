package com.example.andriod.yeswecodeproject;

public class Questions {

    private String Questions []={
            "Which value best fits this variable?",
            "When will this loop stop? At:",
            "How many times will the else statement be true?",
            "What type of statements are in this method?",
            "Which of these languages are a computer language?"
    };

    private String Answers[][]={
            {"0","False","Science","Blue"},
            {"x = 2","x = 3","x = 4","x = 5"},
            {"Never","Once","Twice","3 Times"},
            {"If/Else Only","Loop Only","No Statement","If/Else & Loop"},
            {"C++", "Python", "Java", "All of the Above"}
    };

    private String Solutions[]={"Science","x = 4","Never","If/Else & Loop","All of the Above"};

    public String getQuestion(int a){
        String question = Questions[a];
        return question;
    }


    public String getChoiceA(int a) {
        String choice0 = Answers[a][0];
        return choice0;
    }


    public String getChoiceB(int a) {
        String choice1 = Answers[a][1];
        return choice1;
    }

    public String getChoiceC(int a) {
        String choice2 = Answers[a][2];
        return choice2;
    }

    public String getChoiceD(int a) {
        String choice2 = Answers[a][3];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = Solutions[a];
        return answer;
    }
}
