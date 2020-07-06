package com.example.theedenv3.ui.friends

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.theedenv3.R
import com.example.theedenv3.data.sample.UserSample


class UserImgAdapter(private val groupmemberlist: ArrayList<UserSample>, private val  mContext: Context?) :
    BaseAdapter() {
//    private val Placelist: ArrayList<PlaceSample>?
//    private val mContext: Context?
//    private val avatar: Avatar? = null
    override fun getCount(): Int {
        return groupmemberlist.size
    }

    override fun getItem(position: Int): Any? {
        return groupmemberlist[position]
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.userimg_layout, parent, false)
            holder = ViewHolder()
            holder.usr_img =
                convertView!!.findViewById<View?>(R.id.user_img) as ImageView?
            holder.username = convertView.findViewById<View?>(R.id.usr_name) as TextView?
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        if (groupmemberlist[position].UserId != -1){
            Log.i("userImg", groupmemberlist[position].toString())
            holder.usr_img!!.setBackgroundResource(groupmemberlist[position].UserImg)
        }
        holder.username!!.text = groupmemberlist[position].Username
        return convertView
    }

    internal class ViewHolder {
        var usr_img: ImageView? = null
        var username: TextView? = null
    }
}