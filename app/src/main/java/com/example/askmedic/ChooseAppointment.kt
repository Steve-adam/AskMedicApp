package com.example.askmedic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChooseAppointment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_appointment)

        findViewById<Button>(R.id.doctorappointment).setOnClickListener{
            startActivity(Intent(this@ChooseAppointment, ViewDoctors::class.java))
        }
        findViewById<Button>(R.id.hospitalappointment).setOnClickListener {
            startActivity(Intent(this@ChooseAppointment, MapsActivity::class.java))
        }
    }
}