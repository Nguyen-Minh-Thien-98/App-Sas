package com.example.educationapp.Game.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.educationapp.Game.Model.m_Level;
import com.example.educationapp.Game.Model.m_User;


public class Databasehelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "DATABASE";
    public static final String TABLE_NAME = "LEVEL";
    public int DATABASE_VERSION = 1;
    public static final  String COL_1 = "ID";
    public Context context;
    public Databasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // tạo bảng database offline level
        String create_level_table = ("CREATE TABLE LEVEL(" +
                "ID INT PRIMARY KEY," +
                "LEVELNAME TEXT," +
                "PASS INT)");
        db.execSQL(create_level_table);

        // tạo bản offline user
        String create_user_table = ("CREATE TABLE USER(" +
                "IDUSER INT PRIMARY KEY," +
                "LEVELHOMEQUIZ INT)");
        db.execSQL(create_user_table);
//        Toast.makeText(context, "Tạo bảng Level thành công",Toast.LENGTH_LONG).show();
        // thêm giá trị vào bảng database offline
        db.execSQL("INSERT INTO " + "LEVEL"+ "(ID, LEVELNAME, PASS) VALUES (1,'LEVEL 1',0)");
        db.execSQL("INSERT INTO " + "LEVEL"+ "(ID, LEVELNAME, PASS) VALUES (2,'LEVEL 2',0)");
        db.execSQL("INSERT INTO " + "LEVEL"+ "(ID, LEVELNAME, PASS) VALUES (3,'LEVEL 3',0)");
        db.execSQL("INSERT INTO " + "LEVEL"+ "(ID, LEVELNAME, PASS) VALUES (4,'LEVEL 4',0)");
        db.execSQL("INSERT INTO " + "LEVEL"+ "(ID, LEVELNAME, PASS) VALUES (5,'LEVEL 5',0)");
        db.execSQL("INSERT INTO " + "LEVEL"+ "(ID, LEVELNAME, PASS) VALUES (6,'LEVEL 6',0)");
        db.execSQL("INSERT INTO " + "LEVEL"+ "(ID, LEVELNAME, PASS) VALUES (7,'LEVEL 7',0)");
        db.execSQL("INSERT INTO " + "LEVEL"+ "(ID, LEVELNAME, PASS) VALUES (8,'LEVEL 8',0)");
        db.execSQL("INSERT INTO " + "LEVEL"+ "(ID, LEVELNAME, PASS) VALUES (9,'LEVEL 9',0)");
        db.execSQL("INSERT INTO " + "LEVEL"+ "(ID, LEVELNAME, PASS) VALUES (10,'LEVEL 10',0)");
        //thêm dữ liệu User
        db.execSQL("INSERT INTO " + "USER"+ "(IDUSER, LEVELHOMEQUIZ) VALUES (1,1)");
//        Toast.makeText(context, "Thêm giá trị vào bảng Level thành công",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS LEVEL");
    }

    //ReadDatabase level
    public m_Level getLevelID(int levelid) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + "LEVEL" + " WHERE "
                + "ID" + " = " + levelid;



        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        m_Level level = new m_Level();
        level.setId(c.getInt(c.getColumnIndex("ID")));
        level.setLevelname(String.valueOf(c.getColumnIndex("LEVELNAME")));
        level.setPass(c.getColumnIndex("PASS"));
        return level;
    }

    //UpdataDatabase level
    public void updatelevel(m_Level level){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("ID",level.getId());
        cv.put("LEVELNAME",level.getLevelname());
        cv.put("PASS",level.getPass());
        db.update("LEVEL",cv,"ID="+level.getId(),null);
    }

    // Đọc dữ liệu của người dùng
    public m_User getUserfromID(int userid) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + "USER" + " WHERE "
                + "IDUSER" + " = " + userid;



        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        m_User user = new m_User();
        user.setIduser(c.getInt(c.getColumnIndex("IDUSER")));
        user.setLevelhomequiz(c.getInt(c.getColumnIndex("LEVELHOMEQUIZ")));
        return user;
    }

    //Update dữ liệu người

    public void updateUser(m_User user){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("IDUSER",user.getIduser());
        cv.put("LEVELHOMEQUIZ",user.getLevelhomequiz());
        db.update("USER",cv,"IDUSER="+user.getIduser(),null);
    }





}
