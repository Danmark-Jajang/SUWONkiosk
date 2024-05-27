package com.androidstudy.suwonkiosk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.androidstudy.suwonkiosk.databinding.ActivityPaydialogBinding
import java.lang.Exception
import java.lang.NumberFormatException

class PayDialog(var payTotal : Int) : DialogFragment() {

    lateinit var binding : ActivityPaydialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityPaydialogBinding.inflate(inflater, container, false)
        val view = binding.root
        var lp = payTotal
        var card : Int = 0
        var cash : Int = 0

        binding.totalPay.text = payTotal.toString()
        binding.leftPay.text = payTotal.toString()

        binding.buy.setOnClickListener {

            try {
                var pay = binding.userPay.text.toString().toInt()
                if(pay >= lp){
                    pay = lp
                }
                if(binding.btnCard.isChecked){
                    card += pay
                }
                else if(binding.btnCash.isChecked){
                    cash += pay
                }
                lp -= pay
                binding.leftPay.text = lp.toString()


            }catch (_: Exception){
                Toast.makeText(this.context, "숫자를 입력하시오", Toast.LENGTH_SHORT).show()
            }
            if(lp==0){
                Toast.makeText(context, "구매해주셔서 감사합니다, 카드:${card}원, 현금:${cash}", Toast.LENGTH_SHORT).show()
                (activity as OrderActivity).finishOrder()
                dismiss()
            }

        }

        binding.cancel.setOnClickListener {
            card = 0
            cash = 0
            dismiss()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}