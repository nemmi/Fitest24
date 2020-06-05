package com.example.fitest

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_body_params_edit.*


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
       editWeight.limitLength()
        editShoulder.limitLength()
      editTall.limitLength()
        editBreast.limitLength()
      editBiceps.limitLength()
       editWaist.limitLength()
       editButtocks.limitLength()
        editHip.limitLength()
    }


private fun EditText.limitLength() {
    this.filters = arrayOf(InputFilter.LengthFilter(4))
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


