package com.androidstudy.suwonkiosk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidstudy.suwonkiosk.databinding.FragmentMenu1Binding
import com.androidstudy.suwonkiosk.databinding.FragmentMenu2Binding

class Menu2 : Fragment() {
    val sharpName = arrayOf(
        "수능샤프", "파커샤프", "라미샤프", "펜텔샤프",
        "스테들러샤프", "쿠루토가샤프", "파일럿샤프", "오토샤프"
    )
    val sharpPrice = arrayOf(
        1500, 5000, 3000, 4000, 3000,
        4500, 3000, 5000
    )
    val sharpTag = arrayOf(
        R.drawable.suneng, R.drawable.parker, R.drawable.lamysharp, R.drawable.pentel,
        R.drawable.staedtler, R.drawable.kurutoga, R.drawable.pilot, R.drawable.ohto
    )



    lateinit var binding: FragmentMenu2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenu2Binding.inflate(layoutInflater)

        val sharpBinding = arrayOf(
            binding.lay1,
            binding.lay2,
            binding.lay3,
            binding.lay4,
            binding.lay5,
            binding.lay6,
            binding.lay7,
            binding.lay8
        )

        for (i in 0..sharpBinding.size - 1) {
            sharpBinding[i].name.setText(sharpName[i])
            sharpBinding[i].price.setText(sharpPrice[i].toString())
            sharpBinding[i].image.setImageResource(sharpTag[i])
            sharpBinding[i].layout.setOnClickListener {
                (activity as OrderActivity).startDialog(sharpBinding[i].name.text.toString(), sharpBinding[i].price.text.toString().toInt())
            }

        }
        return binding.root
    }
}