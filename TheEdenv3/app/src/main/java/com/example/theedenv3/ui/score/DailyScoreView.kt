package com.example.theedenv3.ui.score
import android.content.Context

import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout

import android.widget.TextView
import com.example.theedenv3.ui.newview.CycleView
import com.example.theedenv3.R


class DailyScoreView (context: Context, attrs: AttributeSet? = null) :
    FrameLayout(context,attrs){

    var cycleColor: Int = 0
        set(value) {
            field = value
            cycleView.color = value
        }

    var label: CharSequence? = null
        set(value) {
            field = value
            labelView.text = value
        }

    var labelTextSize: Float = 0f
        set(value) {
            if (value > 0) {
                field = value
                labelView.textSize = value
                scoreView.textSize = value
            }
        }

    var labelTextColor: Int = 0
        set(value) {
            field = value
            labelView.setTextColor(value)
            scoreView.setTextColor(value)
        }

    var score: Int = 0
        set(value) {
            field = value
            scoreView.text = value.toString()
        }

    private var cycleView: CycleView
    private var labelView: TextView
    private var scoreView: TextView


    init{
        val view = LayoutInflater.from(context).inflate(R.layout.score_view_layout,this,true)

        cycleView = view.findViewById(R.id.background)
        labelView = view.findViewById(R.id.label)
        scoreView = view.findViewById(R.id.score)

        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.DailyScoreView)
            cycleColor = typedArray.getColor(R.styleable.DailyScoreView_background_color, 0x7D7DFF.toInt())

            label = typedArray.getText(R.styleable.DailyScoreView_label)
            labelTextSize = typedArray.getFloat(R.styleable.DailyScoreView_label_text_size, 14f)
            labelTextColor = typedArray.getColor(R.styleable.DailyScoreView_label_text_color, 0xff333333.toInt())
            typedArray.recycle()
        }
    }
}