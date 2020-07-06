package com.example.theedenv2.data

import android.content.Context
import com.example.theedenv2.data.databasehelper.UserDatabaseHelper
import com.example.theedenv2.data.model.User

class UserService(context: Context?) {
    private var id: Int = -1
    private val udbHelper: UserDatabaseHelper

    fun login(username: String, password: String): Boolean {
        val sdb = udbHelper.readableDatabase
        val sql = "select * from user where username=? and password=?"
        val cursor =
            sdb.rawQuery(sql, arrayOf(username, password))
        if (cursor.moveToFirst() == true) {
            this.id= cursor.getInt(cursor.getColumnIndex("id"))
            cursor.close()
            return true
        }
        return false
    }

    fun logout(){
        this.id=-1
    }

    fun is_login(): Boolean{
        if(this.id == -1){
            return false
        }
        return true
    }

    fun have_username(username: String): Boolean {
        val sdb = udbHelper.readableDatabase
        val sql = "select * from user where username=?"
        val cursor = sdb.rawQuery(sql, arrayOf(username))
        if (cursor.moveToFirst() == true) {
            cursor.close()
            return true
        }
        return false
    }

    fun register(user: User): Boolean {
        val sdb = udbHelper.readableDatabase
        val sql = "insert into user(username,password) values(?,?)"
        val obj = arrayOf<Any?>(user.username, user.password)
        sdb.execSQL(sql, obj)
        return true
    }

    init {
        udbHelper = UserDatabaseHelper(context)
    }
}