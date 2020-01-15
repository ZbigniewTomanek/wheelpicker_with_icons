package com.example.custompicker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yanzhenjie.wheel.WheelView

class MainActivity : AppCompatActivity() {
    private lateinit var weatherWheelDay1: WheelView
    private lateinit var weatherWheelDay2: WheelView

    private val items =
        arrayOf(R.drawable.sun, R.drawable.clouds, R.drawable.rain, R.drawable.storm, R.drawable.snow)

    private val iconMap = mapOf(R.drawable.sun to "sunny", R.drawable.clouds to "cloudy",
        R.drawable.rain to "rainy", R.drawable.storm to "stormy", R.drawable.snow to "snowy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherWheelDay1 = findViewById(R.id.wheel_day1)
        weatherWheelDay2 = findViewById(R.id.wheel_day2)

        init()
    }

    private fun makeToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun init() {
        val drawable = getDrawable(R.drawable.shape_wheel_filter)

        val adapter1 = IconWheelAdapter(this, items)
        weatherWheelDay1.setAdapter(adapter1)
        weatherWheelDay1.isCyclic = true
        weatherWheelDay1.setCenterFilter(drawable)
        weatherWheelDay1.addChangingListener { _, old, new ->
            makeToast("Changed weather from ${iconMap[items[old]]} to  ${iconMap[items[new]]} on day 1")
        }

        val adapter2 = IconWheelAdapter(this, items)
        weatherWheelDay2.setAdapter(adapter2)
        weatherWheelDay2.isCyclic = true
        weatherWheelDay2.addChangingListener { _, old, new ->
            makeToast("Changed weather from ${iconMap[items[old]]} to  ${iconMap[items[new]]} on day 2")
        }


        weatherWheelDay2.setCenterFilter(drawable)

    }
}
