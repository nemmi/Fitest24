package com.example.fitest


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitest.Model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
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
        val PASSWORD__PATTERN = Regex(pattern = "[0-9a-zA-Z]{8,15}")
        val matched = PASSWORD__PATTERN.matches(editPassword.text.toString())

        if (editMail.text.toString().isEmpty()) {
            editMail.error = "Введите email"
            editMail.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(editMail.text.toString()).matches()) {
            editMail.error = "Введите корректный email"
            editMail.requestFocus()
            return
        }
        if (editMail.text.length>30) {
            editMail.error = "email должен содержать не более 30 символов"
            editMail.requestFocus()
            return
        }
        if (editMail.text.length<10) {
            editMail.error = "email должен содержать не менее 10 символов"
            editMail.requestFocus()
            return
        }
        if (editPassword.text.toString().isEmpty()) {
            editMail.error = "Введите пароль"
            editMail.requestFocus()
            return
        }
        if (!matched) {
            editMail.error = "Пароль должен содержать не менее 8 цифр"
            editMail.requestFocus()
            return
        }
        if (editPassword1.text.toString().isEmpty()) {
            editMail.error = "Повторите пароль"
            editMail.requestFocus()
            return
        }

        if (editPassword1.text.toString() != editPassword.text.toString()) {
            editMail.error = "Пароли не совпадают"
            editMail.requestFocus()
            return
        }
        else {
            when (view.id) {
                R.id.buttonReg -> {
                    auth.createUserWithEmailAndPassword(
                        editMail.text.toString(),
                        editPassword.text.toString()
                    )
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                writeNewSportsmen()
                                startActivity(Intent(this, Anketa_Sportsmen_P1::class.java))
                                finish()
                            } else {
                                Toast.makeText(
                                    baseContext, "Регистрация не выполнена",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
                R.id.buttonINTeam -> {
                    auth.createUserWithEmailAndPassword(
                        editMail.text.toString(),
                        editPassword.text.toString()
                    )
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                writeNewTrener()
                                startActivity(Intent(this, Anketa_Coach::class.java))
                                finish()
                            } else {
                                Toast.makeText(
                                    baseContext, "Регистрация не выполнена",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
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
                        baseContext, "Вы зарегистрировались как спортсмен, пожалуйста, заполните анкету",
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
                        baseContext, "Вы зарегистрировались как тренер, пожалуйста, заполните анкету",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}


