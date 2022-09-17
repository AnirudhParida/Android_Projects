package com.trial.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startbtn : Button = findViewById(R.id.start_button)
        val name : AppCompatEditText = findViewById(R.id.user_name)
        startbtn.setOnClickListener {

            if (name.text.toString().isEmpty()){
                Toast.makeText(this, "NAME PLZ", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this@MainActivity,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,name.text.toString())
                startActivity(intent)
//                finish()
            }
        }
    }
}