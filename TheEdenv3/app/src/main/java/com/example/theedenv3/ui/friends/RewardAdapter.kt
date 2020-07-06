package com.example.theedenv3.ui.friends

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.theedenv3.R
import com.example.theedenv3.data.predefine.GroupRewardRule
import com.example.theedenv3.data.sample.PlaceSample
import com.example.theedenv3.data.sample.UserSample


class RewardAdapter(private val rulelist: ArrayList<GroupRewardRule>, private val  mContext: Context?) :
    BaseAdapter() {
//    private val Placelist: ArrayList<PlaceSample>?
//    private val mContext: Context?
//    private val avatar: Avatar? = null
    override fun getCount(): Int {
        return rulelist.size
    }

    override fun getItem(position: Int): Any? {
        return rulelist[position]
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.groupreward_layout, parent, false)
            holder = ViewHolder()
            holder.rew_img =
                convertView!!.findViewById<View?>(R.id.rew_img) as ImageView?
            holder.rew_condition = convertView.findViewById<View?>(R.id.rew_condition) as TextView?
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.rew_img!!.setBackgroundResource(rulelist[position].RewardImg)
        holder.rew_condition!!.text = "${rulelist[position].condition}分"
        return convertView
    }

    internal class ViewHolder {
        var rew_img: ImageView? = null
        var rew_condition: TextView? = null
    }
}