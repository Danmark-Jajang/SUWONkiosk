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
            var optShot : String = ""
            var optTmp : String = ""
            var optSize : String = ""

            //샷추가
            if(binding.optShotO.isChecked){
                total += 500
                optShot = "-> 샷추가(+500)"
            }

            //온도/얼음
            if(binding.optTmpO.isChecked){
                optTmp = " -> Ice"
            }
            else if(binding.optTmpX.isChecked){
                optTmp = "-> Hot"
            }

            //사이즈업
            if(binding.optSizeO.isChecked){
                total += 1000
                optSize = "-> 사이즈업(+1000)"
            }

            var orderMenu : Menu = Menu(menuName, price, total, optShot, optTmp, optSize, 1)
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