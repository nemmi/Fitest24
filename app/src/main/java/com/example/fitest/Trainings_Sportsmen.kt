package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View



class Trainings_Sportsmen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainings)

    }
        fun trenSportsmenClick(view: View) {
            when (view.id){
                R.id.button_training ->{
                    val intent = Intent(this, Trainings_Sportsmen::class.java)
                    startActivity(intent)
                }
                R.id.button_eats ->{
                    val intent = Intent(this, Anketa_Coach::class.java)
                    startActivity(intent)
                }
                R.id.button_chats ->{
                    val intent = Intent(this, Chat_Sportsmen::class.java)
                    startActivity(intent)
                }
                R.id.profile ->{
                    val intent = Intent(this, Anketa_Coach::class.java)
                    startActivity(intent)
                }
                R.id.button_day1 ->{

                }
                R.id.button_day2 ->{

                }
                R.id.button_day3 ->{

                }
            }
        }

}