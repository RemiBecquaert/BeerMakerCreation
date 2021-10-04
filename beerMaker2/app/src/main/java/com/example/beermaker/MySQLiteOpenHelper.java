package com.example.beermaker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//debut travail sur sqlite
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private String create = " create table recette (" + "id INTEGER PRIMARY KEY, " + "ebc INTEGER NOT NULL, " + "degre INTEGER NOT NULL, " + "volume INTEGER NOT NULL)";

    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
