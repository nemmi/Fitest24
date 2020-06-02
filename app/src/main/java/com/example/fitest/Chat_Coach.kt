package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast


class Chat_Coach : AppCompatActivity() {

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
}