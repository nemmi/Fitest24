package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov


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
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chat_coach)
        val messageChat = findViewById<EditText>(R.id.editText3)
    }
    fun chatCoachClick(view: View) {
        when (view.id) {
            R.id.profile -> {
                val intent = Intent(this, ProfileTrener::class.java)
                startActivity(intent)
            }
            R.id.button_clients -> {
                val intent = Intent(this, ListClient::class.java)
                startActivity(intent)
            }
            R.id.button_clients_profile -> {
                val intent = Intent(this, ProfileClientView::class.java)
                startActivity(intent)
            }
            R.id.button_chat -> {
                val intent = Intent(this, SpisocChatov::class.java)
                startActivity(intent)
            }
            R.id.button2 -> {
                /* if (!editText3.text.toString().isEmpty()){
                                   sendData()
                               }else{
                                   Toast.makeText(this, "Пожалуйста, введите сообщение", Toast.LENGTH_SHORT).show()
                               }*/
            }

        }
    }
    /* private fun sendData() {
        database?.
            child("messages")?.
            child(java.lang.String.valueOf(System.currentTimeMillis()))?.
            setValue(Message(editText3.text.toString()))

        //clear the text
        editText3.setText("")
    }
*/
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}