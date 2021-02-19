package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext: Button = findViewById(R.id.btnNext)

        btnNext.setOnClickListener() {

            val username = findViewById<TextView>(R.id.ptname)
            val intent = Intent(this, Calculator::class.java);   //create intent so can show

            intent.putExtra("PersonName", username.text.toString())

            startActivity(intent);  // show the screen
        }
    }
}