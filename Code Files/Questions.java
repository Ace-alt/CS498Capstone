package com.example.andriod.yeswecodeproject;

public class Questions {

    private String Questions []={
            "Test 1: The Answer is A!",
            "Test 2: The Answer is B!",
            "Test 3: The Answer is C!"
    };

    private String Answers[][]={
            {"A:These","B:Variables","C:Can","D:Change"},
            {"A:what","B: a","C:Great","D:Test!"},
            {"A:It's","B:really","C:working","D:Now!"}
    };

    private String Solutions[]={"A:These","B: a","C:working"};

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
