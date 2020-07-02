package com.example.fitest


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*


lateinit var auth: FirebaseAuth
private lateinit var db: FirebaseFirestore

class Registration : AppCompatActivity() {

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
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

    }
    private val ddb = FirebaseFirestore.getInstance()
    fun regClick(view: View) {
        if (IsInternetAvailable.isInternetAvailable(this)) {
            val PASSWORD__PATTERN = Regex(pattern = "[0-9a-zA-Z]{8,15}")
            val matched = PASSWORD__PATTERN.matches(editPassword.text.toString())

            if (editMail.text.toString().isEmpty()) {
                editMail.error = resources.getString(R.string.error_valid_for_empty_field)
                editMail.requestFocus()
                return
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(editMail.text.toString()).matches()) {
                editMail.error = resources.getString(R.string.error_valid_universal)
                editMail.requestFocus()
                return
            }
            if (editMail.text.length < 10 || editMail.text.length > 30) {
                editMail.error =  resources.getString(R.string.error_valid_ten_thirty)
                editMail.requestFocus()
                return
            }

            if (editPassword.text.toString().isEmpty()) {
                editPassword.error =  resources.getString(R.string.error_valid_for_empty_field)
                editPassword.requestFocus()
                return
            }
            if (!matched) {
                editPassword.error =  resources.getString(R.string.error_valid_password)
                editPassword.requestFocus()
                return
            }
            if (editPassword1.text.toString().isEmpty()) {
                editPassword.error =  resources.getString(R.string.error_valid_for_empty_field)
                editPassword.requestFocus()
                return
            }

            if (editPassword1.text.toString() != editPassword.text.toString()) {
                editPassword.error = resources.getString(R.string.error_valid_repassword)
                editPassword.requestFocus()
                return
            } else {
                when (view.id) {
                    R.id.buttonReg -> {
                        auth.createUserWithEmailAndPassword(
                            editMail.text.toString(),
                            editPassword.text.toString()
                        )
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    writeNewSportsmen()
                                    startActivity(Intent(this, FormSportsmanP1::class.java))
                                    finish()
                                } else {
                                    Toast.makeText(
                                        baseContext, resources.getString(R.string.message_unsuccess_reg),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }
                    R.id.buttonInTeam -> {
                        auth.createUserWithEmailAndPassword(
                            editMail.text.toString(),
                            editPassword.text.toString()
                        )
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    writeNewTrener()
                                    startActivity(Intent(this, FormTrainer::class.java))
                                    finish()
                                } else {
                                    Toast.makeText(
                                        baseContext, resources.getString(R.string.message_unsuccess_reg),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }
                }
            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun writeNewSportsmen() {

        val user = hashMapOf(
            "email" to editMail.text.toString()
        )
        Firebase.auth.currentUser?.uid?.let {
            ddb.collection("sportsmen")
                .document(it)
                .set(user as Map<String, Any>)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(
                        baseContext, resources.getString(R.string.message_reg_sp),
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }

    }
    private fun writeNewTrener() {

        val user = hashMapOf(
            "email" to editMail.text.toString()
        )
        Firebase.auth.currentUser?.uid?.let {
            ddb.collection("treners")
                .document(it)
                .set(user as Map<String, Any>)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(
                        baseContext, resources.getString(R.string.message_reg_tren),
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }

    }




    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    fun alert(){
        Toast.makeText(
            baseContext, resources.getString(R.string.error_internet),
            Toast.LENGTH_SHORT
        ).show()
    }
}


