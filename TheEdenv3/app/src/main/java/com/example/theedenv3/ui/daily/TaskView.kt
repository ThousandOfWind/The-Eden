package com.example.theedenv3.ui.daily

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.widget.*
import com.example.theedenv3.R
//import com.example.theedenv3.util.ImgHelper

class TaskView (context: Context) :
    FrameLayout(context){



    private var taskView_task_type: TextView
    var task_type: CharSequence? = null
        set(value) {
            field = value
            taskView_task_type.text = value
        }

    private var checkBox_star: CheckBox
    var is_star: Boolean = false
        set(value) {
            field = value
            checkBox_star.isChecked = value
        }

    private var button_img: ImageButton
    var task_img: Drawable = ImgHelper.getDrawableFromResources(context, R.drawable.ic_launcher_foreground)
        set(value) {
            field = value
            button_img.background = value
        }

    private var taskView_decribe: TextView
    var task_decribe: CharSequence? = null
        set(value) {
            field = value
            taskView_decribe.text = value
        }

    private var button_punch: Button
    private var button_ignore: Button


    init{
        val view = LayoutInflater.from(context).inflate(R.layout.task_card_layout,this,true)

        taskView_task_type = view.findViewById(R.id.textView_task_type)
        checkBox_star = view.findViewById(R.id.checkBox_star)
        button_img = view.findViewById(R.id.imageButton_task_img)
        taskView_decribe = view.findViewById(R.id.textView_task_describe)
        button_punch = view.findViewById(R.id.button_punch)
        button_ignore = view.findViewById(R.id.button_encourage)
    }
}