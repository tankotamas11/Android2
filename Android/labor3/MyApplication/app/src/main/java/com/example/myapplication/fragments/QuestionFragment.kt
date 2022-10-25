package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMenuBinding
import com.example.myapplication.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    var qNum = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val bind= FragmentQuestionBinding.inflate(layoutInflater)
        val nexfragment = FinishFragment()
        val prezent = QuestionFragment()
        bind.nextQuestion.setOnClickListener {
            qNum++
            if (qNum > 5){
                fragmentManager?.beginTransaction()?.apply {
                    replace(
                        R.id.container_fragment,
                        prezent,
                        QuestionFragment::class.java.simpleName
                    )
                        .addToBackStack(null)
                        .commit()
                }
                qNum--
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

        return bind.root
    }


}