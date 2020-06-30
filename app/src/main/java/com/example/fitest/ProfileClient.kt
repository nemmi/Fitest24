package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_profile_client.*
import kotlinx.android.synthetic.main.activity_profile_client.fio


class ProfileClient : AppCompatActivity() {
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
        setContentView(R.layout.activity_profile_client)
        changesAndRead()





    }

    private fun changesAndRead() {



        Firebase.auth.currentUser?.uid?.let {

            ddb.collection("sportsmen")
                .document(it)
                .addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        Toast.makeText(
                            baseContext, "Считать неудалось$e",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@addSnapshotListener
                    }


                    if (snapshot != null && snapshot.exists()) {
                        clientEmailView.text=snapshot.getString("email")
                        fio.text=snapshot.getString("name")
                        clientPhoneView.text=snapshot.getString("phoneNumber")
                        var NameTren = snapshot.getString("myTrener")

                        ddb.collection("treners")
                            .document(NameTren.toString())
                            .addSnapshotListener { snapshot, e ->
                                if (e != null) {
                                    Toast.makeText(
                                        baseContext, "Считать неудалось$e",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@addSnapshotListener
                                }


                                if (snapshot != null && snapshot.exists()) {
                                    clentTrenerView.text = snapshot.getString("name")
                                }
                            }

                    }
                    else {
                        Toast.makeText(
                            baseContext, "Нет данных",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
             }

    }


    private val ddb = FirebaseFirestore.getInstance()

    fun profileSpClick(view: View) {
        when (view.id) {
            R.id.buttonExit -> {
                Firebase.auth.signOut()
                startActivity(Intent(this, MainActivity::class.java))
            }
            R.id.buttonEdit -> {
                startActivity(Intent(this, RedactorClient::class.java))
            }
            R.id.buttonParams -> {
                startActivity(Intent(this, ParamsSportsman::class.java))
            }
            R.id.buttonTrainings -> {
                startActivity(Intent(this, TrainingsSportsman::class.java))
            }
            R.id.buttonEats -> {
                startActivity(Intent(this, Eat::class.java))
            }
            R.id.buttonChat -> {
                startActivity(Intent(this, ChatSportsman::class.java))
            }


        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }


}
