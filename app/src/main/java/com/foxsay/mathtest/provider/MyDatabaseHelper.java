package com.foxsay.mathtest.provider;

import static com.foxsay.mathtest.provider.MyContract.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author roman
 * @since 17.04.2016
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mathtest.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO: реализовать создание таблиц
        db.execSQL("CREATE TABLE " + Tables.TASKS + " ("
                + TaskColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TaskColumns.SECTION + " TEXT NOT NULL,"
                + TaskColumns.SUB_SECTION + " TEXT NOT NULL,"
                + TaskColumns.GROUP + " TEXT NOT NULL,"
                + TaskColumns.QUESTION + " TEXT NOT NULL,"
                + TaskColumns.QUESTION_IMG + " TEXT NOT NULL,"
                + TaskColumns.QUESTION_VIEW_TYPE + " TEXT NOT NULL,"
                + TaskColumns.ONE_ANSWER + " INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
