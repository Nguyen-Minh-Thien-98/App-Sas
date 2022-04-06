package com.example.educationapp.Game.Model;

public class m_Question {
    public int questionid;
    public int type;
    public String questioncontent;
    public String choice1;
    public String choice2;
    public String choice3;
    public String choice4;
    public String correctchoice;

    public m_Question() {
    }

    public m_Question(int questionid, int type, String questioncontent, String choice1, String choice2, String choice3, String choice4, String correctchoice) {
        this.questionid = questionid;
        this.type = type;
        this.questioncontent = questioncontent;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.correctchoice = correctchoice;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getQuestioncontent() {
        return questioncontent;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getCorrectchoice() {
        return correctchoice;
    }

    public void setCorrectchoice(String correctchoice) {
        this.correctchoice = correctchoice;
    }
}
