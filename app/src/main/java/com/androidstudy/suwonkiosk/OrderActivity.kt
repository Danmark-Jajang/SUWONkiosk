package com.androidstudy.suwonkiosk

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.androidstudy.suwonkiosk.databinding.ActivityMainBinding
import com.androidstudy.suwonkiosk.databinding.ActivityOrderBinding
import com.google.android.material.tabs.TabLayoutMediator

class OrderActivity : AppCompatActivity() {
    lateinit var binding : ActivityOrderBinding
    lateinit var MenuAdapter: FragmentStateAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ViewBinding 설정
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //메뉴표시를 위한 ViewPager2 초기화
        MenuAdapter = FragmentAdapter(this)
        binding.pager.adapter = MenuAdapter

        //Tablayout -> ViewPager2의 각 Fragment를 Tab에 동적으로 연결
        TabLayoutMediator(binding.tabLayout, binding.pager){ tab, position ->
            tab.text = "Menu ${position+1}"
        }.attach()


        //주문내역 조회를 위한 recyclerView 초기화
        var menuList = ArrayList<Menu>()
        binding.rv.adapter = ItemAdapter(menuList)
        binding.rv.layoutManager = LinearLayoutManager(this)

        //Main으로 돌아가기 (Activity를 종료, 주문취소)
        binding.btnOrderToMain.setOnClickListener{
            finish()
        }

    }
}