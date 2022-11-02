package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentQuestionBinding
import com.example.myapplication.viewmodels.QuizVM

class QuestionFragment : Fragment() {

    val TAG= "QuestionFragment"


    private lateinit var textView:TextView
    private  lateinit var radioGroup:RadioGroup
    private lateinit var nextQuestion: Button
    private val viewModel :QuizVM by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val bind= FragmentQuestionBinding.inflate(layoutInflater)
        val nexfragment = FinishFragment()
        val prezent = QuestionFragment()

        bind.options.text=viewModel.getQuestion()
            bind.R1.text=viewModel.getAnswer1()
            bind.R2.text=viewModel.getAnswer2()
            bind.R3.text=viewModel.getAnswer3()
            bind.R4.text=viewModel.getAnswer4()
        if (!viewModel.isFinalQuestion()) {
            bind.submitQuestion.visibility=View.GONE
        }
        else{
            bind.nextQuestion.visibility=View.GONE
        }

        bind.nextQuestion.setOnClickListener {




                    if(bind.radio.checkedRadioButtonId==-1){
                        Toast.makeText(activity, "Choose an answer ", Toast.LENGTH_SHORT).show()}

                    else {
                        var seged=bind.radio.checkedRadioButtonId.toString().toInt()-bind.R1.id.toInt()
                        Log.i(TAG,"onStop() called.$seged")

                        if(seged+1==viewModel.getCorrectAns()){
                            viewModel.CorrectAns()
                        }
                        fragmentManager?.beginTransaction()?.apply {
                            replace(
                                R.id.container_fragment,
                                prezent,
                                QuestionFragment::class.java.simpleName
                            )
                                .addToBackStack(null)
                                .commit()
                        }
                        viewModel.incrementCounter()

                    }
                }
        bind.submitQuestion.setOnClickListener() {
            if(bind.radio.checkedRadioButtonId==-1){

                Toast.makeText(activity, "Choose an answer ", Toast.LENGTH_SHORT).show()}

            else {
                var seged=bind.radio.checkedRadioButtonId.toString().toInt()-bind.R1.id.toInt()
                Log.i(TAG,"onStop() called.$seged")

                if(seged+1==viewModel.getCorrectAns()){
                    viewModel.CorrectAns()
                }
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