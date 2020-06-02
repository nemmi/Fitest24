package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class Chat_Sportsmen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_clients)
        val messageChat = findViewById<EditText>(R.id.editText3)
    }

    fun chatSportClick(view: View) {
        when (view.id) {
            R.id.profile -> {
                val intent = Intent(this, Registration::class.java)
                startActivity(intent)
            }
            R.id.button_training -> {
                val intent = Intent(this, Anketa_Sportsmen_P2::class.java)
                startActivity(intent)
            }
            R.id.button_eats -> {
                val intent = Intent(this, Chat_Coach::class.java)
                startActivity(intent)
            }
            R.id.button_chats -> {
                val intent = Intent(this, Chat_Coach::class.java)
                startActivity(intent)
            }
            R.id.button2 -> {

            }

        }
    }
}