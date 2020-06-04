package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar

class Anketa_Sportsmen_P1  : AppCompatActivity() {

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
        setContentView(R.layout.activity_sportsmen_anketa1)
       /* val sec_name = findViewById<EditText>(R.id.editSecondName)
        val name = findViewById<EditText>(R.id.editName)
        val age = findViewById<EditText>(R.id.editAge)
        val phone = findViewById<EditText>(R.id.editPhoneNumber)
        val experience = findViewById<EditText>(R.id.editExpTr)
        val goals = findViewById<EditText>(R.id.editGoals)
        val eat = findViewById<EditText>(R.id.editDontEat)
        val height = findViewById<EditText>(R.id.editHeight)
        val weight = findViewById<EditText>(R.id.editWeight)
        val bads = findViewById<EditText>(R.id.editBADS)
        val blood = findViewById<EditText>(R.id.editBlood)
        val choiceEat = findViewById<Button>(R.id.button_choose)
        val back = findViewById<Toolbar>(R.id.toolbar3)*/

    }

    fun anketaSp1Click(view: View) {
        when (view.id) {
            R.id.toolbar3 -> {
                val intent = Intent(this, Registration::class.java)
                startActivity(intent)
            }
            R.id.button_choose -> {
                val intent = Intent(this, Anketa_Sportsmen_P2::class.java)
                startActivity(intent)
            }

        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}