package com.example.fitest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_anketa_view.*


class anketaView : AppCompatActivity(){
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
        setContentView(R.layout.activity_sportsmen_anketa1)
        loadData()
    }

    private fun loadData() {
        ddb.collection("sportsmen")
            .document(/*здесь айди выбранного спортсмена */)
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(
                        baseContext, "Считать неудалось$e",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {
                    Age.text=snapshot.getString("age")
                    ExpTr.text=snapshot.getString("experience")
                    Goals.text=snapshot.getString("goals")
                    DontEat.text=snapshot.getString("hatingEat")
                    HeightAnketa.text=snapshot.getString("height")
                    AnketaWeight.text=snapshot.getString("weight")
                    BADS.text=snapshot.getString("bads")
                    Blood.text=snapshot.getString("bloods")
                    Belok.text=snapshot.getString("belock")
                    Carbs.text=snapshot.getString("carbs")
                    Fats.text=snapshot.getString("fats")
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
    fun anketaClick(view: View) {
        when (view.id) {
            R.id.toolbar3 -> {
                val intent = Intent(this, ProfileClientView::class.java)
                startActivity(intent)
            }

        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}