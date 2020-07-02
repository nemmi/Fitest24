package com.example.fitest

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_profile_client.*


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
                            baseContext, resources.getString(R.string.error_base),
                            Toast.LENGTH_SHORT
                        ).show()
                        return@addSnapshotListener
                    }
                    if (snapshot != null && snapshot.exists()) {
                        clientEmailView.text=snapshot.getString("email")
                        fio.text=snapshot.getString("name")
                        clientPhoneView.text=snapshot.getString("phoneNumber")
                        textNumOfTren.text=snapshot.getString("num")
                        var nameTren = snapshot.getString("myTrener")

                        ddb.collection("treners")
                            .document(nameTren.toString())
                            .addSnapshotListener { snapshot, e ->
                                if (e != null) {
                                    Toast.makeText(
                                        baseContext, resources.getString(R.string.error_base),
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
                            baseContext, resources.getString(R.string.error_empty_base),
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
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    startActivity(Intent(this, RedactorClient::class.java))
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))

                }
            }
            R.id.buttonParams -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    startActivity(Intent(this, ParamsSportsman::class.java))
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))

                }
            }
            R.id.buttonTrainings -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    startActivity(Intent(this, TrainingsSportsman::class.java))
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))

                }
            }
            R.id.buttonEats -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    startActivity(Intent(this, Eat::class.java))
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))

                }
            }
            R.id.buttonChat -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    startActivity(Intent(this, ChatSportsman::class.java))
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))

                }
            }


        }
    }

    fun alert(){
        Toast.makeText(
            baseContext, resources.getString(R.string.error_internet),
            Toast.LENGTH_SHORT
        ).show()
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }


}
