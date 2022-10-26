package com.example.myapplication.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {


private lateinit var textView :TextView
private lateinit var startbttn:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind= FragmentMenuBinding.inflate(layoutInflater)

        val nexfragment = QuestionFragment()
        bind.startbutton.setOnClickListener {


            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container_fragment,nexfragment, QuestionFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        return bind.root
    }

//        return inflater.inflate(R.layout.fragment_menu,container,false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        view.apply {
//            initViewItems(this)
//            registerListeners()
//        }
//   }
//
//    private fun initViewItems(view: View) {
//        startbttn=view.findViewById(R.id.startbutton)
//        textView = view.findViewById(R.id.textView)
//    }
//
//    private fun registerListeners() {
//        startbttn.setOnClickListener {
////            if(!textView.text.isEmpty()){
////                Toast.makeText(context,"Name is empty",Toast.LENGTH_SHORT).show()
////            }
////            else {
//                findNavController().navigate(R.id.action_menu3_to_question3)
//            //}
//        }
//    }


}