package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_profile_trener.*

class ProfileTrainer : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

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
        setContentView(R.layout.activity_profile_trener)
        if (IsInternetAvailable.isInternetAvailable(this)) {
            changesAndRead()
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    val uid= FirebaseAuth.getInstance().currentUser?.uid

    private val ddb = FirebaseFirestore.getInstance()


    private fun changesAndRead(){

        Firebase.auth.currentUser?.uid?.let {

            ddb.collection("treners")
                .document(it)
                .addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        Toast.makeText(
                            baseContext, resources.getString(R.string.error_base),
                            Toast.LENGTH_SHORT
                        ).show()
                        return@addSnapshotListener
                    }


                    if (snapshot != null && snapshot.exists()) {
                        textMail.text=snapshot.getString("email")
                        fio.text=snapshot.getString("name")
                        textPhone.text=snapshot.getString("phoneNumber")
                    }
                    else {
                        Toast.makeText(
                            baseContext, resources.getString(R.string.error_empty_base),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
        }

    }

    fun profileTrClick(view: View) {
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {
                R.id.btnExit -> {
                    Firebase.auth.signOut()
                    startActivity(Intent(this, MainActivity::class.java))
                }
                R.id.btnRedactorTrainerProfile -> {
                    startActivity(Intent(this, RedactorTrainer::class.java))
                }
                R.id.listClients -> {
                    startActivity(Intent(this, ListClient::class.java))
                }
                R.id.chat -> {
                    startActivity(Intent(this, SpisocChatov::class.java))
                }

            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
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


