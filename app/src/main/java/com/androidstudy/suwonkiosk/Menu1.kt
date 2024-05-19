package com.androidstudy.suwonkiosk

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.androidstudy.suwonkiosk.databinding.FragmentMenu1Binding
import com.androidstudy.suwonkiosk.databinding.ItemBinding

class Menu1 : Fragment() {
    val coffeeName = arrayOf(
        "hotCoffee", "iceCoffee", "Latte", "Espresso",
        "IceShotCu", "Water"
    )
    val coffeePrice = arrayOf(
        2000, 3000, 4000, 5000, 6000,
        7000
    )

    lateinit var binding: FragmentMenu1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenu1Binding.inflate(layoutInflater)

        val coffeeBinding = arrayOf(
            binding.hotCoffee,
            binding.iceCoffee,
            binding.latte,
            binding.espresso,
            binding.iceShotCu,
            binding.water
        )

        for (i in 0..coffeeBinding.size - 1) {
            coffeeBinding[i].name.setText(coffeeName[i])
            coffeeBinding[i].price.setText(coffeePrice[i].toString())
            coffeeBinding[i].image.setImageResource(R.drawable.no)
            coffeeBinding[i].layout.setOnClickListener {
                (activity as OrderActivity).startDialog(coffeeBinding[i].name.text.toString(), coffeeBinding[i].price.text.toString().toInt())
            }

        }
        return binding.root
    }
}