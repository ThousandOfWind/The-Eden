package com.example.theedenv3.data.sample

import com.example.theedenv3.R

enum class TaskSample(
    val taskId:Int, val type:Int, val title:String, val img:Int, val describe:String,
    val is_star:Boolean, val is_ignore:Boolean, val time:Int, val is_group_task:Boolean) {

    BEDROOM_TASK(
        0,
        R.string.score_bedroom,
        "起床",
        R.drawable.ic_launcher_foreground,
        "...",
        true,
        false,
        1,
        true
    ),
    GYM_TASK(
        0,
        R.string.score_gym,
        "跳绳",
        R.drawable.ic_launcher_foreground,
        "...",
        true,
        false,
        0,
        true
    ),
    KITCHEN_TASK(
        0,
        R.string.score_kitchen,
        "土豆泥",
        R.drawable.ic_launcher_foreground,
        "...",
        false,
        true,
        0,
        false
    ),
    STUDY_TASK(
        0,
        R.string.score_kitchen,
        "自习",
        R.drawable.ic_launcher_foreground,
        "...",
        false,
        false,
        0,
        false
    ),
}
