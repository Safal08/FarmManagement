package com.example.naruto.farmmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class  DbHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "farmer.db";
    public static final String CONTACTS_TABLE_NAME = "farmer";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "username";
    public static final String CONTACTS_COLUMN_ADDRESS = "address";
    public static final String CONTACTS_COLUMN_CONTACT = "contact";
    public static final String CONTACTS_COLUMN_PWD = "password";

    public DbHelper(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +CONTACTS_TABLE_NAME+ "(id integer primary key autoincrement, username text,address text, password password,contact text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF  Exists contacts");
        onCreate(db);
    }

    public boolean insertData(String username, String address, String password, String contact) {
        SQLiteDatabase sq = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CONTACTS_COLUMN_NAME, username);
        contentValues.put(CONTACTS_COLUMN_ADDRESS,address);
        contentValues.put(CONTACTS_COLUMN_CONTACT, contact);
        contentValues.put(CONTACTS_COLUMN_PWD, password);

        long result = sq.insert(CONTACTS_TABLE_NAME, null, contentValues );
        if(result == -1) {
            return  false;
        }
        else {
            return true;
        }
    }
    public boolean updateData(Integer id, String username, String contact, String password, String address, Double Sring){
        //update in database
        SQLiteDatabase sq = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CONTACTS_COLUMN_NAME, username);
        contentValues.put(CONTACTS_COLUMN_ADDRESS,address);
        contentValues.put(CONTACTS_COLUMN_CONTACT, contact);
        contentValues.put(CONTACTS_COLUMN_PWD, password);
        sq.update(CONTACTS_TABLE_NAME, "id=?" , new String[] {(Sring.valueOf(id)});
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Cursor retriveData() {
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from " + CONTACTS_TABLE_NAME, null);
        return cur;
    }
}