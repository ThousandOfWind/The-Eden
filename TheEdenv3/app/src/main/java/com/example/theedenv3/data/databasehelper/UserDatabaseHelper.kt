package com.example.theedenv2.data.databasehelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDatabaseHelper(context: Context?) : SQLiteOpenHelper(
    context,
    name,
    null,
    dbVersion
) {
    override fun onCreate(db: SQLiteDatabase) {
        val sql =
            "create table user(id integer primary key autoincrement,username varchar(20),password varchar(20))"
        db.execSQL(sql)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
    }

    companion object {
        var name = "user.db"
        var dbVersion = 1
    }
}