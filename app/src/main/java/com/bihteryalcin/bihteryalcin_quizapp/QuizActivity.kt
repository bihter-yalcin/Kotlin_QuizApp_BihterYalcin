package com.bihteryalcin.bihteryalcin_quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz.*


class QuizActivity : AppCompatActivity() {
    //private var CurrPosition:Int = 1
    //private var Qlist: ArrayList<QuizQuestionModel>? = null
    private var SelectedOpt: Int = 0
    private val maximum =10 // It can be changed according to maximum number of questions
    var currentQuestion = 1
    var questionList = QuestionList.getQuestionList()
    private var question : QuizQuestionModel? = null
    lateinit var name:String
    var usedJoker: Int =0
    var correct: Int =0
    var wrong: Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)



        val extras = intent.extras
        if (extras != null) {
            name = extras.getString("key").toString()
        }

        Name.text ="Go On ${name}!"

            SetQuestion()
        OptOne.setOnClickListener {
            SelectedOpt = 1
            setBackgroundColor()
            it.setBackgroundColor(Color.MAGENTA)
        }

        OptTwo.setOnClickListener {
            SelectedOpt = 2
            setBackgroundColor()
            it.setBackgroundColor(Color.MAGENTA)
        }


        OptThree.setOnClickListener {
            SelectedOpt = 3
            setBackgroundColor()
            it.setBackgroundColor(Color.MAGENTA)
        }

        OptFour.setOnClickListener {
            SelectedOpt = 4
            setBackgroundColor()
            it.setBackgroundColor(Color.MAGENTA)
        }



        Submit.setOnClickListener{

            if(SelectedOpt!= 0 ){
            GivePoint()
            currentQuestion++
            SetQuestion()

            if (currentQuestion == 10){

                Submit.text = "Finish"
                Submit.setOnClickListener(){
                    GivePoint()
                    val intent = Intent(this, GameResultActivity :: class.java)
                    intent.putExtra("Correct", correct)
                    intent.putExtra("Wrong", wrong)
                    intent.putExtra("Joker", usedJoker)
                    intent.putExtra("name",name)
                    startActivity(intent)
                    finish()
                }
            }
            }
            else
            {Toast.makeText(this, "Answer the Question!",Toast.LENGTH_SHORT).show()}

        }


        Joker.setOnClickListener{
            Joker()
        }





    }

    private fun setBackgroundColor() {
        OptOne.setBackgroundColor(Color.GRAY)
        OptTwo.setBackgroundColor(Color.GRAY)
        OptThree.setBackgroundColor(Color.GRAY)
        OptFour.setBackgroundColor(Color.GRAY)
    }


    private fun SetQuestion(){
        setBackgroundColor()
        question = questionList[currentQuestion-1]

        Count.text = "$currentQuestion" + "/" + "$maximum"

        Question.text = question!!.question // with !! I said my code that question can not be null and it wont be null
        OptOne.text = question!!.option1
        OptTwo.text = question!!.option2
        OptThree.text = question!!.option3
        OptFour.text = question!!.option4



    }

    private fun Joker(){
        usedJoker++
        val arrayList: ArrayList<String> = ArrayList<String>()

        arrayList.add(question!!.option1)
        arrayList.add(question!!.option2)
        arrayList.add(question!!.option3)
        arrayList.add(question!!.option4)
        val answer= question!!.correctAnswer

        arrayList.removeAt(answer-1)

        val random = (0..2).random()
        val a = arrayList[random]
        Toast.makeText(this, "Answer is not "+"$a", Toast.LENGTH_LONG).show()


    }

    private fun GivePoint() {


        if (SelectedOpt == question!!.correctAnswer &&SelectedOpt != 0  ) {

            correct++

            Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show()
        }
        if (SelectedOpt != question!!.correctAnswer && SelectedOpt != 0  )
        {

            wrong ++
            Toast.makeText(this, "WRONG!", Toast.LENGTH_SHORT).show()

        }

    }


}