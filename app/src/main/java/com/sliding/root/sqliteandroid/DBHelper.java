package com.sliding.root.sqliteandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 06/10/15.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "crud.db";
    public static final int DATABASE_VARSION = 4;
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VARSION);
    }
    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VARSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_STUDENT = "CREATE TABLE " + Student.TABLE_NAME  + "("
                + Student.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Student.KEY_NAME + " TEXT, "
                + Student.KEY_AGE + " INTEGER, "
                + Student.KEY_EMAIL + " TEXT )";

        db.execSQL(CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Student.TABLE_NAME);
        onCreate(db);
    }
}
