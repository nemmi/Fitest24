package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast


class Chat_Coach : AppCompatActivity() {

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
        setContentView(R.layout.activity_chat_coach)
        val messageChat = findViewById<EditText>(R.id.editText3)
    }
    fun chatCoachClick(view: View) {
        when (view.id) {
            R.id.profile -> {
                val intent = Intent(this, Registration::class.java)
                startActivity(intent)
            }
            R.id.button_clients -> {
                val intent = Intent(this, Anketa_Sportsmen_P2::class.java)
                startActivity(intent)
            }
            R.id.button_clients_profile -> {
                val intent = Intent(this, Chat_Coach::class.java)
                startActivity(intent)
            }
            R.id.button_chat -> {
                val intent = Intent(this, Chat_Coach::class.java)
                startActivity(intent)
            }
            R.id.button2 -> {

            }

        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}