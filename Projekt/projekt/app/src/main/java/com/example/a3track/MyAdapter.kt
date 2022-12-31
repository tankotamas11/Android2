package com.example.a3track

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.a3track.fragments.ProfileFragment
import com.example.a3track.model.Departments

class MyAdapter(private val List : ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val itemView=LayoutInflater.from(parent.context).inflate(R.layout.groupitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.groupName.text =List[position]


    }

    override fun getItemCount(): Int {
        return List.size
    }

    class MyViewHolder(itemview : View) :RecyclerView.ViewHolder(itemview){
        val  groupName :TextView = itemview.findViewById(R.id.grouptext)




    }
}