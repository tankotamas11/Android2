package com.example.a3track.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.a3track.R
import com.example.a3track.databinding.FragmentTasksBinding
import com.example.a3track.viewmodels.CurrentUserViewModel


class TasksFragment : Fragment() {

    private val currentUserViewModel:CurrentUserViewModel by activityViewModels()
    private var _binding:FragmentTasksBinding?=null
    private val binding get() = _binding!!

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



}