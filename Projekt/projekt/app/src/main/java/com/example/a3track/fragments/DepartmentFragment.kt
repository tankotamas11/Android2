package com.example.a3track.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3track.DepartmentsAdapter
import com.example.a3track.MyAdapter
import com.example.a3track.R
import com.example.a3track.databinding.ActivityMenuBinding
import com.example.a3track.model.User
import com.example.a3track.repository.TrackerRepository
import com.example.a3track.viewmodels.DepartmentsViewModel
import com.example.a3track.viewmodels.DepartmentsViewModelFactory
import com.example.a3track.viewmodels.UserViewModel
import com.example.a3track.viewmodels.UserViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class DepartmentFragment(poz:Int) : Fragment() {
    private lateinit var departmentsVM: DepartmentsViewModel
    private  lateinit var userListVM: UserViewModel
    private lateinit var text:TextView
    private val t=poz
    private lateinit var adapter: DepartmentsAdapter
    private lateinit var recyclerView3: RecyclerView
    private lateinit var button: Button
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory= DepartmentsViewModelFactory(TrackerRepository())
        departmentsVM= ViewModelProvider(this,factory).get(DepartmentsViewModel::class.java)
        val factory1= UserViewModelFactory(TrackerRepository())
        userListVM=ViewModelProvider(this,factory1).get(UserViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_department, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text=view.findViewById(R.id.departmentGroupName)
        button=view.findViewById(R.id.backtogroup)
        button.setOnClickListener{
            binding= ActivityMenuBinding.inflate(layoutInflater)
            //setContentView(binding.root)
            replaceFragment(GroupsFragment())
        }


        val sharedPreferences = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)
        val retrievedToken = sharedPreferences.getString("token",null)
        departmentsVM.readDepartments(retrievedToken.toString())
        departmentsVM.taskList.observe(viewLifecycleOwner){
            Log.i("DDD","token1: " + retrievedToken.toString())
            val depart=departmentsVM.taskList.value
            userListVM.readUsers(retrievedToken.toString())
            userListVM.userList.observe(viewLifecycleOwner) {
                var userList = userListVM.userList.value as ArrayList<User>

                var segedid:Int=0
                for (i in 0..depart!!.size-1){
                    if(depart!![i].ID==t){
                        segedid=depart!![i].ID
                        text.setText(depart!![i].name)
                    }
                }

                var listofName= arrayListOf<String>()
                for (i in 0..userList!!.size-1){
                    if(userList!![i].department_id==segedid) {
                        listofName.add(userList!![i].first_name+" "+userList!![i].last_name)
                    }
                }
                Log.i("GGG",listofName.size.toString())
                val layoutManager= LinearLayoutManager(context)
                recyclerView3=view.findViewById(R.id.recyclerView3)

                recyclerView3.layoutManager=layoutManager
                recyclerView3.setHasFixedSize(true)
                adapter= DepartmentsAdapter(listofName)
                recyclerView3.adapter=adapter

            }
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = requireFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }


}