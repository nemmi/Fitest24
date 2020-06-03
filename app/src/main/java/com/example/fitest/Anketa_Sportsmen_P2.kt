package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar

class Anketa_Sportsmen_P2 : AppCompatActivity() {

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
        setContentView(R.layout.activity_sportsmen_anketa2)
        val belok = findViewById<EditText>(R.id.editBelok)
        val carbs = findViewById<EditText>(R.id.editCarbs)
        val fat = findViewById<EditText>(R.id.editFats)
        val coach = findViewById<Button>(R.id.button_toCoach)
        val back = findViewById<Toolbar>(R.id.toolbar3)
    }
    fun anketaSp2Click(view: View) {
        when (view.id) {
            R.id.toolbar3 -> {
                val intent = Intent(this, Anketa_Sportsmen_P1::class.java)
                startActivity(intent)
            }
            R.id.button_toCoach -> {
                val intent = Intent(this, Anketa_Sportsmen_P2::class.java)
                startActivity(intent)
            }

        }
    }

}