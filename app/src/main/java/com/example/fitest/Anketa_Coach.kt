package com.example.fitest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_coaches_anketa.*
import kotlinx.android.synthetic.main.activity_coaches_anketa.editPhoneNumber
import kotlinx.android.synthetic.main.activity_coaches_anketa.editSecondName



class Anketa_Coach : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth

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
    }


    private val ddb = FirebaseFirestore.getInstance()
    /*  val REQUEST_CODE = 100*/

    fun AnketaCoachClick(view: View) {
        when (view.id){
            R.id.button_loadPh->{
                startActivity(Intent(this, ProfileTrenerView::class.java))
            }
            R.id.but_IN_Coach ->{
                upProfile()
            }
        }

    }

    private fun upProfile() {
        val NAME__PATTERN = Regex(pattern = "[а-яА-Яa-zA-Z ]{4,60}")
        val matched = NAME__PATTERN.matches(editSecondName.text.toString())

        val STUDY__PATTERN = Regex(pattern = "[(0-9)(a-z)(A-Z)(а-я)(А-Я) -.,]{8,50}")
        val FIELD__PATTERN = Regex(pattern = "[(0-9)(a-z)(A-Z)(а-я)(А-Я) -.,]{5,250}")
        val PRICE__PATTERN = Regex(pattern = "[0-9]{3,5}")


        if (!matched) {
            editSecondName.error = "Имя должно состоять только из символов русского или английского алфавита. Введите не менее 4 и не более 60 символов"
            editSecondName.requestFocus()
            return
        }
        if (!Patterns.PHONE.matcher(editPhoneNumber.text.toString()).matches()) {
            editPhoneNumber.error = "Введите корректный номер"
            editPhoneNumber.requestFocus()
            return
        }
        if (!STUDY__PATTERN.matches(editStudy.text.toString())) {
            editStudy.error = "Введите не менее 5 и не более 50 символов"
            editStudy.requestFocus()
            return
        }
        if (!FIELD__PATTERN.matches(editSpec.text.toString())) {
            editSpec.error ="Введите не менее 5 и не более 250 символов"
            editSpec.requestFocus()
            return
        }
        if (!FIELD__PATTERN.matches(editWins.text.toString())) {
            editWins.error = "Введите не менее 5 и не более 250 символов"
            editWins.requestFocus()
            return
        }
        if (!PRICE__PATTERN.matches(editPrice.text.toString())) {
            editPrice.error = "Введите не менее 3 и не более 5 символов"
            editPrice.requestFocus()
            return
        }

        if (editSecondName.text.toString().isEmpty()) {
            editSecondName.error = "Введите имя"
            editSecondName.requestFocus()
            return
        }
        if (editStudy.text.toString().isEmpty()) {
            editStudy.error = "Введите данные"
            editStudy.requestFocus()
            return
        }
        if (editPhoneNumber.text.toString().isEmpty()) {
            editPhoneNumber.error = "Введите данные"
            editPhoneNumber.requestFocus()
            return
        }
        if (editSpec.text.toString().isEmpty()) {
            editSpec.error = "Введите данные"
            editSpec.requestFocus()
            return
        }
        if (editWins.text.toString().isEmpty()) {
            editWins.error = "Введите данные"
            editWins.requestFocus()
            return
        }
        if (editPrice.text.toString().isEmpty()) {
            editPrice.error = "Введите данные"
            editPrice.requestFocus()
            return
        }

        else {

            val user = hashMapOf(

                "status" to "trener",
                "name" to editSecondName.text.toString(),
                "phoneNumber" to editPhoneNumber.text.toString(),
                "study" to editStudy.text.toString(),
                "spec" to editSpec.text.toString(),
                "win" to editWins.text.toString(),
                "price" to editPrice.text.toString()
            )

            Firebase.auth.currentUser?.uid?.let {
                ddb.collection("treners")
                    .document(it)
                    .set(user as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(
                            baseContext, "Профиль заполнен",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(this, ProfileTrener::class.java))
                        finish()
                    }
            }
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}