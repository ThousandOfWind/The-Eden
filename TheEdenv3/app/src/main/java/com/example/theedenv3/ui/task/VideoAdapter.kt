package com.example.theedenv3.ui.task

import android.content.Context
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.theedenv3.R
import com.example.theedenv3.data.sample.UserSample

class VideoAdapter (private val Userlist: ArrayList<UserSample>, private val  mContext: Context?) :
    BaseAdapter() {
    //    private val Placelist: ArrayList<PlaceSample>?
//    private val mContext: Context?
//    private val avatar: Avatar? = null
    override fun getCount(): Int {
        return Userlist.size
    }

    override fun getItem(position: Int): Any? {
        return Userlist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.video_layout, parent, false)
            holder = ViewHolder()

            holder.user_name = convertView.findViewById<View?>(R.id.user_name) as TextView?
            holder.clock = convertView.findViewById<View?>(R.id.user_clock) as TextView?
            holder.interest = convertView.findViewById<View?>(R.id.interest) as Button?
            holder.user_video = convertView.findViewById<View?>(R.id.videoView) as VideoView?

            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.user_name!!.text = Userlist[position].name
        holder.clock!!.text = "00:00:00"
        if (Userlist[position].interest) {
            holder.interest!!.text = "取消关注"
        }else {
            holder.interest!!.text = "关注"
        }
        return convertView
    }

    internal class ViewHolder {
        var user_video: VideoView? = null
        var user_name: TextView? = null
        var clock: TextView? = null
        var interest: Button? = null
    }

}