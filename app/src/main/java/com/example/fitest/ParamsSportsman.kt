package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

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


class ParamsSportsman : AppCompatActivity() {

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
        setContentView(R.layout.activity_body_params)
        if (IsInternetAvailable.isInternetAvailable(this)) {
            loadData()
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
    private val ddb = FirebaseFirestore.getInstance()

    private fun loadData() {
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
                            baseContext, resources.getString(R.string.error_empty_base),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
        }
    }

    fun paramSportClick(view: View) {
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {
                R.id.toolbar -> {
                    startActivity(Intent(this, ProfileClient::class.java))
                }
                R.id.buttonEdit -> {
                    param()
                    startActivity(Intent(this, ParamsEdit::class.java))
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
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
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

    fun alert(){
        Toast.makeText(
            baseContext, resources.getString(R.string.error_internet),
            Toast.LENGTH_SHORT
        ).show()
    }
}
