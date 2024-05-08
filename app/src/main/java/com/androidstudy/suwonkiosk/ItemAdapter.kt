package com.androidstudy.suwonkiosk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        holder.name.text = menuList[position].menu
        holder.price.text = menuList[position].price.toString()
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    //내부 홀더 생성
    inner class Holder(val binding : MenuRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root){
        val name = binding.menuname
        val price = binding.menuprice
    }
}