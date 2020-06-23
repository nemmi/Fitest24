package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_profile_trener.*
import kotlinx.android.synthetic.main.activity_redactor_client.*


import kotlinx.android.synthetic.main.activity_redactor_trener.*
import kotlinx.android.synthetic.main.activity_redactor_trener.editFI
import kotlinx.android.synthetic.main.activity_redactor_trener.mailEdit
import kotlinx.android.synthetic.main.activity_redactor_trener.phoneEdit
import kotlinx.android.synthetic.main.activity_sportsmen_anketa1.*

class RedactorTrener : AppCompatActivity() {

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
        setContentView(R.layout.activity_redactor_trener)

        /* loadData()*/
        /* val uid= FirebaseAuth.getInstance().currentUser?.uid
         val db = uid?.let { FirebaseDatabase.getInstance().reference.child("users").child("treners").child(it) }
 */
    }

    private val ddb = FirebaseFirestore.getInstance()

    fun editTrClick(view: View) {
        when (view.id) {
            R.id.deleteprofile -> {
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

        if (editFI.text.toString().isNotEmpty()&&!NAME__PATTERN.matches(editFI.text.toString())) {
            editFI.error = "Введите Имя"
            editFI.requestFocus()
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
                        Firebase.auth.currentUser?.uid?.let {
                            val up =
                                ddb.collection("treners")
                                    .document(it)
                            up.update(
                                "email", mailEdit.text.toString()
                            )
                                .addOnSuccessListener {
                                }
                        }
                    }

            }

            if (editFI.text.toString().isNotEmpty()) {

                Firebase.auth.currentUser?.uid?.let {
                    val up =
                        ddb.collection("treners")
                            .document(it)
                    up.update(
                        "name", editFI.text.toString()
                    )
                        .addOnSuccessListener {
                        }
                }


            }
            if (phoneEdit.text.toString().isNotEmpty()) {
                Firebase.auth.currentUser?.uid?.let {
                    val up =
                        ddb.collection("treners")
                            .document(it)
                    up.update(

                        "phoneNumber", phoneEdit.text.toString()
                    )
                        .addOnSuccessListener {
                        }
                }
            }
            Toast.makeText(
                baseContext, "Профиль успешно обновлен",
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(this, ProfileTrener::class.java))
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


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}

