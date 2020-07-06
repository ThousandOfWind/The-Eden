package com.example.theedenv3.ui.daily

import ImgHelper.getDrawableFromResources
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.theedenv3.util.MyApplication
import com.example.theedenv3.R
import com.example.theedenv3.data.sample.MomentSample

import com.example.theedenv3.ui.newview.CycleView
import com.example.theedenv3.util.ItemClickListener
import kotlinx.android.synthetic.main.moment_card_layout.view.*


class MomentRecyclerViewAdapter(private val samples: ArrayList<MomentSample>, private val listener: ItemClickListener) : RecyclerView.Adapter<MomentRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.moment_card_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = samples[position]
        holder.user_img.color = Color.GRAY
        holder.user_name.text = item.user_name
        holder.punch_time.text = item.punch_time
        holder.imageButton_img.background = getDrawableFromResources(MyApplication.getContext(),item.imageButton_img)
        holder.imageButton_img.setOnClickListener { listener.onItemSelected(position) }
        holder.textView_content.text = item.content
        holder.punchButton.setOnClickListener { listener.onItemSelected(position) }
        holder.encourageButton.setOnClickListener { listener.onItemSelected(position) }

    }

    override fun getItemCount() = samples.size

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val user_img: CycleView = mView.user_img
        val user_name: TextView = mView.user_name
        val punch_time: TextView = mView.punch_time
        val imageButton_img: ImageButton = mView.imageButton_img
        val textView_content: TextView = mView.textView_content
        var punchButton:Button = mView.button_punch_now
        var encourageButton = mView.button_encourage
    }
}