package com.mirea.kt.practice2_10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PhoneDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "phone.db";
    private static final int DATABASE_VERSION = 1;

    public PhoneDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE phones (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "model TEXT, " +
                "serial_number TEXT, " +
                "price INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS phones");
        onCreate(db);
    }
}
