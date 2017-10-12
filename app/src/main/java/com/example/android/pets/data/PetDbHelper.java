package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by Vikram kumar on 20/08/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    /**Name of the database file*/
    private static final String DATABASE_NAME = "shelter.db";
    /**
     * Database version. if you change the database schema , you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public PetDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    /**
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        /** create a string that contains the sql statement*/
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + "("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL,"
                + PetEntry.COLUMN_PET_BREED + " TEXT,"
                + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL,"
                + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
