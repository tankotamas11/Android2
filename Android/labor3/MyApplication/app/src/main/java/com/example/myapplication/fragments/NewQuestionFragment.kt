package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNewQuestionBinding
import com.example.myapplication.databinding.FragmentQuestionBinding
import com.example.myapplication.viewmodels.QuizVM


class NewQuestionFragment : Fragment() {

    private val viewModel : QuizVM by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind= FragmentNewQuestionBinding.inflate(layoutInflater)

        val nextfragment= MenuFragment()

        bind.button.setOnClickListener(){
            if (bind.editTextQuestion.text.toString().equals("") && bind.editTextAnswer1.text.toString().equals("")  && bind.editTextAnswer2.text.toString().equals("") && bind.editTextAnswer3.text.toString().equals("") && bind.editTextAnswer4.text.toString().equals("") && bind.editTextCorrectAnswer.text.toString().equals("")){
                Toast.makeText(activity, "Fill in all fields", Toast.LENGTH_SHORT).show()
            }
            else{
                viewModel.newQuestion(bind.editTextQuestion.toString())
                viewModel.newAnswer(bind.editTextAnswer1.toString())
                viewModel.newAnswer(bind.editTextAnswer2.toString())
                viewModel.newAnswer(bind.editTextAnswer3.toString())
                viewModel.newAnswer(bind.editTextAnswer4.toString())
                viewModel.newCorrectAnswer(bind.editTextCorrectAnswer.toString().toInt())

                fragmentManager?.beginTransaction()?.apply {
                    replace(
                        R.id.container_fragment,
                        nextfragment,
                        MenuFragment::class.java.simpleName
                    )
                        .addToBackStack(null)
                        .commit()
                }

            }
        }

        return bind.root
    }


}