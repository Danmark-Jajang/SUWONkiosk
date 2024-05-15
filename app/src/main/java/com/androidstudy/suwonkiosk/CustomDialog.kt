package com.androidstudy.suwonkiosk

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import com.androidstudy.suwonkiosk.databinding.ActivityDialogBinding

class CustomDialog(val context : AppCompatActivity) {
    lateinit var binding : ActivityDialogBinding
    val dlg = Dialog(context)

    fun show(menu : String){
        binding = ActivityDialogBinding.inflate(context.layoutInflater)
        dlg.setContentView(binding.root)
        dlg.setCancelable(false)

        binding.diaMenuName.text = menu

        binding.diaOk.setOnClickListener{

            dlg.dismiss()
        }

        binding.diaCancel.setOnClickListener{

            dlg.dismiss()
        }

    }
}