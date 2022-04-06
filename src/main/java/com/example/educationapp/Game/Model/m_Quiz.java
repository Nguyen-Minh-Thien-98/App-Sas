package com.example.educationapp.Game.Model;

public class m_Quiz {
    public String quizid;
    public String questionid;
    public String quizname;


    public m_Quiz() {
    }

    public m_Quiz(String quizid, String questionid, String quizname) {
        this.quizid = quizid;
        this.questionid = questionid;
        this.quizname = quizname;
    }

    public String getQuizid() {
        return quizid;
    }

    public void setQuizid(String quizid) {
        this.quizid = quizid;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public String getQuizname() {
        return quizname;
    }

    public void setQuizname(String quizname) {
        this.quizname = quizname;
    }
}
