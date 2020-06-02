package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class Anketa_Coach : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coaches_anketa)
        val sec_name = findViewById<EditText>(R.id.editSecondName)
        val name = findViewById<EditText>(R.id.editName)
        val ph_num = findViewById<EditText>(R.id.editPhoneNumber)
        val study = findViewById<EditText>(R.id.editStudy)
        val spec = findViewById<EditText>(R.id.editSpec)
        val win = findViewById<EditText>(R.id.editWins)
        val price = findViewById<EditText>(R.id.editPrice)
        val upload = findViewById<Button>(R.id.button_loadPh)
        val inTeam = findViewById<Button>(R.id.but_IN_Coach)
    }

        fun AnketaCoachClick(view: View) {
            when (view.id){
                R.id.button_loadPh->{
                    Toast.makeText(applicationContext, "Фото успешно загружено!", Toast.LENGTH_SHORT).show()
                }
                R.id.but_IN_Coach ->{
                    val intent = Intent(this, Anketa_Coach::class.java)
                    startActivity(intent)
                }
            }

    }

}