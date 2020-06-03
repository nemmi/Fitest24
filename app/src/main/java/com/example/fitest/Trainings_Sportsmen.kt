package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View



class Trainings_Sportsmen : AppCompatActivity() {

    private fun showSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    private fun hideSystemUI() {

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

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
                    val intent = Intent(this, ProfileClient::class.java)
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
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}