package com.example.a3track

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.replace
import com.example.a3track.databinding.ActivityMainBinding
import com.example.a3track.databinding.ActivityMenuBinding
import com.example.a3track.fragments.ActivitiesFragment
import com.example.a3track.fragments.GroupsFragment
import com.example.a3track.fragments.ProfileFragment
import com.example.a3track.fragments.TasksFragment

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(TasksFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId){

                R.id.mytask -> replaceFragment(TasksFragment())
                R.id.atcivities -> replaceFragment(ActivitiesFragment())
                R.id.groups -> replaceFragment(GroupsFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
            else -> {

            }
            }
            true

        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager= supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }
}