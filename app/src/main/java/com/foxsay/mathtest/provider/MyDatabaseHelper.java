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

        db.execSQL("CREATE TABLE " + Tables.TASK_ANSWERS + " ("
                + TaskAnswerColumns.TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TaskAnswerColumns.ANSWER + " INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE " + Tables.POSSIBLE_TASK_ANSWERS + " ("
                + PossibleTaskAnswersColumns.TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PossibleTaskAnswersColumns.ANSWER + " INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE " + Tables.TESTS + " ("
                + TestColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TestColumns.DATE + " TEXT NOT NULL,"
                + TestColumns.TIME + " INTEGER NOT NULL,"
                + TestColumns.GRADE + " TEXT NOT NULL,");

        db.execSQL("CREATE TABLE " + Tables.TEST_TASK_ANSWERS + " ("
                + TestTaskAnswersColumns.TEST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TestTaskAnswersColumns.TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TestTaskAnswersColumns.ANSWER + " INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
