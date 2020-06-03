package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView



class Params_Edit : AppCompatActivity() {

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
        setContentView(R.layout.activity_body_params_edit)
        val name = findViewById<TextView>(R.id.urName)
        val weight = findViewById<TextView>(R.id.textWeight)
        val weight2 = findViewById<EditText>(R.id.editWeight)
        val shoulders = findViewById<TextView>(R.id.textShoulder)
        val shoulders2 = findViewById<EditText>(R.id.editShoulder)
        val tall = findViewById<EditText>(R.id.editTall)
        val breats = findViewById<TextView>(R.id.textBreast)
        val breast2 = findViewById<EditText>(R.id.editBreast)
        val biceps = findViewById<TextView>(R.id.textBiceps)
        val biceps2 = findViewById<EditText>(R.id.editBiceps)
        val waist = findViewById<TextView>(R.id.textWaist)
        val waist2 = findViewById<EditText>(R.id.editWaist)
        val buttocks = findViewById<TextView>(R.id.textButtocks)
        val buttocks2 = findViewById<EditText>(R.id.editButtocks)
        val hip = findViewById<TextView>(R.id.textHip)
        val hip2 = findViewById<EditText>(R.id.editHip)
    }

    fun paramEditClick(view: View) {
        when (view.id) {
            R.id.toolbarProf2 -> {
                val intent = Intent(this, Params_Sportsmen::class.java)
                startActivity(intent)
            }
            R.id.button_save -> {
                val intent = Intent(this, Params_Sportsmen::class.java)
                startActivity(intent)
            }

        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}