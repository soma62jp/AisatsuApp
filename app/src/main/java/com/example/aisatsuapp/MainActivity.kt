package com.example.aisatsuapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    var hour : Int = 0
    var minute : Int = 0
    var dayMimute : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button  -> {
                showDatePickerDialog()
            }
        }

        dayMimute = hour * 60 + minute

        if(dayMimute >= 120  && dayMimute < 600){
            textView.text = "おはよう"
        }else if(dayMimute >= 600  && dayMimute < 1080){
            textView.text = "こんにちは"
        }else{
            textView.text = "こんばんは"
        }
    }

    private fun showDatePickerDialog() {
        val c = Calendar.getInstance()
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener() { _, hourOfDay, minute ->
                    this.hour = hourOfDay
                    this.minute = minute



                },
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                true)

        timePickerDialog.show()

    }

}