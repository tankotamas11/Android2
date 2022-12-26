package com.example.a3track.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.a3track.R


class ProfileFragment : Fragment() {
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
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }
        /*
        * val editText: EditText = view.findViewById(R.id.editTextTextMultiLine)
        userListViewModel.readUsers()
        userListViewModel.userList.observe(viewLifecycleOwner) {
            val userList = userListViewModel.userList.value
            editText.setText("User list size ${userList!![15]}")
            Log.i("xxx", userList.toString())
        }
        * */
    }
}