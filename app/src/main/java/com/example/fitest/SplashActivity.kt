package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(FirebaseAuth.getInstance().currentUser== null)
            startActivity(Intent(this,MainActivity::class.java))
        else {

            startActivity(Intent(this, ProfileTrener::class.java))

        }
        finish()
    }
}
