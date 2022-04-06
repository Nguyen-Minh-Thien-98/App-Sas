package com.example.educationapp.Game.Model;

public class m_User {
    public int iduser;
    public int levelhomequiz;

    public m_User() {
    }

    public m_User(int iduser, int levelhomequiz) {
        this.iduser = iduser;
        this.levelhomequiz = levelhomequiz;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getLevelhomequiz() {
        return levelhomequiz;
    }

    public void setLevelhomequiz(int levelhomequiz) {
        this.levelhomequiz = levelhomequiz;
    }
}
