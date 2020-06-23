package com.example.fitest

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_chat_clients.*


class Chat_Sportsmen : AppCompatActivity() {

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
        setContentView(R.layout.activity_chat_clients)
        val messageChat = findViewById<EditText>(R.id.editText3)
    }
    private val database = FirebaseDatabase.getInstance().reference

    private fun chatSportClick(view: View) {
        when (view.id) {
            R.id.profile -> {
                val intent = Intent(this, ProfileClient::class.java)
                startActivity(intent)
            }
            R.id.button_training -> {
                val intent = Intent(this, Trainings_Sportsmen::class.java)
                startActivity(intent)
            }
            R.id.button_eats -> {
                val intent = Intent(this, Chat_Coach::class.java)
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