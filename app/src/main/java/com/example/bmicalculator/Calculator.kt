package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Calculator : AppCompatActivity() {

    var bmiIndex: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val txtWelcome = findViewById<TextView>(R.id.txtWelcome)

        val personName = this.intent?.getStringExtra("PersonName")

        txtWelcome.setText(personName)


        //when rotate screen, the screen will refresh and remove some elements
        //so this savedinstancestate checks whether is there data stored inside (as put during the first load), if got then retrieve it
        if (savedInstanceState != null) {
            bmiIndex = savedInstanceState.getDouble("bmi")

            val txtStatus = findViewById<TextView>(R.id.txtStatus)
            txtStatus.setText(getStatus())
        }

        val btnCalc = findViewById<Button>(R.id.btnCalc)
        btnCalc.setOnClickListener() {
            val inputWeight = findViewById<TextView>(R.id.inputWeight).text.toString()
            val inputHeight = findViewById<TextView>(R.id.inputHeight).text.toString()

            bmiIndex = inputWeight.toDouble() / (inputHeight.toDouble() * inputHeight.toDouble())

            val txtStatus = findViewById<TextView>(R.id.txtStatus)
            txtStatus.setText(getStatus())
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmi", bmiIndex)

    }

    private fun getStatus(): String {
        return if (bmiIndex < 18.5)
            "Underweight!"
        else if (bmiIndex <= 24.9)
            "Normal weight!"
        else if (bmiIndex <= 29.9)
            "Overweight"
        else if (bmiIndex <= 34.9)
            "Obesity class I"
        else if (bmiIndex <= 39.9)
            "Obesity class II"
        else
            "Obesity class III - you are so fat"
    }
}
