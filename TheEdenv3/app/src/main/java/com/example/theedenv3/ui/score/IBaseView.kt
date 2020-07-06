package com.example.theedenv3.ui.score

import android.content.Context
import android.util.AttributeSet

interface IBaseView {
    //用来初始化view视图
    fun init(context: Context)
    //用来接收xml文件中的自定义属性
    fun retrieveAttributes(attrs: AttributeSet)
}
