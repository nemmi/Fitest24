package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ddb = FirebaseFirestore.getInstance()
        if (FirebaseAuth.getInstance().currentUser == null)
            startActivity(Intent(this, MainActivity::class.java))
        else {

            Firebase.auth.currentUser?.uid?.let {

                ddb.collection("treners")
                    .document(it)
                    .addSnapshotListener { snapshot, e ->

                        if (snapshot != null && snapshot.exists()) {

                            if (snapshot.getString("status") == "trener") {
                                startActivity(Intent(this, ProfileTrainer::class.java))
                            }
                        } else {
                            startActivity(Intent(this, ProfileClient::class.java))
                        }


                    }
            }
        }
    }
}
