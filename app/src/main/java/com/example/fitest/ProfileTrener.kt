package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_profile_trener.*
import kotlinx.android.synthetic.main.activity_redactor_trener.*

class ProfileTrener : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

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
        setContentView(R.layout.activity_profile_trener)
        changesAndRead()
    }
    val uid= FirebaseAuth.getInstance().currentUser?.uid

    private val ddb = FirebaseFirestore.getInstance()


    private fun changesAndRead(){

        Firebase.auth.currentUser?.uid?.let {

            ddb.collection("treners")
                .document(it)
                .addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        Toast.makeText(
                            baseContext, "Считать неудалось$e",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@addSnapshotListener
                    }


                    if (snapshot != null && snapshot.exists()) {
                        textMail.text=snapshot.getString("email")
                        FI.text=snapshot.getString("name")
                        textPhone.text=snapshot.getString("phoneNumber")
                    }
                    else {
                        Toast.makeText(
                            baseContext, "Нет данных",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
        }

    }

    fun profileTrClick(view: View) {
        when (view.id) {
            R.id.imageButton -> {
                Firebase.auth.signOut()
                startActivity(Intent(this, MainActivity::class.java))
            }
            R.id.imageButton2 -> {
                startActivity(Intent(this, RedactorTrener::class.java))
            }
            R.id.imageButton28 -> {
                startActivity(Intent(this, ListClient::class.java))
            }
            R.id.imageButton33 -> {
                startActivity(Intent(this, SpisocChatov::class.java))
            }

        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()


    }



}


