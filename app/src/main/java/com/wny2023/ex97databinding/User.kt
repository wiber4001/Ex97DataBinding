package com.wny2023.ex97databinding

import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class User {

    //값 변경이 관찰되는(observable) 멤버변수 ObservableXXX:primitive type 또는 List 또는 Map
    //ObservableField<>:Reference type또는 String
    var name:ObservableField<String> = ObservableField()
    var age:ObservableInt = ObservableInt(0) //초기값을 ()에 넣어줌
    var fav:ObservableBoolean= ObservableBoolean()

    constructor(name:String, age:Int, fav:Boolean=true){
        this.name.set(name)
        this.age.set(age)
        this.fav.set(fav)
    }

    //change name 버튼 클릭 callback method-클릭 콜백메소드가 되려면 반드시 파라미터가 있어야함
    //view:View 있어야함
    fun changeName(view:View){
         name.set("옵저버블 로빈")
     }
    //age 변수값을 1증가 시키는 기능 콜백 메소드
    fun increaseAge(v:View){
        //age++ //error
        age.set(age.get()+1)
    }
    //좋아요 true/false변경하는 기능 메소드 -콜백용 메소드가 아닌 그냥 일반메소드
    // 이 메소드를 xml버튼의 onClick 속성으로 지정한 익명콜백함수에서 대신 호출해 줄것임
    //이런 방식을 쓰면 v:View외에도 다른 속성값을 파라미터로 전달하는 것이 가능해짐 ->다양한활용가능
    fun toggleFav(){ //파라미터가없어!!! ->현업에서 많이쓰임
        fav.set(!fav.get())//이전과 반대로 바꾸는 기능 -!- 활용
    }
    //체크상태가 변경되는 것에 반응하는 콜백메소드 -파라미터가 중요함
    fun changeFav(v:CompoundButton, isChecked:Boolean){ //파라미터 틀리면 등록안되므로 주의
        Toast.makeText(v.context, "${isChecked}", Toast.LENGTH_SHORT).show()
        //체크상태값을 관리하는 observable변수도 같이 변경을 반드시 해줘야함 (자동변경 안됨 주의)
        fav.set(isChecked)
    }
    //EditText의 글씨 변화값을 가지고 있을 관찰가능한 변수
    val message:ObservableField<String> = ObservableField("message")
    //EditText의 글씨 변화 이벤트에 반응하는 콜백메소드 - 파라미터 중요
    fun onTextChange(s:CharSequence?,start:Int,end:Int,count:Int){
        message.set(s.toString())
    }
    //EditText에 글씨를 입력하고 버튼을 클릭하여 텍스트뷰에 보여주기
    private var inputValue:String="" //입력한 값을 저장할 일반변수
    val value:ObservableField<String> =ObservableField(inputValue) //일반변수의 변화를 지켜보는 변수
    //EditText의 글씨 변경 이벤트 콜백 메소드에 의해 호출될 일반 메소드
    fun changeInputValue(s:CharSequence){
        inputValue=s.toString()
    }
    //작성완료버튼 클릭 콜백메소드에 의해 호출될 일반 메소드
    fun clickDone(){
        value.set(inputValue) //클릭됐을때까지의 inputValue값
    }

}