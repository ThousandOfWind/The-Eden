package com.example.theedenv3.ui.daily

import ImgHelper.getDrawableFromResources
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import com.example.theedenv3.util.MyApplication
import com.example.theedenv3.R

import com.example.theedenv3.data.sample.TaskSample
import com.example.theedenv3.util.ItemClickListener
import kotlinx.android.synthetic.main.task_card_layout.view.*


class MyTaskRecyclerViewAdapter(private val samples: ArrayList<TaskSample>, private val listener: ItemClickListener) : RecyclerView.Adapter<MyTaskRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_card_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = samples[position]
        holder.taskType.text = item.type.toString()
        holder.taskTitle.text = item.title
        holder.taskDescibe.text = item.describe
        holder.checkBox.isChecked = item.is_star
        holder.img.background = getDrawableFromResources(MyApplication.getContext(),item.img)
        holder.img.setOnClickListener { listener.onItemSelected(position) }
        holder.punchNowButton.setOnClickListener { listener.onItemSelected(position) }
    }

    override fun getItemCount() = samples.size

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val taskType: TextView = mView.textView_task_type
        val taskTitle: TextView = mView.textView_task_tiltle
        val taskDescibe: TextView = mView.textView_task_describe
        val checkBox: CheckBox = mView.checkBox_star
        val img: ImageButton = mView.imageButton_task_img
        var punchNowButton = mView.button_punch
        var ignoreButton = mView.button_ignore
    }
}