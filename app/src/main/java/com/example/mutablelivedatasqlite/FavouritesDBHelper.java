package com.example.mutablelivedatasqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FavouritesDBHelper  extends SQLiteOpenHelper {

    public FavouritesDBHelper(Context context) {
        super(context, DbSettings.DATABASE_NAME, null, DbSettings.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + DbSettings.DBEntry.TABLE_NAME + " ( " +
                DbSettings.DBEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DbSettings.DBEntry.COL_FAV_URL + " TEXT NOT NULL, " +
                DbSettings.DBEntry.COL_FAV_DATE + " INTEGER NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbSettings.DBEntry.TABLE_NAME);
        onCreate(db);
    }
}
