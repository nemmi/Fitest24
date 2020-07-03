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
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sportsmen_anketa1)

    }

    override fun onBackPressed() {
    }
    private val ddb = FirebaseFirestore.getInstance()
    fun anketaSp1Click(view: View) {
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {
               /* R.id.toolbarAnketaView -> {

                    val intent = Intent(this, Registration::class.java)
                    startActivity(intent)

                }*/
                R.id.buttonChoose -> {
                    upProfile()

                }

            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun upProfile() {

        val NAME__PATTERN = Regex(pattern = resources.getString(R.string.pattern_name))
        val matched = NAME__PATTERN.matches(editSecondName.text.toString())

        val EXP__PATTERN = Regex(pattern = resources.getString(R.string.pattern_exp))
        val FIELD__PATTERN = Regex(pattern = resources.getString(R.string.pattern_field))
        val AGE__PATTERN = Regex(pattern = resources.getString(R.string.pattern_age))
        val PARAMS__PATTERN = Regex(pattern = resources.getString(R.string.pattern_params))
        val HEIGHT__PATTERN = Regex(pattern = resources.getString(R.string.pattern_height))
        val PHONE__PATTERN = Regex(pattern = resources.getString(R.string.pattern_phone))

        if (!PARAMS__PATTERN.matches(editAnketaWeight.text.toString())) {
            editAnketaWeight.error = resources.getString(R.string.error_weight_form)
            editAnketaWeight.requestFocus()
            return
        }
        if (!HEIGHT__PATTERN.matches(editHeightAnketa.text.toString())) {
            editHeightAnketa.error =resources.getString(R.string.error_weight_form)
            editHeightAnketa.requestFocus()
            return
        }
        if (!matched) {
            editSecondName.error =resources.getString(R.string.error_valid_name)
            editSecondName.requestFocus()
            return
        }
        if (!PHONE__PATTERN.matches(editPhoneNumber.text.toString())) {
            editPhoneNumber.error = resources.getString(R.string.error_valid_universal)
            editPhoneNumber.requestFocus()
            return
        }
        if (!EXP__PATTERN.matches(editExpTr.text.toString())) {
            editExpTr.error = resources.getString(R.string.error_valid_three_fifty)
            editExpTr.requestFocus()
            return
        }
        if (!EXP__PATTERN.matches(editGoals.text.toString())) {
            editGoals.error = resources.getString(R.string.error_valid_three_fifty)
            editGoals.requestFocus()
            return
        }
        if (!EXP__PATTERN.matches(editDontEat.text.toString())) {
            editDontEat.error = resources.getString(R.string.error_valid_three_fifty)
            editDontEat.requestFocus()
            return
        }
        if (!FIELD__PATTERN.matches(editBads.text.toString())) {
            editBads.error = resources.getString(R.string.error_valid_three_thirty)
            editBads.requestFocus()
            return
        }
        if (!FIELD__PATTERN.matches(editBlood.text.toString())) {
            editBlood.error = resources.getString(R.string.error_valid_three_fifty)
            editBlood.requestFocus()
            return
        }
        if (!AGE__PATTERN .matches(editAge.text.toString())) {
            editAge.error = resources.getString(R.string.error_valid_universal)
            editAge.requestFocus()
            return
        }

        if (editSecondName.text.toString().isEmpty()) {
            editSecondName.error = resources.getString(R.string.error_valid_for_empty_field)
            editSecondName.requestFocus()
            return
        }
        if (editAge.text.toString().isEmpty()) {
            editAge.error =  resources.getString(R.string.error_valid_for_empty_field)
            editAge.requestFocus()
            return
        }
        if (editPhoneNumber.text.toString().isEmpty()) {
            editPhoneNumber.error = resources.getString(R.string.error_valid_for_empty_field)
            editPhoneNumber.requestFocus()
            return
        }
        if (editExpTr.text.toString().isEmpty()) {
            editExpTr.error = resources.getString(R.string.error_valid_for_empty_field)
            editExpTr.requestFocus()
            return
        }
        if (editGoals.text.toString().isEmpty()) {
            editGoals.error = resources.getString(R.string.error_valid_for_empty_field)
            editGoals.requestFocus()
            return
        }
        if (editDontEat.text.toString().isEmpty()) {
            editDontEat.error = resources.getString(R.string.error_valid_for_empty_field)
            editDontEat.requestFocus()
            return
        }
        if (editAnketaWeight.text.toString().isEmpty()) {
            editAnketaWeight.error = resources.getString(R.string.error_valid_for_empty_field)
            editAnketaWeight.requestFocus()
            return
        }
        if (editHeightAnketa.text.toString().isEmpty()) {
            editHeightAnketa.error = resources.getString(R.string.error_valid_for_empty_field)
            editHeightAnketa.requestFocus()
            return
        }
        if (editBads.text.toString().isEmpty()) {
            editBads.error = resources.getString(R.string.error_valid_for_empty_field)
            editBads.requestFocus()
            return
        }
        if (editBlood.text.toString().isEmpty()) {
            editBlood.error = resources.getString(R.string.error_valid_for_empty_field)
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
                "bloods" to editBlood.text.toString(),
                "num" to "3"
            )

            Firebase.auth.currentUser?.uid?.let {
                ddb.collection("sportsmen")
                    .document(it)
                    .set(user as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(
                            baseContext,  resources.getString(R.string.message_next),
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

    fun alert(){
        Toast.makeText(
            baseContext, resources.getString(R.string.error_internet),
            Toast.LENGTH_SHORT
        ).show()
    }
}
