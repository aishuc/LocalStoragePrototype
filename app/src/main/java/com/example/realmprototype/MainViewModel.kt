package com.example.realmprototype

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModel
import io.realm.Realm
import io.realm.RealmList
import java.util.*

class MainViewModel :ViewModel(){
    var realm = Realm.getDefaultInstance()
    var id = UUID.randomUUID().toString()
    fun saveNestedObject(){
        realm.executeTransaction {
            val parent = FavoriteModel().apply {
                Company = "BEA"
                FP_version= "1.30"
                Family= "WS_"
                CAN_ID= "0123456789"
                DT_UTC= "2021-11-09T11:17:01Z"
                user=1-3
                unit=1-2
                DD_localisation= "41.4033,02.17403"
                parameterModel = RealmList<ParameterModel>().apply {
                    add(ParameterModel().apply {
                        pid = "U03"
                        restore= 0
                        value= 23
                    })
                    add(ParameterModel().apply {
                        pid = "U03"
                        restore= 1
                        value= 15
                    })
                    add(ParameterModel().apply {
                        pid = "U03"
                        restore= 1
                        value= 25
                    })
                    add(ParameterModel().apply {
                        pid = "U03"
                        restore= 0
                        value= 28
                    })
                    add(ParameterModel().apply {
                        pid = "U03"
                        restore= 0
                        value= 29
                    })
                }
            }
            realm.insertOrUpdate(parent)
        }
    }
    fun retrievedata(textView: TextView){
        val param = realm.where(FavoriteModel::class.java).findFirst()
        Log.d("test1"," ,,,,$param")
        if (param != null) {
            textView.text = "User Data: \n"
            textView.append("company : ${param.Company} \n")
            textView.append("FP_version : ${param.FP_version} \n")
            textView.append("Family : ${param.Family} \n")
            textView.append("CAN_ID : ${param.CAN_ID} \n")
            textView.append("DT_UTC : ${param.DT_UTC} \n")
            textView.append("user : ${param.user} \n")
            textView.append("unit : ${param.unit} \n")
            textView.append("DD_localisation : ${param.DD_localisation} ")
        }
        param?.let { it ->
            it.parameterModel.forEach {
                textView.append("\n Parameters \n pname : ${it.pid} restore : ${it.restore} value : ${it.value}")
           }
        }
    }
}