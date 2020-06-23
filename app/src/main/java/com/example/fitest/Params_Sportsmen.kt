package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View

import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_body_params.*
import kotlinx.android.synthetic.main.activity_body_params.textBiceps
import kotlinx.android.synthetic.main.activity_body_params.textBreast
import kotlinx.android.synthetic.main.activity_body_params.textButtocks
import kotlinx.android.synthetic.main.activity_body_params.textHip
import kotlinx.android.synthetic.main.activity_body_params.textShoulder
import kotlinx.android.synthetic.main.activity_body_params.textWaist
import kotlinx.android.synthetic.main.activity_body_params.textWeight


class Params_Sportsmen : AppCompatActivity() {

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
        setContentView(R.layout.activity_body_params)
        loadData()

    }
    private val ddb = FirebaseFirestore.getInstance()

    private fun loadData() {
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
                        urName.text = snapshot.getString("name")

                        textWeight.text = snapshot.getString("weight")
                        textShoulder.text = snapshot.getString("shoulder")
                        textBreast.text = snapshot.getString("breast")
                        textBiceps.text = snapshot.getString("biceps")
                        textWaist.text = snapshot.getString("waist")
                        textButtocks.text = snapshot.getString("buttock")
                        textHip.text = snapshot.getString("hip")

                        textTall.text = snapshot.getString("height")

                        textWeight2.text = snapshot.getString("weight2")
                        textShoulder2.text = snapshot.getString("shoulder2")
                        textBreast2.text = snapshot.getString("breast2")
                        textBiceps2.text = snapshot.getString("biceps2")
                        textWaist2.text = snapshot.getString("waist2")
                        textButtocks2.text = snapshot.getString("buttock2")
                        textHip2.text = snapshot.getString("hip2")
                    } else {
                        Toast.makeText(
                            baseContext, "Нет данных",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
        }
    }

    fun paramSportClick(view: View) {
        when (view.id) {
            R.id.toolbar -> {
                startActivity(Intent(this, ProfileClient::class.java))
            }
            R.id.button_edit -> {
                param()
                startActivity(Intent(this, Params_Edit::class.java))
            }
            R.id.button_trainings -> {
                startActivity(Intent(this, Trainings_Sportsmen::class.java))
            }
            R.id.button_eats -> {
                startActivity(Intent(this, Pitanie::class.java))
            }
            R.id.button_chats -> {
                startActivity(Intent(this, Chat_Sportsmen::class.java))
            }

        }
    }

    private fun param(){

        Firebase.auth.currentUser?.uid?.let {
            ddb.collection("sportsmen")
                .document(it)
                .update(

                    "shoulder", textShoulder2.text.toString(),
                    "breast", textBreast2.text.toString(),
                    "buttock",textButtocks2.text.toString(),
                    "hip",textHip2.text.toString(),
                    "waist",textWaist2.text.toString(),
                    "biceps",textBiceps2.text.toString()
                )
                .addOnSuccessListener {
                }

        }

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}
