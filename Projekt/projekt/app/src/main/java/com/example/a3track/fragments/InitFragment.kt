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
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a3track.MainActivity
import com.example.a3track.MenuActivity
import com.example.a3track.R
import com.example.a3track.model.CurrentUser
import com.example.a3track.repository.TrackerRepository
import com.example.a3track.viewmodels.CurrentUserViewModel
import java.util.*


class InitFragment : Fragment() {

    private val currentUserViewModel : CurrentUserViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_init, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)
        val retrievedToken = sharedPreferences.getString("token",null)
        val retrievedDeadline = sharedPreferences.getLong("deadline",0L)
        val id=sharedPreferences.getString("id","")
        val button: Button = view.findViewById(R.id.startbttn)
        Log.i("Splash Screen token",retrievedToken.toString())
        Log.i("Splash Screen deadline",retrievedDeadline.toString())
        Log.i("Splash Screen time ", Date().time.toString())
        Log.i("yyy","dedline: "+ retrievedDeadline )
        Log.i("yyy","id: "+ id )
        var seged=id.toString().toInt()

        button.setOnClickListener{
        if(Date().time < retrievedDeadline){ // < kell

                currentUserViewModel.updateLoginResponse(retrievedDeadline,retrievedToken.toString(),0)
                currentUserViewModel.getCurrentUser()
            currentUserViewModel.updateUserId(seged)

                if (seged > 0){ // > kell
                    Log.i("yyy","jo id "+ seged)
                    startActivity(Intent(activity, MenuActivity::class.java))
                }else{
                    Log.i("yyy","0 id")
                    findNavController().navigate(R.id.action_initFragment_to_loginFragment)
                }
            }else{
                Log.i("yyy","deadline finish")
                findNavController().navigate(R.id.action_initFragment_to_loginFragment)
            }
        }
    }



}