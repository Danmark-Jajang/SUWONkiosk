package com.androidstudy.suwonkiosk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidstudy.suwonkiosk.databinding.FragmentMenu2Binding

class Menu2 : Fragment() {
    val coffeeName = arrayOf(
        "strawberry", "blueberry", "banana", "choco",
        "milk", "cherry"
    )
    val coffeePrice = arrayOf(2000, 3000, 4000, 5000, 6000,
        7000)
    lateinit var binding : FragmentMenu2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenu2Binding.inflate(layoutInflater)

        val coffeeBinding = arrayOf(
            binding.strawberry,
            binding.blueberry,
            binding.banana,
            binding.choco,
            binding.milk,
            binding.cherry)

        for(i in 0..coffeeBinding.size-1){
            coffeeBinding[i].name.setText(coffeeName[i])
            coffeeBinding[i].price.setText(coffeePrice[i].toString())
            coffeeBinding[i].image.setImageResource(R.drawable.no)
        }

        return binding.root
    }
}