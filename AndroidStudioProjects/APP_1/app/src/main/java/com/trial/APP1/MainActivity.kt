package com.trial.APP1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contchange = findViewById<TextView>(R.id.textView)
        val btnClickMe = findViewById<Button>(R.id.button)
        val Clkshow = findViewById<TextView>(R.id.textView3)
        var timesclk = 0

        btnClickMe.setOnClickListener {
            btnClickMe.text = "Lamao"
            timesclk += 1
            Clkshow.text = timesclk.toString()
            Toast.makeText(this, "ALLAH HU AKBAR ☠", Toast.LENGTH_LONG).show()
        }
    }
}