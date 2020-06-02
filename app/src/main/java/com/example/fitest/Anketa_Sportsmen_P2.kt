package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar

class Anketa_Sportsmen_P2 : AppCompatActivity() {

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