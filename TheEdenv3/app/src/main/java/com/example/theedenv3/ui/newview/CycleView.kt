package com.example.theedenv3.ui.newview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import com.example.theedenv3.R


class CycleView @JvmOverloads constructor(context: Context,
                                           attrs: AttributeSet? = null,
                                           defStyleAttr: Int = 0) : View(context,attrs,defStyleAttr){

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    @ColorInt
    var color: Int = Color.RED
        set(value) {
            field = value
            paint.color = value
        }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var viewWidth = width - paddingLeft - paddingRight
        var viewHeight = height - paddingTop - paddingBottom
        var radius = Math.min(viewHeight,viewWidth)/2f
        canvas?.drawCircle(width/2f,height/2f,radius,paint)
    }
}