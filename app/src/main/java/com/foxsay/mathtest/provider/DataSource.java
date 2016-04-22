package com.foxsay.mathtest.provider;

import android.content.Context;

import com.foxsay.mathtest.model.Task;

/**
 * {@see http://crunchify.com/thread-safe-and-a-fast-singleton-implementation-in-java/}
 *
 * @author roman
 * @since 16.04.2016
 */
public class DataSource {
    private static DataSource instance = null;

    private static MyDatabaseHelper dbHelper;

    private DataSource(Context context){
        dbHelper = new MyDatabaseHelper(context);
    }

    public static void close() {
        if (null != instance && null != dbHelper){
            synchronized (DataSource.class) {
                if (null != instance && null != dbHelper) {
                    dbHelper.close();
                    instance = null;
                }
            }
        }
    }

    // Lazy Initialization (If required then only)
    public static DataSource getInstance(Context context) {
        if (instance == null) {
            // Thread Safe. Might be costly operation in some case
            synchronized (DataSource.class) {
                if (instance == null) {
                    instance = new DataSource(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public void save(Task task){

    }
}
