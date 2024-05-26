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
    val penName = arrayOf(
        "bic", "라미", "juiceup", "제트스트림",
        "모나미", "멀티펜"
    )
    val penPrice = arrayOf(
        1000, 2000, 1500, 1500, 1000,
        1500
    )
    val penTag = arrayOf(
        R.drawable.bic, R.drawable.lamy, R.drawable.juiceup, R.drawable.jetstream, R.drawable.monami,
        R.drawable.multipen
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

        val penBinding = arrayOf(
            binding.lay1,
            binding.lay2,
            binding.lay3,
            binding.lay4,
            binding.lay5,
            binding.lay6
        )

        for (i in 0..penBinding.size - 1) {
            penBinding[i].name.setText(penName[i])
            penBinding[i].price.setText(penPrice[i].toString())
            penBinding[i].image.setImageResource(penTag[i])
            penBinding[i].layout.setOnClickListener {
                (activity as OrderActivity).startDialog(penBinding[i].name.text.toString(), penBinding[i].price.text.toString().toInt())
            }

        }
        return binding.root
    }
}