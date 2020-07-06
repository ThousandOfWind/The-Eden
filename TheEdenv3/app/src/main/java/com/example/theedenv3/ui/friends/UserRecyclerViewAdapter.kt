package com.example.theedenv3.ui.friends

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.theedenv3.R

import com.example.theedenv3.data.sample.UserSample
import com.example.theedenv3.util.ItemClickListener
import kotlinx.android.synthetic.main.user_layout.view.*


class UserRecyclerViewAdapter(private val samples: ArrayList<UserSample>, private val listener: ItemClickListener) : RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = samples[position]

        holder.usr_img.setImageResource(item.UserImg)
        holder.textView_username.text = item.Username
        holder.textView_userlevel.text = "Level: ${item.UserLevel.toString()}"
        if (item.interest and item.interested){
            holder.button_interest.text = "互相关注"
        }else{
            if (item.interest){
                holder.button_interest.text = "不再关注"
            }else{
                holder.button_interest.text = "关注"
            }
        }
        holder.button_interest.setOnClickListener { listener.onItemSelected(position) }
    }

    override fun getItemCount() = samples.size

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val usr_img:ImageView = mView.user_img
        val textView_username:TextView = mView.textView_username
        val textView_userlevel:TextView = mView.textView_userlevel
        val button_interest:Button = mView.button_interest
    }
}