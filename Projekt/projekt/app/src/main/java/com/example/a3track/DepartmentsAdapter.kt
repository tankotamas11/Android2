package com.example.a3track

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.a3track.fragments.DepartmentFragment

class DepartmentsAdapter(private val List : ArrayList<String>) : RecyclerView.Adapter<DepartmentsAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.groupitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.groupName.text =List[position]



    }

    override fun getItemCount(): Int {
        return List.size
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val  groupName : TextView = itemview.findViewById(R.id.grouptext)




    }
}