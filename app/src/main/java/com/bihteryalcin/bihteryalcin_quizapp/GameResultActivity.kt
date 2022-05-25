package com.bihteryalcin.bihteryalcin_quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_result.*

class GameResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_result)
        var correct: String =""
        var wrong:String =""
        var joker:String =""
        var name: String =""
        var totalScore: Int = 0
        val extras = intent.extras


        if (extras != null) {
            name  = extras.getString("name").toString()
            correct  = extras.get("Correct").toString()
            wrong = extras.get("Wrong").toString()
            joker = extras.get("Joker").toString()
        }

        totalScore = (correct.toInt()*10) - (wrong.toInt()*10) - (joker.toInt()*5)
        Name.text = "You Finished the Quiz ${name} !"


        if(correct=="0"){
            Correct.text ="No correct answers!"
        }
        else{
            Correct.text = "Correct Answers:${correct}"
        }

        if(wrong=="0"){
            Wrong.text ="Congratulations no wrong answers!"
        }
        else{
            Wrong.text = "Wrong Answers:${wrong}"
        }

        if(joker=="0"){
            Joker.text ="No joker used!"
        }
        else{
            Joker.text = "Used Jokers:${joker}"
        }

        Point.text = "Total Score:${totalScore}"


    }
}