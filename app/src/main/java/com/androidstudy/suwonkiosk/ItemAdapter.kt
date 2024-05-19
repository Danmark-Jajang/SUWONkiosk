package com.androidstudy.suwonkiosk

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.androidstudy.suwonkiosk.databinding.ActivityDialogBinding
import com.androidstudy.suwonkiosk.databinding.ActivityOrderBinding
import com.androidstudy.suwonkiosk.databinding.ItemBinding
import com.androidstudy.suwonkiosk.databinding.MenuRecyclerviewBinding

class ItemAdapter(val menuList : ArrayList<Menu>) : RecyclerView.Adapter<ItemAdapter.Holder>() {

    //RecyclerView 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.Holder {
        val binding = MenuRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    //RecyclerView 추가
    override fun onBindViewHolder(holder: ItemAdapter.Holder, position: Int) {
        var oa = holder.itemView.context as OrderActivity
        holder.name.text = menuList[position].menu
        holder.price.text = menuList[position].totalPrice.toString()
        holder.count.text = menuList[position].count.toString()

        if(menuList[position].optSize!=""){
            holder.optSize.visibility = View.VISIBLE
            holder.optSize.text = menuList[position].optSize
        }
        else holder.optSize.visibility = View.GONE

        if(menuList[position].optShot!=""){
            holder.optShot.visibility = View.VISIBLE
            holder.optShot.text = menuList[position].optShot
        }
        else holder.optShot.visibility = View.GONE

        if(menuList[position].optTmp!=""){
            holder.optTmp.visibility = View.VISIBLE
            holder.optTmp.text = menuList[position].optTmp
        }
        else holder.optTmp.visibility = View.GONE

        Log.d("CreateRecyclerView","${menuList[position].menu},${menuList[position].price}")
        oa.updateTotalPrice(getTotalPrice())

        holder.btnDelete.setOnClickListener{
            var pos = holder.bindingAdapterPosition
            if(pos != RecyclerView.NO_POSITION){
                //recyclerView TextView 초기화
                holder.optSize.visibility = View.GONE
                holder.optShot.visibility = View.GONE
                holder.optTmp.visibility = View.GONE
                holder.optSize.text = ""
                holder.optShot.text = ""
                holder.optTmp.text = ""

                //리스트 제거 후 notify to adapter
                menuList.removeAt(pos)
                oa.updateTotalPrice(getTotalPrice())
                oa.binding.rv.adapter?.notifyItemRemoved(pos)
            }
        }

        holder.btnMinus.setOnClickListener {
            if(menuList[position].count!=1){
                menuList[position].count--
                Log.e("Menu Minus", menuList[position].count.toString())
                holder.count.text = menuList[position].count.toString()
                oa.updateTotalPrice(getTotalPrice())
            }
        }

        holder.btnPlus.setOnClickListener {
            menuList[position].count++
            holder.count.text = menuList[position].count.toString()
            Log.e("Menu Plus", menuList[position].toString())
            oa.updateTotalPrice(getTotalPrice())
        }

        holder.name.setOnClickListener {
            oa.startDialog(menuList[position].menu, menuList[position].price, position)
        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun getTotalPrice() : Int{
        var res : Int = 0
        for(i in menuList){
            res += (i.totalPrice.toString().toInt())*(i.count)
        }
        return res
    }

    //내부 홀더 생성
    inner class Holder(val binding : MenuRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root){
        val name = binding.menuname
        val price = binding.menuprice
        val btnDelete = binding.menuDelete
        val optShot = binding.optShot
        val optTmp = binding.optTmp
        val optSize = binding.optSize
        val btnMinus = binding.menuMinus
        val btnPlus = binding.menuPlus
        val count = binding.menuCount
    }
}