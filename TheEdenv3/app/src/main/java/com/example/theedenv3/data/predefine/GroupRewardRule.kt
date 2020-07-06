package com.example.theedenv3.data.predefine

import com.example.theedenv3.R
import java.util.concurrent.locks.Condition

enum class GroupRewardRule(
    val GroupRewardId:Int, val RewardImg:Int, val condition: Int) {

    R1(
        1,
        R.drawable.ic_launcher_foreground,
        1
        ),
    R2(
        2,
        R.drawable.ic_launcher_foreground,
        5
    ),

    R3(
        3,
        R.drawable.ic_launcher_foreground,
        10
    ),

}
