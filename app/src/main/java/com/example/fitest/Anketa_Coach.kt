package com.example.fitest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_profile_trener_view.*


class Anketa_Coach : AppCompatActivity() {



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
        setContentView(R.layout.activity_coaches_anketa)

      /*  val sec_name = findViewById<EditText>(R.id.editSecondName)
        val name = findViewById<EditText>(R.id.editName)
        val ph_num = findViewById<EditText>(R.id.editPhoneNumber)
        val study = findViewById<EditText>(R.id.editStudy)
        val spec = findViewById<EditText>(R.id.editSpec)
        val win = findViewById<EditText>(R.id.editWins)
        val price = findViewById<EditText>(R.id.editPrice)
        val upload = findViewById<Button>(R.id.button_loadPh)
        val inTeam = findViewById<Button>(R.id.but_IN_Coach)
        val storage = FirebaseStorage.getInstance()
        val TrenersPhotoStorage = storage.getReference().child("photos")*/

    }
    val REQUEST_CODE = 100
        fun AnketaCoachClick(view: View) {
            when (view.id){
                R.id.button_loadPh->{
                    startActivity(Intent(this, ProfileTrenerView::class.java))

                }
                R.id.but_IN_Coach ->{
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