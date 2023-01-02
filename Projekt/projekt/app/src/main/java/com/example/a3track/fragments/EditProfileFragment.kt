package com.example.a3track.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.a3track.R
import com.example.a3track.databinding.ActivityMenuBinding


class EditProfileFragment : Fragment() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button2: Button = view.findViewById(R.id.backtoprofile)
        val button1: Button=view.findViewById(R.id.updateprofile)

        button2.setOnClickListener{ //egyszeru visszalepes
            binding= ActivityMenuBinding.inflate(layoutInflater)
            //setContentView(binding.root)
            replaceFragment(TasksFragment())
        }

        button1.setOnClickListener{//valtoztatassal valo visszalepes
            binding= ActivityMenuBinding.inflate(layoutInflater)
            //setContentView(binding.root)
            replaceFragment(ProfileFragment())
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = requireFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }
}