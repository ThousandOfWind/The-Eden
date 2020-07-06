package com.example.theedenv3.ui.newview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.annotation.ColorInt
import com.example.theedenv3.R
import kotlinx.android.synthetic.main.video_layout.view.*

class VideoView (context: Context)  :
    FrameLayout(context){


    private var user_imgView: ImageView
    var user_img: Int = R.drawable.sample_img
        set(value) {
            field = value
            user_imgView.setImageResource(user_img)
        }

    private var user_nameView: TextView
    var user_name: CharSequence = ""
        set(value) {
            field = value
            user_nameView.text = value
        }

    private var user_clockView:TextView
    var user_clock: CharSequence = ""
        set(value) {
            field = value
            user_clockView.text = value
        }

    private var interest_button:Button
    var interest_text: CharSequence = ""
        set(value) {
            field = value
            interest_button.text = value
        }

    private var videoView: VideoView

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        var height = Math.min((width*1.1) as Int, MeasureSpec.getSize(heightMeasureSpec))
        setMeasuredDimension(width, height)
    }

    init{
        val view = LayoutInflater.from(context).inflate(R.layout.video_layout,this,true)
        user_imgView = view.findViewById(R.id.user_img)
        user_nameView = view.findViewById(R.id.user_name)
        user_clockView = view.findViewById(R.id.user_clock)
        interest_button = view.findViewById(R.id.interest)
        videoView = view.findViewById(R.id.videoView)
    }
}