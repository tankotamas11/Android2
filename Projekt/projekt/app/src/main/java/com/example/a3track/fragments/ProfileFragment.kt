package com.example.a3track.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.a3track.MyApplication
import com.example.a3track.R
import com.example.a3track.model.LoginResponse
import com.example.a3track.viewmodels.UserViewModel


class ProfileFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.logout)
        button.setOnClickListener {
            val prefs = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)

            val edit = prefs.edit()
            edit.putString("token", "")
            edit.putLong("deadline", 0L)
            edit.putString("email", "")
            //edit.putString("id","0")
            edit.apply()
            findNavController().navigate(R.id.action_profileFragment_to_initFragment)
        }

       // userViewModel.readUsers()
//        userViewModel.userList.observe(viewLifecycleOwner) {
//            val userList = userViewModel.userList.value
//                //editText.setText("User list size ${userList!![15]}")
//            var i:Int
//            var k=1000
//            var t=MyApplication.email
//
//            for( i in 0..userList!!.size-1){
//            if (t.equals(userList!![i].email)){
//                k=i
//            }
//        }
//            Log.i("xxx", k.toString())
//        }

    }
}