package com.example.a3track

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3track.model.Task
import com.example.a3track.model.TasksResponse
import com.example.a3track.model.User
import com.example.a3track.viewmodels.UserViewModel
import java.text.FieldPosition
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class SecondAdapter(private val TaskList: List<TasksResponse>,val users: List<User>):RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondAdapter.SecondViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.taskitem,parent,false)
        return SecondViewHolder(itemView)
    }
    fun Name( id:Int):String{

        var t=true
        var i=0
        while (t){
            if(users!![i].ID==id){

                return (users!![i].last_name+ " "+ users!![i].first_name)
            }
            i++
        }
        return "ID problem"
    }
    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
        return format.format(date)
    }
    fun Priority(level:Int):String{
        when (level){
            1 -> return "High prio"
            2 -> return  "Medium prio"
            else -> {
                return "Low prio"
            }
        }
    }
    fun TaskStatus(level:Int):String{
        when (level){
            1 -> return "New"
            2 -> return  "In progress"
            3 -> return  "Done"
            else -> {
                return "Blocked"
            }
        }
    }

    override fun onBindViewHolder(holder: SecondAdapter.SecondViewHolder, position: Int) {


        val currentItem=TaskList[position]
        Log.i("AAA","pozicioja: "+ currentItem.title)


        holder.title.text=currentItem.title
        holder.creator.text=Name(currentItem.created_by_user_ID)+" "+ convertLongToTime(currentItem.created_time)
        holder.assigned.text=Name(currentItem.asigned_to_user_ID)
        holder.tdeadline.text=convertLongToTime(currentItem.deadline)
        holder.priority.text=Priority(currentItem.priority)
        holder.description.text=currentItem.description
        holder.status.text=TaskStatus(currentItem.status)

    }

    override fun getItemCount(): Int {
        return  TaskList.size
    }
    class SecondViewHolder(itemview : View) :RecyclerView.ViewHolder(itemview){
        val  title : TextView = itemview.findViewById(R.id.taskTitle)
        val creator : TextView=itemview.findViewById(R.id.taskCreator)
        val tdeadline : TextView=itemview.findViewById(R.id.taskdeadline)
        val assigned : TextView=itemview.findViewById(R.id.taskassigned)
        val priority : TextView=itemview.findViewById(R.id.taskpriority)
        val status : TextView=itemview.findViewById(R.id.taskstatus)
        val description : TextView=itemview.findViewById(R.id.taskdescription)




    }

}