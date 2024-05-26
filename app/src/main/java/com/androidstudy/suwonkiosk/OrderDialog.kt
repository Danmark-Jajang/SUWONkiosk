package com.androidstudy.suwonkiosk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.androidstudy.suwonkiosk.databinding.ActivityDialogBinding

class OrderDialog(val menuName : String, val price : Int, var pos : Int = -1) : DialogFragment() {
    lateinit var binding : ActivityDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityDialogBinding.inflate(inflater, container, false)
        //dialog 메뉴표시
        val view = binding.root
        binding.diaMenuName.text = menuName

        var orderActivity = context as OrderActivity

        //확인버튼
        binding.diaConfirm.setOnClickListener{
            var total = price
            var opt1 : String = ""
            var opt2 : String = ""
            var opt3 : String = ""

            //색상
            if(binding.opt11.isChecked){
                opt1 = "-> 검정(Black)"
            }
            else if(binding.opt12.isChecked){
                total += 100
                opt1 = "-> 빨강(Red) (+100)"
            }
            else if(binding.opt13.isChecked){
                total += 100
                opt1 = "-> 파랑(Blue) (+100)"
            }

            //두께
            if(binding.otp21.isChecked){
                opt2 = " -> 0.5mm"
            }
            else if(binding.otp22.isChecked){
                opt2 = "-> 0.7mm"
            }
            else if(binding.otp23.isChecked){
                opt2 = "-> 1.0mm"
            }

            //선물포장
            if(binding.optPackageO.isChecked){
                total += 1000
                opt3 = "-> 선물용포장 (+1000)"
            }

            var orderMenu : Menu = Menu(menuName, price, total, opt1, opt2, opt3, 1)
            orderActivity.addMenu(orderMenu, pos)
            orderActivity.binding.rv.adapter?.notifyDataSetChanged()

            dismiss()
        }

        binding.diaCancel.setOnClickListener{
            dismiss()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}