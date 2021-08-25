package com.example.reservations;

import android.provider.BaseColumns;

public class StadiumContract {
    private StadiumContract() {
    }

    public static class StadiumEntry implements BaseColumns{
        public static final String TABLE_NAME = "stadium";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_address = "address";
        public static final String COLUMN_telnum = "telnum";
        public static final String COLUMN_num = "num";
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS" + TABLE_NAME + " (" + _ID + "INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT," + COLUMN_address + "TEXT," + COLUMN_telnum + " TEXT," + COLUMN_num + "INTEGER) ";
        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

    }
}
