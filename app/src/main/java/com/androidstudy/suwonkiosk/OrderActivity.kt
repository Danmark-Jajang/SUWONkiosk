package com.androidstudy.suwonkiosk

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.androidstudy.suwonkiosk.databinding.ActivityOrderBinding
import com.google.android.material.tabs.TabLayoutMediator

class OrderActivity : AppCompatActivity() {
    lateinit var binding : ActivityOrderBinding
    lateinit var MenuAdapter: FragmentStateAdapter
    lateinit var menuList : ArrayList<Menu>
    var tp = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ViewBinding 설정
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menuList = ArrayList<Menu>()

        //메뉴표시를 위한 ViewPager2 초기화
        MenuAdapter = FragmentAdapter(this)
        binding.pager.adapter = MenuAdapter

        //Tablayout -> ViewPager2의 각 Fragment를 Tab에 동적으로 연결
        TabLayoutMediator(binding.tabLayout, binding.pager){ tab, position ->
            tab.text = "Menu ${position+1}"
        }.attach()


        //주문내역 조회를 위한 recyclerView 초기화
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = ItemAdapter(menuList)

        //Main으로 돌아가기 (Activity를 종료, 주문취소)
        binding.btnOrderToMain.setOnClickListener{
            finishOrder()
        }

        binding.buyConfirm.setOnClickListener {
            if(menuList.size<1){
                Toast.makeText(applicationContext, "주문내역이 없습니다", Toast.LENGTH_SHORT).show()
            }
            else{
                val p = PayDialog(tp)
                p.isCancelable = false
                p.show(this.supportFragmentManager, "")
            }
        }
    }

    fun addMenu(menu : Menu, pos : Int){
        if(pos == -1) {
            menuList.add(menu)
        }
        else{
            menuList[pos] = menu
        }
    }

    fun startDialog(menuName : String, price : Int, pos : Int = -1){
        val dia = OrderDialog(menuName, price, pos)
        dia.isCancelable = false
        dia.show(this.supportFragmentManager, "")
    }

    fun updateTotalPrice(totalPrice : Int){
        tp = totalPrice
        binding.totalPrice.text = "총 가격 : ${tp}원"
    }

    fun finishOrder(){
        finish()
    }
}