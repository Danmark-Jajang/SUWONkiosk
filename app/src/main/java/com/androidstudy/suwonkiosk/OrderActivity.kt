package com.androidstudy.suwonkiosk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.androidstudy.suwonkiosk.databinding.ActivityMainBinding
import com.androidstudy.suwonkiosk.databinding.ActivityOrderBinding
import com.google.android.material.tabs.TabLayoutMediator

class OrderActivity : AppCompatActivity() {
    lateinit var binding : ActivityOrderBinding
    lateinit var MenuAdapter: FragmentStateAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View Binding으로 View Element접근
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FragmentAdapter -> ViewPager2 연결
        MenuAdapter = FragmentAdapter(this)
        binding.pager.adapter = MenuAdapter

        //Tablayout -> ViewPager2의 각 Fragment를 Tab에 동적으로 연결
        TabLayoutMediator(binding.tabLayout, binding.pager){ tab, position ->
            tab.text = "Menu ${position+1}"
        }.attach()

        //Main으로 돌아가기 (Activity를 종료)
        binding.btnOrderToMain.setOnClickListener{
            finish()
        }


    }
}