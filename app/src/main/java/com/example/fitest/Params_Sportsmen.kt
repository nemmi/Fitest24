package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView



class Params_Sportsmen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_body_params)
        val name = findViewById<TextView>(R.id.urName)
        val weight = findViewById<TextView>(R.id.textWeight)
        val weight2 = findViewById<TextView>(R.id.textWeight2)
        val shoulders = findViewById<TextView>(R.id.textShoulder)
        val shoulders2 = findViewById<TextView>(R.id.textShoulder2)
        val tall = findViewById<TextView>(R.id.textTall)
        val breats = findViewById<TextView>(R.id.textBreast)
        val breast2 = findViewById<TextView>(R.id.textBreast2)
        val biceps = findViewById<TextView>(R.id.textBiceps)
        val biceps2 = findViewById<TextView>(R.id.textBiceps2)
        val waist = findViewById<TextView>(R.id.textWaist)
        val waist2 = findViewById<TextView>(R.id.textWaist2)
        val buttocks = findViewById<TextView>(R.id.textButtocks)
        val buttocks2 = findViewById<TextView>(R.id.textButtocks2)
        val hip = findViewById<TextView>(R.id.textHip)
        val hip2 = findViewById<TextView>(R.id.textHip)

    }

    fun paramSportClick(view: View) {
        when (view.id) {
            R.id.toolbar -> {
                val intent = Intent(this, Registration::class.java)
                startActivity(intent)
            }
            R.id.button_edit -> {
                val intent = Intent(this, Params_Edit::class.java)
                startActivity(intent)
            }
            R.id.button_trainings -> {
                val intent = Intent(this, Trainings_Sportsmen::class.java)
                startActivity(intent)
            }
            R.id.button_eats -> {
                val intent = Intent(this, Chat_Coach::class.java)
                startActivity(intent)
            }
            R.id.button_chats -> {
                val intent = Intent(this, Chat_Sportsmen::class.java)
                startActivity(intent)
            }

        }
    }
}
