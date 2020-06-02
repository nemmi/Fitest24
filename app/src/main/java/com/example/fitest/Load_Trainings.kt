package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class Load_Trainings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_trainings)
        val exercise1 = findViewById<EditText>(R.id.editExercise1)
        val podhod1 = findViewById<EditText>(R.id.editPodhods1)
        val weight1 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment1 = findViewById<EditText>(R.id.editComment1)
        val exercise2 = findViewById<EditText>(R.id.editExercise1)
        val podhod2 = findViewById<EditText>(R.id.editPodhods1)
        val weight2 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment2 = findViewById<EditText>(R.id.editComment1)
        val exercise3 = findViewById<EditText>(R.id.editExercise1)
        val podhod3 = findViewById<EditText>(R.id.editPodhods1)
        val weight3 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment3 = findViewById<EditText>(R.id.editComment1)
        val exercise4 = findViewById<EditText>(R.id.editExercise1)
        val podhod4 = findViewById<EditText>(R.id.editPodhods1)
        val weight4 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment4 = findViewById<EditText>(R.id.editComment1)
        val exercise5 = findViewById<EditText>(R.id.editExercise1)
        val podhod5 = findViewById<EditText>(R.id.editPodhods1)
        val weight5 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment5 = findViewById<EditText>(R.id.editComment1)
        val exercise6 = findViewById<EditText>(R.id.editExercise1)
        val podhod6 = findViewById<EditText>(R.id.editPodhods1)
        val weight6 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment6 = findViewById<EditText>(R.id.editComment1)
        val exercise7 = findViewById<EditText>(R.id.editExercise1)
        val podhod7 = findViewById<EditText>(R.id.editPodhods1)
        val weight7 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment7 = findViewById<EditText>(R.id.editComment1)
        val profile = findViewById<Button>(R.id.profile)
        val day1 = findViewById<Button>(R.id.button_day1)
        val day2 = findViewById<Button>(R.id.button_day2)
        val day3 = findViewById<Button>(R.id.button_day3)
        val save = findViewById<Button>(R.id.button_save)
        val loadV1 = findViewById<Button>(R.id.button_loadVideo1)
        val loadV2 = findViewById<Button>(R.id.button_loadVideo2)
        val loadV3 = findViewById<Button>(R.id.button_loadVideo3)
        val loadV4 = findViewById<Button>(R.id.button_loadVideo4)
        val loadV5 = findViewById<Button>(R.id.button_loadVideo5)
        val loadV6 = findViewById<Button>(R.id.button_loadVideo6)
        val loadV7 = findViewById<Button>(R.id.button_loadVideo7)
        val clients = findViewById<Button>(R.id.button_clients)
        val clientsProfile = findViewById<Button>(R.id.button_clients_profile)
        val chat = findViewById<Button>(R.id.button_chat)
    }


   fun loadTrenClick(view:View) {
        when (view.id){
            R.id.button_loadVideo1 ->{

            }
            R.id.button_loadVideo2 ->{

            }
            R.id.button_loadVideo3 ->{

            }
            R.id.button_loadVideo4 ->{

            }
            R.id.button_loadVideo5 ->{

            }
            R.id.button_loadVideo6 ->{

            }
            R.id.button_loadVideo7 ->{

            }
            R.id.button_clients ->{
                val intent = Intent(this, Anketa_Coach::class.java)
                startActivity(intent)
            }
            R.id.button_clients_profile ->{
                val intent = Intent(this, Anketa_Coach::class.java)
                startActivity(intent)
            }
            R.id.button_chat ->{
                val intent = Intent(this, Anketa_Coach::class.java)
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