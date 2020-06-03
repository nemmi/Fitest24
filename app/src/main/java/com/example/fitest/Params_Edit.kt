package com.example.fitest

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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
        val weight2 = findViewById<EditText>(R.id.editWeight).setInputType( InputType.TYPE_CLASS_NUMBER )
        val shoulders = findViewById<TextView>(R.id.textShoulder)
        val shoulders2 = findViewById<EditText>(R.id.editShoulder).setInputType( InputType.TYPE_CLASS_NUMBER )
        val tall = findViewById<EditText>(R.id.editTall).setInputType( InputType.TYPE_CLASS_NUMBER )
        val breats = findViewById<TextView>(R.id.textBreast)
        val breast2 = findViewById<EditText>(R.id.editBreast).setInputType( InputType.TYPE_CLASS_NUMBER )
        val biceps = findViewById<TextView>(R.id.textBiceps)
        val biceps2 = findViewById<EditText>(R.id.editBiceps).setInputType( InputType.TYPE_CLASS_NUMBER )
        val waist = findViewById<TextView>(R.id.textWaist)
        val waist2 = findViewById<EditText>(R.id.editWaist).setInputType( InputType.TYPE_CLASS_NUMBER )
        val buttocks = findViewById<TextView>(R.id.textButtocks)
        val buttocks2 = findViewById<EditText>(R.id.editButtocks).setInputType( InputType.TYPE_CLASS_NUMBER )
        val hip = findViewById<TextView>(R.id.textHip)
        val hip2 = findViewById<EditText>(R.id.editHip).setInputType( InputType.TYPE_CLASS_NUMBER )

      /*это должен быть фильтр на длину вводимых символов, но у меня не получилось
        fun EditText.limitLength(filter: LengthFilter) {
            this.filters = arrayOf(InputFilter.LengthFilter(4))
        }
        */
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