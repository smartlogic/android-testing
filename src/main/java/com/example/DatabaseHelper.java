package com.example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int SCHEMA = 1;

    public DatabaseHelper(Context context) {
        super(context, "myapp", null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.beginTransaction();

            db.execSQL("CREATE TABLE items (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);");

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersionId, int newVersionId) {
        throw new RuntimeException("Shouldn't be upgrading");
    }
}
