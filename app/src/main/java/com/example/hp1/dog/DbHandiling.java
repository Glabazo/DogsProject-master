package com.example.hp1.dog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hp1 on 20/02/2018.
 */

public class DbHandiling extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Dogs.db";
    public static final String TABLE_NAME="Dogs_Table";

    public static final String COl_1="Id";
    public static final String COL_2="Photo";

    public DbHandiling(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+COl_1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_2+" BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(byte[] bytes){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,bytes);

        db.insert(TABLE_NAME,null,contentValues);
    }

    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("Select * from "+TABLE_NAME,null);
        return res;
    }
}
