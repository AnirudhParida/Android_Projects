package com.trial.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_page)

        val tvName:TextView = findViewById(R.id.name)
        val tvResult :TextView = findViewById(R.id.result)
        val btn_finish :Button = findViewById(R.id.finish_button)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)

        val totalquestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctanswer = intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        tvResult.text = "Your Score is $correctanswer out of $totalquestion"

        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}