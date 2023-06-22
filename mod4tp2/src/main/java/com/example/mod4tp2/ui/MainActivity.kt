package com.example.mod4tp2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mod4tp2.R
import com.example.mod4tp2.bo.QuestionReponse
import com.example.mod4tp2.databinding.ActivityMainBinding
import java.util.Collections

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val questions: MutableList<QuestionReponse> = mutableListOf<QuestionReponse>()
    var score: Int = 0
    var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val q1 = QuestionReponse("Est-ce que la terre est plate ?")
        val q2 = QuestionReponse("Superman est le plus fort des avengers")
        val q3 = QuestionReponse("Est-ce qu'internet reviendra ?", true)

        questions.add(q1)
        questions.add(q2)
        questions.add(q3)

        binding.question = questions[index]
        binding.score = score

        binding.buttonTrue.setOnClickListener {
            onClickEvent(true)
//            if(questions[index].response){
//                score++
//            }
//
//            if(index < questions.size){
//                binding.question = questions[++index]
//            }
        }

        binding.buttonFalse.setOnClickListener {
            onClickEvent(false)
//            if(!questions[index].response){
//                score++
//            }
//
//            if(index < questions.size){
//                binding.question = questions[++index]
//            }
        }
    }

    fun onClickEvent(button: Boolean) {

        if (questions[index].response == button) {
            score++
            binding.score = score
        }
        index++
        if (index < questions.size) {
            binding.question = questions[index]
        }else{
            binding.tvQuestion.text = "Terminé !"
            binding.buttonTrue.isEnabled = false
            binding.buttonFalse.isEnabled = false

        }
    }

}