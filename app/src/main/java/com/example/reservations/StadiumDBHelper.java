package com.example.reservations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class StadiumDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "database";
    public static final int DATABASE_VERSION = 1;

   public StadiumDBHelper(Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

   public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL(StadiumContract.StadiumEntry.SQL_CREATE_TABLE);
   }

   public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
       sqLiteDatabase.execSQL(StadiumContract.StadiumEntry.SQL_DELETE_TABLE);
       onCreate(sqLiteDatabase);
   }

   void insertRecord(String name, String address, String telnum, int num) {
       SQLiteDatabase db = getReadableDatabase();

       ContentValues values = new ContentValues();
       values.put(StadiumContract.StadiumEntry.COLUMN_NAME, name);
       values.put(StadiumContract.StadiumEntry.COLUMN_address, address);
       values.put(StadiumContract.StadiumEntry.COLUMN_telnum, telnum);
       values.put(StadiumContract.StadiumEntry.COLUMN_num, num);

       db.insert(StadiumContract.StadiumEntry.TABLE_NAME,null, values);


   }

   public Cursor readRecordOrderByNum() {
       SQLiteDatabase db = getReadableDatabase();
       String[] projection = {
               BaseColumns._ID,
               StadiumContract.StadiumEntry.COLUMN_NAME,
               StadiumContract.StadiumEntry.COLUMN_address,
               StadiumContract.StadiumEntry.COLUMN_telnum,
               StadiumContract.StadiumEntry.COLUMN_num

       };

       String sortOrder = StadiumContract.StadiumEntry.COLUMN_num + "ASC";

       Cursor cursor = db.query(
               StadiumContract.StadiumEntry.TABLE_NAME,
               projection,
               null,
               null,
               null,
               null,
               sortOrder
       );

       return cursor;
   }
}

