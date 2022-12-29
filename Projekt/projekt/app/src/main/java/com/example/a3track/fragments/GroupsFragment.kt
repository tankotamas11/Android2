package com.example.a3track.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3track.MyAdapter
import com.example.a3track.R
import com.example.a3track.repository.TrackerRepository
import com.example.a3track.viewmodels.DepartmentsViewModel
import com.example.a3track.viewmodels.DepartmentsViewModelFactory
import com.example.a3track.viewmodels.TasksViewModel
import com.example.a3track.viewmodels.TasksViewModelFactory

private lateinit var adapter: MyAdapter
private lateinit var recyclerView: RecyclerView


class GroupsFragment : Fragment() {

    private lateinit var departmentsVM:DepartmentsViewModel
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory= DepartmentsViewModelFactory(TrackerRepository())
        departmentsVM= ViewModelProvider(this,factory).get(DepartmentsViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_groups, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val szoveg: TextView = view.findViewById(R.id.groupsTextView)
        val sharedPreferences = requireActivity().getSharedPreferences("TRACKER", Context.MODE_PRIVATE)
        val retrievedToken = sharedPreferences.getString("token",null)
        departmentsVM.readDepartments(retrievedToken.toString())
        departmentsVM.taskList.observe(viewLifecycleOwner){
            Log.i("DDD","token1: " + retrievedToken.toString())
            val depart=departmentsVM.taskList.value
            //szoveg.text=depart!!.size.toString()
            Log.i("DDD","sikeres lekerdezes")
            var listofName= arrayListOf<String>()
            for (i in 0..depart!!.size-1){
                listofName.add(depart!![i].name)
            }
            Log.i("DDD","sikeres lista")
            val layoutManager= LinearLayoutManager(context)
            recyclerView=view.findViewById(R.id.recyclerView)

            recyclerView.layoutManager=layoutManager
            recyclerView.setHasFixedSize(true)
            adapter= MyAdapter(listofName)
            recyclerView.adapter=adapter





            //listView.setAdapter(adapter)

//            listView.onItemClickListener=object :OnItemClickListener{
//                override fun onItemClick(parent: AdapterView<*>, view: View,
//                                         position: Int, id: Long) {
//
//                    // value of item that is clicked
//                    val itemValue = listView.getItemAtPosition(position) as String
//
//                    // Toast the values
//                    Toast.makeText(context,
//                        "Position :$position\nItem Value : $itemValue", Toast.LENGTH_LONG)
//                        .show()
//                }
          //  }


        }
    }



}