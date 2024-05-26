package com.androidstudy.suwonkiosk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidstudy.suwonkiosk.databinding.FragmentMenu1Binding
import com.androidstudy.suwonkiosk.databinding.FragmentMenu3Binding

class Menu3 : Fragment() {
    val otherName = arrayOf(
        "동아샤프심", "아인샤프심", "펜텔샤프심", "juiceup리필심",
        "zebra리필심", "staedtler리필심", "형광펜", "채점펜"
    )
    val otherPrice = arrayOf(
        1500, 2000, 2000, 2500, 2500,
        3000, 1500, 1500
    )
    val otherTag = arrayOf(
        R.drawable.donga, R.drawable.ainsim, R.drawable.pentelsim, R.drawable.juiceupsim,
        R.drawable.zebrasim, R.drawable.staedtlersim, R.drawable.brotherpen, R.drawable.scorepen
    )

    lateinit var binding: FragmentMenu3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenu3Binding.inflate(layoutInflater)

        val otherBinding = arrayOf(
            binding.lay1,
            binding.lay2,
            binding.lay3,
            binding.lay4,
            binding.lay5,
            binding.lay6,
            binding.lay7,
            binding.lay8
        )

        for (i in 0..otherBinding.size - 1) {
            otherBinding[i].name.setText(otherName[i])
            otherBinding[i].price.setText(otherPrice[i].toString())
            otherBinding[i].image.setImageResource(otherTag[i])
            otherBinding[i].layout.setOnClickListener {
                (activity as OrderActivity).startDialog(otherBinding[i].name.text.toString(), otherBinding[i].price.text.toString().toInt())
            }

        }
        return binding.root
    }
}