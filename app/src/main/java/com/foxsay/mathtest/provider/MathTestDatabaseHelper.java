package com.foxsay.mathtest.provider;

import static com.foxsay.mathtest.provider.MathTestContract.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * @author roman
 * @since 17.04.2016
 */
public class MathTestDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mathtest.db";
    private static final int DATABASE_VERSION = 1;

    public MathTestDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO: реализовать создание таблиц
        db.execSQL("CREATE TABLE " + Tables.TASKS + " ("
                + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TaskColumns.TASK_ID + " INTEGER NOT NULL,"
                + TaskColumns.SECTION + " TEXT NOT NULL,"
                + TaskColumns.SUB_SECTION + " TEXT NOT NULL,"
                + TaskColumns.GROUP + " TEXT NOT NULL,"
                + TaskColumns.QUESTION + " TEXT NOT NULL,"
                + TaskColumns.QUESTION_IMG + " TEXT NOT NULL,"
                + TaskColumns.QUESTION_VIEW_TYPE + " TEXT NOT NULL,"
                + TaskColumns.ONE_ANSWER + " INTEGER NOT NULL,"
                + "UNIQUE (" + TaskColumns.TASK_ID + ") ON CONFLICT REPLACE)");

        db.execSQL("CREATE TABLE " + Tables.ANSWERS + " ("
                + AnswerColumns.TASK_ID + " INTEGER NOT NULL,"
                + AnswerColumns.ANSWER + " TEXT NOT NULL,"
                + AnswerColumns.CORRECT + " INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE " + Tables.TESTS + " ("
                + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TestColumns.TEST_ID + " INTEGER NOT NULL,"
                + TestColumns.DATE + " TEXT NOT NULL,"
                + TestColumns.TIME + " INTEGER NOT NULL,"
                + TestColumns.GRADE + " TEXT NOT NULL,"
                + "UNIQUE (" + TestColumns.TEST_ID + ") ON CONFLICT REPLACE)");

        db.execSQL("CREATE TABLE " + Tables.TEST_TASK_ANSWERS + " ("
                + TestTaskAnswersColumns.TEST_ID + " INTEGER NOT NULL,"
                + TestTaskAnswersColumns.TASK_ID + " INTEGER NOT NULL,"
                + TestTaskAnswersColumns.ANSWER + " INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
