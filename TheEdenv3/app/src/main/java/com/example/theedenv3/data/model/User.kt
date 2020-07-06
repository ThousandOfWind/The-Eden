package com.example.theedenv2.data.model

import java.io.Serializable

class User : Serializable {
    @kotlin.jvm.JvmField
    var username: String? = null
    var password: String? = null
    var id = 0
    var age = 0
    var sex: String? = null

    constructor() : super() { // TODO Auto-generated constructor stub
    }

    constructor(
        username: String?,
        password: String?,
        age: Int,
        sex: String?
    ) : super() {
        this.username = username
        this.password = password
        this.age = age
        this.sex = sex
    }

    override fun toString(): String {
        return ("User [id=" + id + ", username=" + username + ", password="
                + password + ", age=" + age + ", sex=" + sex + "]")
    }
}