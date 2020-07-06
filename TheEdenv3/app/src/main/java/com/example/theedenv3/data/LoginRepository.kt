package com.example.theedenv2.data

import android.util.Log
import com.example.theedenv2.data.model.User

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val userService: UserService) {

    // in-memory cache of the loggedInUser object
    var user: User? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        userService.logout()
    }

    fun login(username: String, password: String): Boolean {
        // handle login
        if(! userService.have_username(username)){
            Log.i("login","user ${username} have not regist")
            return false
        }
        if (userService.login(username, password)) {
            Log.i("login","user ${username} login now")
            return true
        }
        Log.i("login","user ${username} wrong password")
        return false
    }

    private fun setLoggedInUser(user: User) {
        this.user = user
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}
