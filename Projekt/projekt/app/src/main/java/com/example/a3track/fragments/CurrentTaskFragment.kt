package com.example.a3track.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.a3track.R
import com.example.a3track.databinding.ActivityMenuBinding
import com.example.a3track.model.User
import com.example.a3track.repository.TrackerRepository
import com.example.a3track.viewmodels.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CurrentTaskFragment(p:Int) : Fragment() {
    private lateinit var userListVM: UserViewModel
    private lateinit var tasksVM: TasksViewModel
    private val pozition=p
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory= TasksViewModelFactory(TrackerRepository())
        tasksVM= ViewModelProvider(this,factory).get(TasksViewModel::class.java)
        val factory1= UserViewModelFactory(TrackerRepository())
        userListVM= ViewModelProvider(this,factory1).get(UserViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val back:Button=view.findViewById(R.id.backtotasks)
        back.setOnClickListener{
            binding= ActivityMenuBinding.inflate(layoutInflater)

            replaceFragment(TasksFragment())
        }
        val cim: TextView = view.findViewById(R.id.tasktitle5)
        val creator:TextView=view.findViewById(R.id.creator5)
        val date:TextView=view.findViewById(R.id.assignedtime5)
        val assignee:TextView=view.findViewById(R.id.assigned5)
        val progress:TextView=view.findViewById(R.id.progress5)
        val deadline:TextView=view.findViewById(R.id.deadline5)
        val priority:TextView=view.findViewById(R.id.priority5)
        val status:TextView=view.findViewById(R.id.status5)
        val desription:TextView=view.findViewById(R.id.description5)
        val sharedPreferences = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)
        val retrievedToken = sharedPreferences.getString("token",null)

        tasksVM.readTasks(retrievedToken.toString())
        tasksVM.taskList.observe(viewLifecycleOwner){
            userListVM.readUsers(retrievedToken.toString())
            userListVM.userList.observe(viewLifecycleOwner) {
                //Log.i("TTT","token1: " + retrievedToken.toString())
                val users=userListVM.userList.value as ArrayList<User>
                val tasks = tasksVM.taskList.value
                cim.text = tasks!![pozition].title
                creator.text="Assigned: "+Name(tasks!![pozition].created_by_user_ID,users)
                date.text = "Assigned date: "+convertLongToTime(tasks!![pozition].created_time)
                assignee.text="Assignee:"+Name(tasks!![pozition].asigned_to_user_ID,users)
                status.text = TaskStatus(tasks!![pozition].status)
                deadline.text = "Deadline: "+convertLongToTime(tasks!![pozition].deadline)
                priority.text = "Priority: "+Priority(tasks!![pozition].priority)
                progress.text = tasks!![pozition].progress.toString() + "%"
                desription.text = tasks!![pozition].description
            }
        }
    }
    fun Name( id:Int, users:ArrayList<User>):String{

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
            1 -> return "High "
            2 -> return  "Medium "
            else -> {
                return "Low "
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
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = requireFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }


}