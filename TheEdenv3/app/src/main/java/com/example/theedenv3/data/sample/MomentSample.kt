package com.example.theedenv3.data.sample

import com.example.theedenv3.R

enum class MomentSample(
    val user_img:Int, val user_name:String, val punch_time:String, val imageButton_img:Int, val content:String) {

    SAMPLE_1(
        R.drawable.ic_notifications_black_24dp,
        "xiao zhang",
        "XyueXri 00:00",
        R.drawable.ic_launcher_foreground,
        "xiao zhang wu hua ke shuo"
    ),
    SAMPLE_2(
        R.drawable.ic_notifications_black_24dp,
        "xiao wang",
        "XyueXri 00:00",
        R.drawable.ic_launcher_foreground,
        "xiao wang ye wu hua ke shuo"
    ),
}
