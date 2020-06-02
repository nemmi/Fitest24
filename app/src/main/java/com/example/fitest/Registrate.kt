package com.example.fitest


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


private lateinit var auth: FirebaseAuth

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
        setContentView(R.layout.activity_main)
        val but: Button = findViewById(R.id.buttonReg)
        val butText = findViewById<Button>(R.id.buttonINTeam)
        val email = findViewById<EditText>(R.id.editMail)
        val passw = findViewById<EditText>(R.id.editPassword)
        val passw1 = findViewById<EditText>(R.id.editPassword1)

        auth = FirebaseAuth.getInstance()
    }

    val PASSWORD__PATTERN = Regex(pattern = "[0-9]{8,15}")

    fun regClick(view: View) {
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
        else {when (view.id) {
            R.id.buttonReg -> {
                auth.createUserWithEmailAndPassword(
                    editMail.text.toString(),
                    editPassword.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, Anketa_Sportsmen_P1::class.java)
                            startActivity(intent)
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
                            val intent = Intent(this, Anketa_Coach::class.java)
                            startActivity(intent)
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
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}


