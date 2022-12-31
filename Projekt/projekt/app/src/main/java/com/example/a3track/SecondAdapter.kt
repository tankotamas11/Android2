package com.example.a3track

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a3track.model.Task
import java.text.FieldPosition

class SecondAdapter(private val TaskList: ArrayList<Task>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private  lateinit var  mListener : MyAdapter.onItemClickListener
    interface  OnItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: MyAdapter.onItemClickListener){
        mListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.taskitem,parent,false)
        return MyAdapter.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}