package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    companion object {
        val max=3
        var counter=1
    }
    private lateinit var textView:TextView
    private  lateinit var radioGroup:RadioGroup
    private lateinit var nextQuestion: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val bind= FragmentQuestionBinding.inflate(layoutInflater)
        val nexfragment = FinishFragment()
        val prezent = QuestionFragment()
        bind.nextQuestion.setOnClickListener {

            if (counter <max){
                fragmentManager?.beginTransaction()?.apply {
                    replace(
                        R.id.container_fragment,
                        prezent,
                        QuestionFragment::class.java.simpleName
                    )
                        .addToBackStack(null)
                        .commit()
                }
                counter++
            }
            else {

                fragmentManager?.beginTransaction()?.apply {
                    replace(
                        R.id.container_fragment,
                        nexfragment,
                        FinishFragment::class.java.simpleName
                    )
                        .addToBackStack(null)
                        .commit()
                }
            }
        }

        return bind.root }

//        return inflater.inflate(R.layout.fragment_question,container,false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        view.apply {
//            initViewItems(this)
//            registerListeners()
//        }
//
//    }
//    private fun initViewItems(view: View) {
//        nextQuestion=view.findViewById(R.id.nextQuestion)
//        textView = view.findViewById(R.id.textView)
//        //radioGroup=view.findViewById(R.id.r)
//
//    }
//
//    private fun registerListeners() {
//        nextQuestion.setOnClickListener {
//            if (counter<max) {
//                findNavController().navigate(R.id.action_question3_self)
//                counter++
//            }
//            else{
//                findNavController().navigate(R.id.action_question3_to_finish3)
//
//            }
//        }
//    }


}