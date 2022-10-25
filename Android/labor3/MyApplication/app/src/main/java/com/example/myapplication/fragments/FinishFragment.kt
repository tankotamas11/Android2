package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFinishBinding
import com.example.myapplication.databinding.FragmentMenuBinding

class FinishFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind= FragmentFinishBinding.inflate(layoutInflater)
        val nexfragment = MenuFragment()
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