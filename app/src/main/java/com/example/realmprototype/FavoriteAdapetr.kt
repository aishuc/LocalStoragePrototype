package com.example.realmprototype

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class FavoriteAdapetr : androidx.recyclerview.widget.ListAdapter<FavoriteModel,FavoriteHolder>(MyDiffUtil){
    object MyDiffUtil : DiffUtil.ItemCallback<FavoriteModel>(){
        override fun areItemsTheSame(oldItem: FavoriteModel, newItem: FavoriteModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: FavoriteModel, newItem: FavoriteModel): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHolder {
        return FavoriteHolder.create(parent)
    }

    override fun onBindViewHolder(holder: FavoriteHolder, position: Int) {
       holder.bindView(getItem(position))
    }
}
class  FavoriteHolder(private val view : View): RecyclerView.ViewHolder(view){
  private lateinit var tvtitle : AppCompatTextView
  private lateinit var tvDes : AppCompatTextView
  private lateinit var tvpname : AppCompatTextView
  private lateinit var tvrestore : AppCompatTextView

    fun bindView(favorite : FavoriteModel){
        tvDes = view.findViewById(R.id.tv_des)
        tvtitle = view.findViewById(R.id.tv_title)

        tvpname = view.findViewById(R.id.tv_pname)
        tvrestore = view.findViewById(R.id.tv_restore)
    }
    companion object{
        const val LAYOUT = R.layout.favorite_item
        fun create(parent : ViewGroup)= FavoriteHolder(
            LayoutInflater.from(parent.context).inflate(LAYOUT,parent,false)
        )
    }
}