package com.example.mod4tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val minView = findViewById<EditText>(R.id.et_min)
        val maxView = findViewById<EditText>(R.id.et_max)
        val button = findViewById<Button>(R.id.button)
        val resultView = findViewById<TextView>(R.id.tv_result)


        button.setOnClickListener {
            val minInt = minView.text.toString().toIntOrNull()
            val maxInt = maxView.text.toString().toIntOrNull()

            if(minInt != null && maxInt != null && minInt <= maxInt){
                resultView.text = (minInt..maxInt).random().toString()
            }


        }


    }
}