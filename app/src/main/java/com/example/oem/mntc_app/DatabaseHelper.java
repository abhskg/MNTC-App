package com.example.oem.mntc_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Events.db";
    public static final String TABLE_NAME="Events_mstr";
    public static final String COL1="name";
    public static final String COL2="date";
    public static final String COL3="venue";
    public static final String COL4="time";
    public static final String COL5="description";
    public static final String COL6="poster_id";
    public static final String COL7="PK";
    public static final int DATABASE_VERSION=1;


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
