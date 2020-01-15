package com.example.custompicker

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView

class IconListAdapter<T>(context: Context, textViewResId: Int, private val objects: Array<T>)
    : ArrayAdapter<T>(context, textViewResId, objects) {

    private class ViewHolder {
        lateinit var icon: ImageView
    }

    private val HALF_MAX_VAL: Int = Integer.MAX_VALUE / 2
    val MIDDLE = HALF_MAX_VAL % objects.size
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val icons = objects as Array<Int>

    init {
        Log.d("adapter", "init")
    }

    override fun getCount(): Int {
        return Integer.MAX_VALUE
    }

    override fun getItem(position: Int): T? {
        Log.d("adapter", "wybrano mnie")
        return objects[position % objects.size]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
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
        icon.setImageResource(icons[position % icons.size])

        Log.d("adapter", "element ${position % icons.size}")
        return view
    }
}