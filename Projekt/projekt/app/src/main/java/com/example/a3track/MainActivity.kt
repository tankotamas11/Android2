package com.example.a3track

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val controller = findNavController(R.id.nav_host_fragment)

//        // Read data from preferences
//        val prefs = this.getPreferences(MODE_PRIVATE)
//        val token = prefs.getString("token", "")
//        val id =  prefs.getInt("userId",40)
//        val deadline = prefs.getLong("deadline", 0L)
//
//        Log.i("xxx", "token: " + token+ "  id:  "+id)
//        // @TODO - check the token's validity
//        val isValid = true
//        if (!token.equals("") && isValid ) {
//            MyApplication.token = token!!
//            MyApplication.email = prefs.getString("email","")!!
//
//            controller.navigate(R.id.profileFragment)
//        }
    /*
    * val sharedPreferences = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)
        val retrievedToken = sharedPreferences.getString("token",null)
        val retrievedDeadline = sharedPreferences.getLong("deadline",12345678)
        Log.i("Splash Screen token",retrievedToken.toString())
        Log.i("Splash Screen deadline",retrievedDeadline.toString())
        Log.i("Splash Screen time ",Date().time.toString())
        if(Date().time < retrievedDeadline){
            currentUserViewModel.updateLoginResponse(retrievedDeadline,retrievedToken.toString(),0)
            currentUserViewModel.getCurrentUser()
            Log.i("Splash Screen get id",currentUserViewModel.getID().toString())
            if (currentUserViewModel.getID() > 0){
                startActivity(Intent(activity,MainActivity::class.java))
            }else{
                findNavController().navigate(R.id.action_splashScreen_to_loginScreen)
            }
        }else{
            findNavController().navigate(R.id.action_splashScreen_to_loginScreen)
        }*/
    }
}