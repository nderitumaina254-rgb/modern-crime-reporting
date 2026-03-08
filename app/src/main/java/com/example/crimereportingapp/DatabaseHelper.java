package com.example.crimereportingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context,"CrimeApp.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users(" +
                "fullname TEXT," +
                "email TEXT," +
                "username TEXT PRIMARY KEY," +
                "password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS users");
    }

    public boolean insertUser(String fullname,String email,String username,String password){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("fullname",fullname);
        cv.put("email",email);
        cv.put("username",username);
        cv.put("password",password);

        long result=db.insert("users",null,cv);

        return result!=-1;
    }

    public boolean checkUser(String username,String password){

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(
                "SELECT * FROM users WHERE username=? AND password=?",
                new String[]{username,password});

        return cursor.getCount()>0;
    }
}