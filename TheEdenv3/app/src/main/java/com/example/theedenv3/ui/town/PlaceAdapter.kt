package com.example.theedenv3.ui.town

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.theedenv3.R
import com.example.theedenv3.data.sample.PlaceSample


class PlaceAdapter(private val Placelist: ArrayList<PlaceSample>, private val  mContext: Context?) :
    BaseAdapter() {
//    private val Placelist: ArrayList<PlaceSample>?
//    private val mContext: Context?
//    private val avatar: Avatar? = null
    override fun getCount(): Int {
        return Placelist.size
    }

    override fun getItem(position: Int): Any? {
        return Placelist[position]
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.place_layout, parent, false)
            holder = ViewHolder()
            holder.place_img =
                convertView!!.findViewById<View?>(R.id.user_img) as ImageView?
            holder.place_name = convertView.findViewById<View?>(R.id.place_name) as TextView?
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.place_img!!.setBackgroundResource(Placelist[position].place_img)
        holder.place_name!!.text = Placelist[position].place_name
        return convertView
    }

    internal class ViewHolder {
        var place_img: ImageView? = null
        var place_name: TextView? = null
    }
}