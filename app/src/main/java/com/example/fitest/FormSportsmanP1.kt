package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.ktx.auth

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase

import kotlinx.android.synthetic.main.activity_sportsmen_anketa1.*
import kotlinx.android.synthetic.main.activity_sportsmen_anketa1.editPhoneNumber
import kotlinx.android.synthetic.main.activity_sportsmen_anketa1.editSecondName

class FormSportsmanP1  : AppCompatActivity() {

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
        setContentView(R.layout.activity_sportsmen_anketa1)

    }
    private val ddb = FirebaseFirestore.getInstance()
    fun anketaSp1Click(view: View) {
        when (view.id) {
            R.id.toolbarAnketaView -> {
                val intent = Intent(this, Registration::class.java)
                startActivity(intent)
            }
            R.id.buttonChoose -> {
                upProfile()

            }

        }
    }

    private fun upProfile() {

        val NAME__PATTERN = Regex(pattern = "[а-яА-Яa-zA-Z ]{4,60}")
        val matched = NAME__PATTERN.matches(editSecondName.text.toString())

        val EXP__PATTERN = Regex(pattern = "[(0-9)(a-z)(A-Z)(а-я)(А-Я) -.,]{3,50}")
        val FIELD__PATTERN = Regex(pattern = "[(0-9)(a-z)(A-Z)(а-я)(А-Я) -.,]{3,30}")
        val AGE__PATTERN = Regex(pattern = "[0-9]{2,3}")
        val PARAMS__PATTERN = Regex(pattern = "[0-9.,]{2,4}")
        val HEIGHT__PATTERN = Regex(pattern = "[0-9.,]{3,4}")

        if (!PARAMS__PATTERN.matches(editAnketaWeight.text.toString())) {
            editAnketaWeight.error = "Введите не менее 2 и не более 4 символов"
            editAnketaWeight.requestFocus()
            return
        }
        if (!HEIGHT__PATTERN.matches(editHeightAnketa.text.toString())) {
            editHeightAnketa.error = "Введите не менее 3 и не более 4 символов"
            editHeightAnketa.requestFocus()
            return
        }
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
        if (!EXP__PATTERN.matches(editExpTr.text.toString())) {
            editExpTr.error = "Введите не менее 3 и не более 50 символов"
            editExpTr.requestFocus()
            return
        }
        if (!EXP__PATTERN.matches(editGoals.text.toString())) {
            editGoals.error = "Введите не менее 3 и не более 50 символов"
            editGoals.requestFocus()
            return
        }
        if (!EXP__PATTERN.matches(editDontEat.text.toString())) {
            editDontEat.error = "Введите не менее 3 и не более 50 символов"
            editDontEat.requestFocus()
            return
        }
        if (!FIELD__PATTERN.matches(editBads.text.toString())) {
            editBads.error = "Введите не менее 3 и не более 30 символов"
            editBads.requestFocus()
            return
        }
        if (!FIELD__PATTERN.matches(editBlood.text.toString())) {
            editBlood.error = "Введите не менее 3 и не более 30 символов"
            editBlood.requestFocus()
            return
        }
        if (!AGE__PATTERN .matches(editAge.text.toString())) {
            editAge.error = "Введите корректные данные"
            editAge.requestFocus()
            return
        }

        if (editSecondName.text.toString().isEmpty()) {
            editSecondName.error = "Введите имя и фамилию"
            editSecondName.requestFocus()
            return
        }
        if (editAge.text.toString().isEmpty()) {
            editAge.error = "Введите данные"
            editAge.requestFocus()
            return
        }
        if (editPhoneNumber.text.toString().isEmpty()) {
            editPhoneNumber.error = "Введите данные"
            editPhoneNumber.requestFocus()
            return
        }
        if (editExpTr.text.toString().isEmpty()) {
            editExpTr.error = "Введите данные"
            editExpTr.requestFocus()
            return
        }
        if (editGoals.text.toString().isEmpty()) {
            editGoals.error = "Введите данные"
            editGoals.requestFocus()
            return
        }
        if (editDontEat.text.toString().isEmpty()) {
            editDontEat.error = "Введите данные"
            editDontEat.requestFocus()
            return
        }
        if (editAnketaWeight.text.toString().isEmpty()) {
            editAnketaWeight.error = "Введите данные"
            editAnketaWeight.requestFocus()
            return
        }
        if (editHeightAnketa.text.toString().isEmpty()) {
            editHeightAnketa.error = "Введите данные"
            editHeightAnketa.requestFocus()
            return
        }
        if (editBads.text.toString().isEmpty()) {
            editBads.error = "Введите данные"
            editBads.requestFocus()
            return
        }
        if (editBlood.text.toString().isEmpty()) {
            editBlood.error = "Введите данные"
            editBlood.requestFocus()
            return
        }


        else {

            val user = hashMapOf(

                "status" to "sportsmen",
                "name" to editSecondName.text.toString(),
                "phoneNumber" to editPhoneNumber.text.toString(),
                "age" to editAge.text.toString(),
                "experience" to editExpTr.text.toString(),
                "goals" to editGoals.text.toString(),
                "hatingEat" to editDontEat.text.toString(),
                "weight" to editAnketaWeight.text.toString(),
                "height" to editHeightAnketa.text.toString(),
                "bads" to editBads.text.toString(),
                "bloods" to editBlood.text.toString()
            )

            Firebase.auth.currentUser?.uid?.let {
                ddb.collection("sportsmen")
                    .document(it)
                    .set(user as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(
                            baseContext, "Отлично, осталось только выбрать продукты!",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(this, FormSportsmanP2::class.java))
                    }
            }
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}
