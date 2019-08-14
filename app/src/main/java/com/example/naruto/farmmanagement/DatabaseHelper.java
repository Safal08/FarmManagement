package com.example.naruto.farmmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name ="farmer.db";
    public static final String Table_Name ="farmer_table";
    public static final String Col1 ="ID";
    public static final String Col2 ="NAME";
    public static final String Col3 ="PASSWORD";
    public static final String Col4 ="PHONE";
    public static final String Col5 ="ADDRESS";

    public DatabaseHelper( Context context) {
        super(context, Database_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, PASSWORD TEXT, PHONE NUMBER, TEXT NUMBER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ Table_Name);
        onCreate(db);

    }

    public boolean insert(String email, String password)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.insert("Table_name", null, contentValues);
        if(ins ==-1) return false;
        else return  true;
    }

    public boolean checkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Table_Name + " WHERE " + email + "=?", new String[] { email + "" });
        if (cursor.getCount()>0) return false;
        else return true;

    }
}
