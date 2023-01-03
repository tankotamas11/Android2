package com.example.a3track

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.a3track.fragments.DepartmentFragment
import com.example.a3track.fragments.ProfileFragment
import com.example.a3track.model.Departments
import java.util.Objects

class MyAdapter(private val List : ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
//    private lateinit var mListener : onItemClickListener
//
//    interface onItemClickListener{
//        fun onItemClick(position: Int)
//    }
//
//    fun setOnItemClickListener(listener: onItemClickListener){
//        mListener=listener
//    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val itemView=LayoutInflater.from(parent.context).inflate(R.layout.groupitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.groupName.text =List[position]
        val seged=position
        holder.itemView.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                val activity=v!!.context as AppCompatActivity
                val nextFragment= DepartmentFragment(seged+1)
                activity.supportFragmentManager.beginTransaction().replace(R.id.framelayout,nextFragment).addToBackStack(null).commit()
            }
            //Log.i("OOO","kivalasztott:" +position.toString())
        })


    }

    override fun getItemCount(): Int {
        return List.size
    }

    class MyViewHolder(itemview : View) :RecyclerView.ViewHolder(itemview){
        val  groupName :TextView = itemview.findViewById(R.id.grouptext)




    }
}