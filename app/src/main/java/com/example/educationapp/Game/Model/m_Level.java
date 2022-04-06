package com.example.educationapp.Game.Model;

public class m_Level {
    int id;
    String levelname;
    int pass;

    public m_Level() {
    }

    public m_Level(int id, String levelname, int pass) {
        this.id = id;
        this.levelname = levelname;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
}
