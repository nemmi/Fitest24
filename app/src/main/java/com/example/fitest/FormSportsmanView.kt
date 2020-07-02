package com.example.fitest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_anketa_view.*



class FormSportsmanView : AppCompatActivity(){
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
        setContentView(R.layout.activity_anketa_view)

        var value = intent.getStringExtra("id")
        Log.i("NewActivity", value)

        if (IsInternetAvailable.isInternetAvailable(this)) {
            toolbarAnketaView.setOnClickListener {
                val intent = Intent(this, ProfileClientView::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }

        loadData(value)
    }

    private fun loadData(value: String) {

        FirebaseFirestore.getInstance().collection("sportsmen")
            .document(value)
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(
                        baseContext, resources.getString(R.string.error_base),
                        Toast.LENGTH_SHORT
                    ).show()
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {
                    age.text=snapshot.getString("age")
                    expTr.text=snapshot.getString("experience")
                    goals.text=snapshot.getString("goals")
                    dontEat.text=snapshot.getString("hatingEat")
                    heightAnketa.text=snapshot.getString("height")
                    anketaWeight.text=snapshot.getString("weight")
                    bads.text=snapshot.getString("bads")
                    blood.text=snapshot.getString("bloods")
                    belok.text=snapshot.getString("belock")
                    carbs.text=snapshot.getString("carbs")
                    fats.text=snapshot.getString("fats")
                }
                else {
                    Toast.makeText(
                        baseContext, resources.getString(R.string.error_empty_base),
                        Toast.LENGTH_SHORT
                    ).show()
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