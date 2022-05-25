package com.bihteryalcin.bihteryalcin_quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StartButton.setOnClickListener{
            if(EnterYourName.text.isEmpty()){

                //I'm adding toast to warn user!

                Toast.makeText(this, "Enter Your Name!",Toast.LENGTH_SHORT).show()
            }
            else {
                val value = EnterYourName.text.toString()
                val intent = Intent(this, QuizActivity :: class.java)
                intent.putExtra("key", value)
                startActivity(intent)
                finish()
            }


        }


    }
}