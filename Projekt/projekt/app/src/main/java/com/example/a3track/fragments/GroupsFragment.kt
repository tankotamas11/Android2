package com.example.a3track.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.a3track.R
import com.example.a3track.repository.TrackerRepository
import com.example.a3track.viewmodels.DepartmentsViewModel
import com.example.a3track.viewmodels.DepartmentsViewModelFactory
import com.example.a3track.viewmodels.TasksViewModel
import com.example.a3track.viewmodels.TasksViewModelFactory


class GroupsFragment : Fragment() {

    private lateinit var departmentsVM:DepartmentsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory= DepartmentsViewModelFactory(TrackerRepository())
        departmentsVM= ViewModelProvider(this,factory).get(DepartmentsViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_groups, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val szoveg: TextView = view.findViewById(R.id.groupsTextView)
        val sharedPreferences = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)
        val retrievedToken = sharedPreferences.getString("token",null)
        departmentsVM.readDepartments(retrievedToken.toString())
        departmentsVM.taskList.observe(viewLifecycleOwner){
            Log.i("DDD","token1: " + retrievedToken.toString())
            val depart=departmentsVM.taskList.value
            szoveg.text=depart!!.size.toString()
            Log.i("DDD","sikeres lekerdezes")
        }
    }



}