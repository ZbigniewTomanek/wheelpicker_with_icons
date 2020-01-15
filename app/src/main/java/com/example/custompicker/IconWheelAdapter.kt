package com.example.custompicker

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.yanzhenjie.wheel.adapters.AbstractWheelAdapter

class IconWheelAdapter(context: Context, private val items: Array<Int>) : AbstractWheelAdapter() {
    private class ViewHolder {
        lateinit var icon: ImageView
    }

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getItemsCount(): Int {
        return items.size
    }

    override fun getItem(index: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: ViewHolder
        val view: View
        if (convertView == null) {
            view = inflater.inflate(R.layout.icon_list_view, parent, false)

            holder = ViewHolder()
            holder.icon = view.findViewById(R.id.weather_list_icon)

            view.tag = holder
        }
        else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val icon = holder.icon
        icon.setImageResource(items[index])

        return view
    }

}