package com.trial.age_calculator

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*

class MainActivity() : AppCompatActivity() {

    private var tvselecteddate : TextView?=null
    private var tvageinminutes : TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_datepicker : Button = findViewById(R.id.button_datepicker)
        tvselecteddate = findViewById(R.id.selected_date)
        tvageinminutes = findViewById(R.id.AgeInMins)

        btn_datepicker.setOnClickListener {
            var myCalender= Calendar.getInstance()
            var year = myCalender.get(Calendar.YEAR)
            var month = myCalender.get(Calendar.MONTH)
            var date = myCalender.get(Calendar.DAY_OF_MONTH)

            var DPD = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view, SelectedYear, SelectedMonth, SelectedDate ->

                val selecteddate = "$SelectedDate/${SelectedMonth+1}/$SelectedYear"

                tvselecteddate?.text= selecteddate

                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

                val theDate = sdf.parse(selecteddate)

                val SelectedDateInMins = theDate.time/60000

                val CurrentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val CurrentDateInMins = CurrentDate.time/60000

                val DiffrencceInTime = CurrentDateInMins-SelectedDateInMins

                tvageinminutes?.text= DiffrencceInTime.toString()
            }, year,month,date)

            DPD.datePicker.maxDate = System.currentTimeMillis()
            DPD.show()

        }

    }
}

