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
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_coaches_anketa.*
import kotlinx.android.synthetic.main.activity_coaches_anketa.editPhoneNumber
import kotlinx.android.synthetic.main.activity_coaches_anketa.editSecondName



class FormTrainer : AppCompatActivity() {

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
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_coaches_anketa)
    }

    override fun onBackPressed() {
    }

    private val ddb = FirebaseFirestore.getInstance()
    /*  val REQUEST_CODE = 100*/

    fun AnketaCoachClick(view: View) {
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {
                R.id.buttonLoadPhoto -> {

                    startActivity(Intent(this, ProfileTrenerView::class.java))

                }
                R.id.butInCoach -> {

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

        val STUDY__PATTERN = Regex(pattern = resources.getString(R.string.pattern_study))
        val FIELD__PATTERN = Regex(pattern = resources.getString(R.string.pattern_long_field))
        val PRICE__PATTERN = Regex(pattern = resources.getString(R.string.pattern_price))
        val PHONE__PATTERN = Regex(pattern = resources.getString(R.string.pattern_phone))


        if (!matched) {
            editSecondName.error =  resources.getString(R.string.error_valid_name)
            editSecondName.requestFocus()
            return
        }
        if (!PHONE__PATTERN.matches(editPhoneNumber.text.toString())) {
            editPhoneNumber.error = resources.getString(R.string.error_valid_universal)
            editPhoneNumber.requestFocus()
            return
        }
        if (!STUDY__PATTERN.matches(editStudy.text.toString())) {
            editStudy.error = resources.getString(R.string.error_valid_8_50)
            editStudy.requestFocus()
            return
        }
        if (!FIELD__PATTERN.matches(editSpec.text.toString())) {
            editSpec.error =resources.getString(R.string.error_valid_5_250)
            editSpec.requestFocus()
            return
        }
        if (!FIELD__PATTERN.matches(editWins.text.toString())) {
            editWins.error = resources.getString(R.string.error_valid_5_250)
            editWins.requestFocus()
            return
        }
        if (!PRICE__PATTERN.matches(editPrice.text.toString())) {
            editPrice.error = resources.getString(R.string.error_valid_three_five)
            editPrice.requestFocus()
            return
        }

        if (editSecondName.text.toString().isEmpty()) {
            editSecondName.error = resources.getString(R.string.error_valid_for_empty_field)
            editSecondName.requestFocus()
            return
        }
        if (editStudy.text.toString().isEmpty()) {
            editStudy.error =resources.getString(R.string.error_valid_for_empty_field)
            editStudy.requestFocus()
            return
        }
        if (editPhoneNumber.text.toString().isEmpty()) {
            editPhoneNumber.error = resources.getString(R.string.error_valid_for_empty_field)
            editPhoneNumber.requestFocus()
            return
        }
        if (editSpec.text.toString().isEmpty()) {
            editSpec.error = resources.getString(R.string.error_valid_for_empty_field)
            editSpec.requestFocus()
            return
        }
        if (editWins.text.toString().isEmpty()) {
            editWins.error = resources.getString(R.string.error_valid_for_empty_field)
            editWins.requestFocus()
            return
        }
        if (editPrice.text.toString().isEmpty()) {
            editPrice.error = resources.getString(R.string.error_valid_for_empty_field)
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
                            baseContext, resources.getString(R.string.message_success),
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(this, ProfileTrainer::class.java))
                        finish()
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