package com.wny2023.ex97databinding

import androidx.databinding.ObservableField

//MVVM패턴의 View에서 사용할 데이터(model)을 연결해주는 ViewModel역할의 클래스 정의
class MyDataViewModel {
    // 이미지 뷰에서 보여줄 이미지 source URL(문자열 경로)
    val img: ObservableField<String> = ObservableField("https://images.unsplash.com/photo-1473496169904-658ba7c44d8a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80")
    // 리사이클러뷰가 사용할 대량의 데이터
    val items:ObservableField<MutableList<String>> =ObservableField(mutableListOf())
    //객체 초기화를 위한 빈 MutableList가 필요

}