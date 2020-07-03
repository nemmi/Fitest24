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

    override fun onBackPressed() {
    }

    private val ddb = FirebaseFirestore.getInstance()

    fun editTrClick(view: View) {
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {
                R.id.deleteProfile -> {
                    deleteUser()
                }
                R.id.save -> {
                    editProfile()
                }

            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


    private fun editProfile(){
        val user = Firebase.auth.currentUser

        val NAME__PATTERN = Regex(pattern = resources.getString(R.string.pattern_name))
        val PHONE_PATTERN = Regex(pattern= resources.getString(R.string.pattern_phone))

        if (mailEdit.text.toString().isNotEmpty()&&!Patterns.EMAIL_ADDRESS.matcher(mailEdit.text.toString()).matches()) {
            mailEdit.error = resources.getString(R.string.error_valid_universal)
            mailEdit.requestFocus()
            return
        }

        if (editSecnameName.text.toString().isNotEmpty()&&!NAME__PATTERN.matches(editSecnameName.text.toString())) {
            editSecnameName.error = resources.getString(R.string.error_valid_for_empty_field)
            editSecnameName.requestFocus()
            return
        }

        if (phoneEdit.text.toString().isNotEmpty()&&!PHONE_PATTERN.matches(phoneEdit.text.toString())) {
            phoneEdit.error = resources.getString(R.string.error_valid_universal)
            phoneEdit.requestFocus()
            return
        }

        else {

            if (mailEdit.text.toString().isNotEmpty()) {
                user!!.updateEmail(mailEdit.text.toString())
                    .addOnCompleteListener { task ->
                        update("email", mailEdit)
                    }

            }

            if (editSecnameName.text.toString().isNotEmpty()) {
                update("name",editSecnameName)
            }
            if (phoneEdit.text.toString().isNotEmpty()) {
                update("phoneNumber", phoneEdit)
            }
            Toast.makeText(
                baseContext, resources.getString(R.string.message_success),
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(this, ProfileTrainer::class.java))
        }

    }

    private fun deleteUser(){

        val user = Firebase.auth.currentUser?.uid



        Firebase.auth.currentUser!!.delete()
        FirebaseFirestore.getInstance().collection("treners").document(user.toString())
            .delete().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(
                        baseContext, resources.getString(R.string.message_deleted),
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        /*Firebase.auth.currentUser!!.delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("treners")
                            .document(it)
                            .delete()
                            .addOnSuccessListener { task ->
                                Toast.makeText(
                                    baseContext, resources.getString(R.string.message_deleted),
                                    Toast.LENGTH_SHORT
                                ).show()
                                startActivity(Intent(this, MainActivity::class.java))
                            }
                    }
                }
            }*/
    }


    private fun update(auth:String, field:TextView){
        Firebase.auth.currentUser?.uid?.let {
            val up =
                ddb.collection("treners")
                    .document(it)
            up.update(

                auth, field.text.toString()
            )
                .addOnSuccessListener {
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

