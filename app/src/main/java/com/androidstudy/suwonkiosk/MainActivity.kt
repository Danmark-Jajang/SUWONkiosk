package com.androidstudy.suwonkiosk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.androidstudy.suwonkiosk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var orderlist : ArrayList<ArrayList<Menu>>
    lateinit var btnMainToOrder : Button
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainToOrder.setOnClickListener{
            startActivity(Intent(this, OrderActivity::class.java))
        }
    }

    fun addOrderList(list : ArrayList<Menu>){
        orderlist.add(list)
    }
}