package com.example.fitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

import kotlinx.android.synthetic.main.activity_trener_select_client_view.*


class TrenerSelectClientView : AppCompatActivity() {

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
        setContentView(R.layout.activity_trener_select_client_view)
        loadData()
    }

    private val storage = FirebaseStorage.getInstance()
    private var PhotoImage = storage.reference.child("TrenersPhoto").child("2OBPiRIe4ecZ6Ov0rUTixvIfy9x2") /* чайлд до айди*/
    private fun  loadData(){
        PhotoImage.downloadUrl.addOnSuccessListener { Uri ->
            val imageURL = Uri.toString()

            Glide.with(this)
                .load(imageURL)
                .into(imageView62)
        }

        ddb.collection("treners")
            .document("2OBPiRIe4ecZ6Ov0rUTixvIfy9x2") /*здесь будет айди тренера*/
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(
                        baseContext, "Считать неудалось$e",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {
                    textView3.text=snapshot.getString("name")
                    textView7.text=snapshot.getString("price")
                    textViewR.text=snapshot.getString("study")
                    textView2.text=snapshot.getString("win")
                    textView8.text=snapshot.getString("spec")
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
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}
