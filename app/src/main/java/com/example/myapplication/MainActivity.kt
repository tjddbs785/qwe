package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "ORACLE"

        var tv1 = findViewById(R.id.tv1) as TextView
        try {
            var result: String
            val task = RegisterActivity()
            result = task.execute().get()!!
            tv1.setText(result)
        } catch (e: Exception) {
        }
    }
}