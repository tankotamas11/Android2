package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFinishBinding
import com.example.myapplication.databinding.FragmentMenuBinding
import com.example.myapplication.viewmodels.QuizVM

class FinishFragment : Fragment() {
    private val viewmodel:QuizVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind= FragmentFinishBinding.inflate(layoutInflater)
        val nexfragment = MenuFragment()
        bind.finishText.text=""+viewmodel.getUserName()
        val point=viewmodel.getResult()
        val totalpoint=viewmodel.getMaxPoint()
        bind.result.text="$point / $totalpoint"
        viewmodel.CounterToStart()
        viewmodel.ResultToStart()

        bind.again.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container_fragment,nexfragment, MenuFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        return bind.root
       }


}