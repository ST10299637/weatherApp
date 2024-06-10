package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Thirdscreen : AppCompatActivity() {

    private lateinit var minTemperatureView: TextView
    private lateinit var maxTemperatureView: TextView
    private lateinit var weatherConditionView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thirdscreen)

        minTemperatureView = findViewById(R.id.min_temperature)
        maxTemperatureView = findViewById(R.id.max_temperature)
        weatherConditionView = findViewById(R.id.weather_condition)

        // Retrieve data passed from the main activity
        val minTemperature = intent.getStringExtra("MIN_TEMPERATURE")
        val maxTemperature = intent.getStringExtra("MAX_TEMPERATURE")
        val weatherCondition = intent.getStringExtra("CONDITION")

        // Set the retrieved values to the TextViews
        minTemperatureView.text = minTemperature ?: "N/A"
        maxTemperatureView.text = maxTemperature ?: "N/A"
        weatherConditionView.text = weatherCondition ?: "N/A"
    }
}
