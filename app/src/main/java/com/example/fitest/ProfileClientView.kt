package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_profile_client_view.*

class ProfileClientView : AppCompatActivity() {

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
        setContentView(R.layout.activity_profile_client_view)





        read()
    }
    private fun read() {

        var value = intent.getStringExtra("id")
        Log.i("NewActivity", value)

        ddb.collection("sportsmen").document(value).addSnapshotListener{
                snapshot, e ->
            if (e != null) {
                Toast.makeText(
                    baseContext, "Считать неудалось$e",
                    Toast.LENGTH_SHORT
                ).show()
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {
                textView5.text=snapshot.getString("email")
                textView4.text=snapshot.getString("name")
                textView6.text=snapshot.getString("phoneNumber")
            }
            else {
                Toast.makeText(
                    baseContext, "Нет данных",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }



    }



    private val ddb = FirebaseFirestore.getInstance()

    fun profileSpViewClick(view: View) {
        var value = intent.getStringExtra("id")
        Log.i("NewActivity", value)

        when (view.id) {
            R.id.imageButton13 -> {
                val intent = Intent(this, AnketaView::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
            R.id.imageButton12 -> {
                val intent = Intent(this, Chat_Coach::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
            R.id.programtreni -> {
                val intent = Intent(this, Load_Trainings::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
            R.id.programpitaniye -> {
                val intent = Intent(this, Load_Eat::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
            R.id.otchettreni -> {
                val intent = Intent(this, Trainings_Coach::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
            R.id.otchetpitanie -> {
                val intent = Intent(this, OtchetPitanie::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
            R.id.otchetparamer -> {
                val intent = Intent(this, Params_Coach::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
            R.id.imageButton28 -> {
                startActivity(Intent(this, ListClient::class.java))
            }
            R.id.imageView56 -> {
                startActivity(Intent(this, ProfileTrener::class.java))
            }
            R.id.imageButton33 -> {
                startActivity(Intent(this, SpisocChatov::class.java))
            }

        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}