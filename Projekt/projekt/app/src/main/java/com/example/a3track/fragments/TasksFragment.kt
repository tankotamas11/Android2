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
import com.example.a3track.R
import com.example.a3track.databinding.FragmentTasksBinding
import com.example.a3track.repository.TrackerRepository
import com.example.a3track.viewmodels.CurrentUserViewModel
import com.example.a3track.viewmodels.TasksViewModel
import com.example.a3track.viewmodels.TasksViewModelFactory


class TasksFragment : Fragment() {

    private val currentUserViewModel:CurrentUserViewModel by activityViewModels()
    private lateinit var tasksVM:TasksViewModel
    private var _binding:FragmentTasksBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory= TasksViewModelFactory(TrackerRepository())
        tasksVM=ViewModelProvider(this,factory).get(TasksViewModel::class.java)
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
        val sharedPreferences = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)
        val retrievedToken = sharedPreferences.getString("token",null)
        tasksVM.readTasks(retrievedToken.toString())
        tasksVM.taskList.observe(viewLifecycleOwner){Log.i("TTT","token1: " + retrievedToken.toString())
            val tasks=tasksVM.taskList.value
            szoveg.text=tasks!!.size.toString()
            Log.i("TTT","sikeres lekerdezes")
        }


    }


}