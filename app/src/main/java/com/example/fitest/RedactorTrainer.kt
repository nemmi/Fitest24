package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_redactor_trener.*

class RedactorTrainer : AppCompatActivity() {

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
        setContentView(R.layout.activity_redactor_trener)
    }

    private val ddb = FirebaseFirestore.getInstance()

    fun editTrClick(view: View) {
        when (view.id) {
            R.id.deleteProfile -> {
                deleteUser()
            }
            R.id.save -> {
                editProfile()
            }

        }
    }


    private fun editProfile(){
        val user = Firebase.auth.currentUser

        val NAME__PATTERN = Regex(pattern = "[а-яА-Яa-zA-Z ]{4,60}")

        if (mailEdit.text.toString().isNotEmpty()&&!Patterns.EMAIL_ADDRESS.matcher(mailEdit.text.toString()).matches()) {
            mailEdit.error = "Введите корректный email"
            mailEdit.requestFocus()
            return
        }

        if (editSecnameName.text.toString().isNotEmpty()&&!NAME__PATTERN.matches(editSecnameName.text.toString())) {
            editSecnameName.error = "Введите Имя"
            editSecnameName.requestFocus()
            return
        }

        if (phoneEdit.text.toString().isNotEmpty()&&!Patterns.PHONE.matcher(phoneEdit.text.toString()).matches()) {
            phoneEdit.error = "Введите корректный номер"
            phoneEdit.requestFocus()
            return
        }

        else {

            if (mailEdit.text.toString().isNotEmpty()) {
                user!!.updateEmail(mailEdit.text.toString())
                    .addOnCompleteListener { task ->
                        Update("email", mailEdit)
                    }

            }

            if (editSecnameName.text.toString().isNotEmpty()) {
                Update("name",editSecnameName)
            }
            if (phoneEdit.text.toString().isNotEmpty()) {
                Update("phoneNumber", phoneEdit)
            }
            Toast.makeText(
                baseContext, "Профиль успешно обновлен",
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(this, ProfileTrainer::class.java))
        }

    }

    private fun deleteUser(){
        val user = Firebase.auth.currentUser!!
        user.delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        baseContext, "Профиль удален",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
    }

    private fun Update(Auth:String, field:TextView){
     Firebase.auth.currentUser?.uid?.let {
        val up =
            ddb.collection("treners")
                .document(it)
        up.update(

            Auth, field.text.toString()
        )
            .addOnSuccessListener {
            }
      }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}
