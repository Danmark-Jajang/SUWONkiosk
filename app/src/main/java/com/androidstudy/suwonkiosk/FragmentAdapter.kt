package com.androidstudy.suwonkiosk

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    var frag = listOf<Fragment>(Menu1(), Menu2(), Menu3())
    override fun getItemCount(): Int {
        return frag.size
    }

    override fun createFragment(position: Int): Fragment {
        return frag[position]
    }
}