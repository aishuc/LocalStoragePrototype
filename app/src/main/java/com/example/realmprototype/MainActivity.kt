package com.example.realmprototype

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var  edtitle : AppCompatEditText
    private lateinit var  edes : AppCompatEditText
    private lateinit var  btninsert : Button
    private lateinit var  btnget : Button
    private lateinit var  tvdisplaydata : TextView
    private lateinit var  viewModel: MainViewModel
    private lateinit var  rvFavorite: RecyclerView
    private var  favoriteAdapter: FavoriteAdapetr?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initview()

        btninsert.setOnClickListener {
            viewModel.saveNestedObject()
            /*insertFavorites()*/
        }
        btnget.setOnClickListener {
         getAllfavorites()
        }
    }
    private fun getAllfavorites(){

       viewModel.retrievedata(tvdisplaydata)
    }
    private fun initview(){
    btninsert = findViewById(R.id.btn_insert)
    btnget = findViewById(R.id.btn_get)
    tvdisplaydata = findViewById(R.id.tv_ds)
        rvFavorite = findViewById(R.id.rv_favorite)
        rvFavorite.layoutManager = LinearLayoutManager(this)
        favoriteAdapter = FavoriteAdapetr()
        rvFavorite.adapter = favoriteAdapter

}
    private  fun insertFavorites(){
        val title = edtitle.text.toString()
        val des = edes.text.toString()
        Toast.makeText(this,"Favorites added...",Toast.LENGTH_SHORT).show()
    }
}