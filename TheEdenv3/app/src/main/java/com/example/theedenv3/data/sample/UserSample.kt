package com.example.theedenv3.data.sample

import com.example.theedenv3.R

enum class UserSample(
    val UserId:Int, val UserImg:Int, val Username:String, val UserLevel: Int, val interest:Boolean, val interested:Boolean) {

    XIAOZHANG(
        0,
        R.drawable.ic_launcher_foreground,
        "XIAOZHANG",
        1,
        true,
        true
    ),
    XIAOWANG(
        0,
        R.drawable.ic_launcher_foreground,
        "XIAOWANG",
        2,
        false,
        true
    ),
    XIAOLEE(
        0,
        R.drawable.ic_launcher_foreground,
        "XIAOLEE",
        3,
        false,
        true
    ),
    XIAOMIN(
        0,
        R.drawable.ic_launcher_foreground,
        "XIAOMIN",
        4,
        false,
        false
    ),

    NEW(
        -1,
        -1,
        "邀请好友",
        -1,
        false,
        false
    ),

}
