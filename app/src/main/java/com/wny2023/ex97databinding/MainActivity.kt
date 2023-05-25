package com.wny2023.ex97databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wny2023.ex97databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //데이터 바인딩에서는 뷰바인딩과 다르게 레이아웃 xml파일의 root요소가 <layout>이어야만 바인딩 클래스가 생성됨
    //<layout>은 객체임 뷰가 아님
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main) //기존 setContentView는 지우기
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        // DataBindingUtil을 이용하여 setContentView를 한다

        // 레이아웃 xml에서 <data>요소 안에있는 <variable>의 타입으로 지정한 User클래스를 객체로 생성하여 값을지정
        binding.user=User("hong",400)
    }

}