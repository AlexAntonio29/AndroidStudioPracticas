package com.angel.gestordeincentivos;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseUser extends SQLiteOpenHelper{

    private static final String TABLE_USER="id";
    private static final String DATABASE_NAME="mydatabaseuser.db";
    private static final int DATABASE_VERSION = 1;
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_RFC = "rfc";
    private static final String COLUMN_NUMCONTROL = "control";


    public DataBaseUser(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_RFC + " TEXT,"
                + COLUMN_NUMCONTROL+ " TEXT,"
                + COLUMN_AGE + " INTEGER)";
        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}
