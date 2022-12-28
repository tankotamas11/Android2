package com.example.a3track.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.a3track.MainActivity
import com.example.a3track.MyApplication
import com.example.a3track.R
import com.example.a3track.model.CurrentUser
import com.example.a3track.model.GetCUResponse
import com.example.a3track.model.LoginResponse
import com.example.a3track.model.User
import com.example.a3track.repository.TrackerRepository
import com.example.a3track.viewmodels.*


class ProfileFragment : Fragment() {

    private  val currentUserViewModel: CurrentUserViewModel by activityViewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name: TextView = view.findViewById(R.id.profileName)
        val mentor:TextView= view.findViewById(R.id.mentorName)
        val email:TextView = view.findViewById(R.id.profile_email)
        val location:TextView = view.findViewById(R.id.profile_location)
        val phone:TextView = view.findViewById(R.id.profile_phone)
        val button: Button = view.findViewById(R.id.logout)
        var userList = MutableLiveData<List<GetCUResponse>>()
        button.setOnClickListener {
            val prefs = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)

            val edit = prefs.edit()
            edit.putString("token", "")
            edit.putLong("deadline", 0L)
            edit.putString("email", "")
            //edit.putString("id","0")
            edit.apply()
            startActivity(Intent(activity,MainActivity::class.java))
        }
//        val sharedPreferences = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)
//        val retrievedToken = sharedPreferences.getString("token",null)
//        val currentId=sharedPreferences.getString("id","").toString().toInt()
//        currentUserViewModel.getusers(retrievedToken.toString())
//        currentUserViewModel.usersList.observe(viewLifecycleOwner){
//            val userList = currentUserViewModel.usersList.value
//            //Log.i("ppp",userList!![37].last_name+userList!![37].email)
//            var currentIndex:Int=0
//            for(i in 0..userList!!.size-1){
//                if (userList!![i].ID==currentId){
//                    currentIndex=i
//                }
//            }
//            name.text=userList!![currentIndex].last_name + " "+userList!![currentIndex].first_name
//
//            email.text=userList!![currentIndex].email
//            //location.text=userList!![currentIndex].location
//        }


        //currentUserViewModel.getName()
        Log.i("ppp","itt vagyunk:"+currentUserViewModel.getName())
        name.text=currentUserViewModel.getName()
        email.text=currentUserViewModel.getEmail()
        location.text=currentUserViewModel.getLocation()
        phone.text=currentUserViewModel.getPhoneNum()
//            val userList = userViewModel.userList.value
//                name.setText("User list size ${userList!![39]}")
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