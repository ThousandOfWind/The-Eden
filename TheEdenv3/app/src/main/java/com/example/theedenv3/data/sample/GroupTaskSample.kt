package com.example.theedenv3.data.sample

import com.example.theedenv3.R

enum class GroupTaskSample(
    val taskId:Int, val type:Int, val title:String, val img:Int, val describe:String,
    val is_star:Boolean, val finish:Int, val is_group_task:Boolean=true) {

    BEDROOM_TASK(
        0,
        R.string.score_bedroom,
        "起床",
        R.drawable.ic_launcher_foreground,
        "...",
        true,
        0
    ),
    GYM_TASK(
        0,
        R.string.score_gym,
        "慢跑",
        R.drawable.ic_launcher_foreground,
        "...",
        true,
        0
    ),
}
