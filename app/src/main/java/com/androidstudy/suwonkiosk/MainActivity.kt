package com.androidstudy.suwonkiosk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnMainToOrder : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainToOrder = findViewById<Button>(R.id.btn_mainToOrder)
        btnMainToOrder.setOnClickListener{
            startActivity(Intent(this, OrderActivity::class.java))
        }
    }
}