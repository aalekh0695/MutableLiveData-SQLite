package com.example.mutablelivedatasqlite;

import android.provider.BaseColumns;

public class DbSettings {
    public static final String DATABASE_NAME = "favourites.db";
    public static final int DATABASE_VERSION = 1;

    public class DBEntry implements BaseColumns{
        public static final String TABLE_NAME = "fav";
        public static final String COL_FAV_URL = "url";
        public static final String COL_FAV_DATE = "date";
    }
}
