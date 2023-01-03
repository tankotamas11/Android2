package com.example.a3track.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3track.MyAdapter
import com.example.a3track.R
import com.example.a3track.SecondAdapter
import com.example.a3track.databinding.FragmentTasksBinding
import com.example.a3track.model.Task
import com.example.a3track.model.TasksResponse
import com.example.a3track.model.User
import com.example.a3track.repository.TrackerRepository
import com.example.a3track.viewmodels.*


class TasksFragment : Fragment() {

    private val currentUserViewModel:CurrentUserViewModel by activityViewModels()
    private lateinit var tasksVM:TasksViewModel
    private var _binding:FragmentTasksBinding?=null
    private val binding get() = _binding!!
    private lateinit var adapter2: SecondAdapter
    private lateinit var recyclerView2: RecyclerView
    private lateinit var userListVM: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory= TasksViewModelFactory(TrackerRepository())
        tasksVM=ViewModelProvider(this,factory).get(TasksViewModel::class.java)
        val factory1= UserViewModelFactory(TrackerRepository())
        userListVM=ViewModelProvider(this,factory1).get(UserViewModel::class.java)
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentTasksBinding.inflate(inflater,container,false)
        val sharedPreferences = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)
        val retrievedToken = sharedPreferences.getString("token",null)
        val retrievedDeadline = sharedPreferences.getLong("deadline",0L)
        val id=sharedPreferences.getString("id","").toString()
        currentUserViewModel.updateLoginResponse(retrievedDeadline,retrievedToken.toString(),id.toInt())
        currentUserViewModel.getCurrentUser()
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val szoveg:TextView= view.findViewById(R.id.tasksTextView)
        szoveg.text="My Tasks"
        val sharedPreferences = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)
        val retrievedToken = sharedPreferences.getString("token",null)

        tasksVM.readTasks(retrievedToken.toString())
        tasksVM.taskList.observe(viewLifecycleOwner){Log.i("TTT","token1: " + retrievedToken.toString())
            val tasks=tasksVM.taskList.value
            userListVM.readUsers(retrievedToken.toString())
            userListVM.userList.observe(viewLifecycleOwner) {
                var userList = userListVM.userList.value as ArrayList<User>


                val layoutManager= LinearLayoutManager(context)
                recyclerView2=view.findViewById(R.id.recyclerView2)

                recyclerView2.layoutManager=layoutManager
                recyclerView2.setHasFixedSize(true)
                Log.i("TTT","userlist:"+tasks!![0].title)
                val segedlista=  tasks as ArrayList<TasksResponse>
                Log.i("TTT","userlist:"+segedlista[0].title)
                adapter2= SecondAdapter(tasks as ArrayList<TasksResponse>,userList as ArrayList<User>)
                recyclerView2.adapter=adapter2
            }

            Log.i("TTT","sikeres lekerdezes")
        }


    }
//


}