package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov


class Params_Coach : AppCompatActivity() {

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
        setContentView(R.layout.activity_body_params_coach_otchet)
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
    fun paramsCoachClick(view: View) {
        when (view.id) {
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
            R.id.profile -> {
                val intent = Intent(this, ProfileTrener::class.java)
                startActivity(intent)
            }

        }
        }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}