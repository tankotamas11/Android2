package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    val TAG= "MainActivity2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.i(TAG,"onCreate() called.")

        val message = intent.getStringExtra("Name")

        val textView = findViewById<TextView>(R.id.textView2).apply {
            text=message
        }


    }
}