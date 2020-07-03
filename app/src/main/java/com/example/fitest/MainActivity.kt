package com.example.fitest


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitest.SelectTrener.SelectTrener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_auth.editPassword


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


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

        setContentView(R.layout.activity_auth)




        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword("test@mail.test","11111111")


        if (IsInternetAvailable.isInternetAvailable(this)) {
            buttonListTrainer.setOnClickListener {
                val intent = Intent(this, SelectTrener::class.java)
                startActivity(intent)}
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    override fun onBackPressed() {
    }

    fun authClick(view: View) {
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {
                R.id.btnLogin -> {
                    doLogin()
                }

                R.id.signUp -> {
                    startActivity(Intent(this, Registration::class.java))
                }
            }

        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private val ddb = FirebaseFirestore.getInstance()
    private fun doLogin(){


        if (editEmail.text.toString().isEmpty()) {
            editEmail.error = resources.getString(R.string.error_valid_for_empty_field)
            editEmail.requestFocus()
            return
        }

        if (editPassword.text.toString().isEmpty()) {
            editEmail.error = resources.getString(R.string.error_valid_for_empty_field)
            editEmail.requestFocus()
            return
        }

        else {
            auth.signInWithEmailAndPassword(editEmail.text.toString(), editPassword.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        val user = auth.currentUser
                        Toast.makeText(
                            baseContext, resources.getString(R.string.message_success),
                            Toast.LENGTH_SHORT
                        ).show()

                        Firebase.auth.currentUser?.uid?.let {

                            ddb.collection("treners")
                                .document(it)
                                .addSnapshotListener { snapshot, e ->
                                    if (snapshot != null && snapshot.exists()) {

                                        if (snapshot.getString("status") == "trener") {
                                            startActivity(Intent(this, ProfileTrainer::class.java))
                                        }
                                    }
                                    else {

                                        startActivity(Intent(this, ProfileClient::class.java))

                                    }

                                }
                        }
                    }

                    else {
                        Toast.makeText(
                            baseContext, resources.getString(R.string.message_unsuccess_in),
                            Toast.LENGTH_SHORT
                        ).show()
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