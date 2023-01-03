package com.example.a3track.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.a3track.R
import com.example.a3track.databinding.ActivityMenuBinding
import com.example.a3track.model.ProfileRequest
import com.example.a3track.viewmodels.CurrentUserViewModel
import com.example.a3track.viewmodels.EditProfileViewModel


class EditProfileFragment : Fragment() {
    private lateinit var binding: ActivityMenuBinding
    private val editProfilVM:EditProfileViewModel by activityViewModels()
    private val currentUserViewModel:CurrentUserViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMenuBinding.inflate(layoutInflater)

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
        val firstname:EditText=view.findViewById(R.id.editFirstname)
        val lastname:EditText=view.findViewById(R.id.editLastname)
        val newimage:EditText=view.findViewById(R.id.editimage)
        firstname.setText(currentUserViewModel.getFirstName())
        lastname.setText(currentUserViewModel.getLastName())
        newimage.setText(currentUserViewModel.getImage())
        button2.setOnClickListener{ //egyszeru visszalepes
          replaceFragment(ProfileFragment())
        }

        button1.setOnClickListener{//valtoztatassal valo visszalepes


            editProfilVM.update(currentUserViewModel.getToken(),ProfileRequest(lastname.text.toString(),firstname.text.toString(),currentUserViewModel.getLocation(),currentUserViewModel.getPhoneNum(),newimage.text.toString()))




            replaceFragment(TasksFragment())
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = requireFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }
}