package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        /*ddb.collection("sportsmen")
            .document(it)  //айди спортсмена должно передаваться из списка клиентов
            .addSnapshotListener { snapshot, e ->
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

            }*/

    }
    private val ddb = FirebaseFirestore.getInstance()

    fun profileSpViewClick(view: View) {
        when (view.id) {
            R.id.imageButton13 -> {
                startActivity(Intent(this, MainActivity::class.java)) //анкета должна быть тут
            }
            R.id.imageButton12 -> {
                startActivity(Intent(this, Chat_Coach::class.java))
            }
            R.id.programtreni -> {
                startActivity(Intent(this, Load_Trainings::class.java))
            }
            R.id.programpitaniye -> {
                startActivity(Intent(this, Load_Eat::class.java))
            }
            R.id.otchettreni -> {
                startActivity(Intent(this, Trainings_Coach::class.java))
            }
            R.id.otchetpitanie -> {
                startActivity(Intent(this, OtchetPitanie::class.java))
            }
            R.id.otchetparamer -> {
                startActivity(Intent(this, Params_Coach::class.java))
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
