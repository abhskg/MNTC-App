package com.example.oem.mntc_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME="Events.db";
    public static String TABLE_NAME="Events_mstr";
    public static String COL1="name";
    public static String COL2="date";
    public static String COL3="venue";
    public static String COL4="time";
    public static String COL5="description";
    public static String COL6="poster_id";
    public static String COL7="PK";


    public DatabaseHelper(Context context,String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Command for creating table during the first time
        db.execSQL("create table " + TABLE_NAME + " (PK INT PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL, date DATE, venue TEXT, time BLOB, description TEXT NOT NULL, poster_id INT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion)
    {
        db.execSQL("'DROP TABLE IF EXISTS'" + TABLE_NAME);
        onCreate(db);
    }
}
