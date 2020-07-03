package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.fitest.SelectTrener.SelectTrener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
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
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_trener_select_client_view)

        var value = intent.getStringExtra("id")
        Log.i("NewActivity2", value)




        btnSelectTrainer.setOnClickListener {
            if(Firebase.auth.currentUser?.uid?.let {
                    it=="DGZR5wetADb3iovL7TDfAwg70lB3"
                }!!){
                Toast.makeText(
                    baseContext, "Сначала авторизируйтесь!",
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(Intent(this, MainActivity::class.java))
            }
            else {
                Firebase.auth.currentUser?.uid?.let {
                    ddb.collection("sportsmen")
                        .document(it)
                        .update(
                            "myTrener", value.toString()
                        )
                        .addOnSuccessListener {
                            Toast.makeText(
                                baseContext, "Успешно!",
                                Toast.LENGTH_SHORT
                            ).show()

                            startActivity(Intent(this, ProfileClient::class.java))
                        }
                }
            }
        }

        if (IsInternetAvailable.isInternetAvailable(this)) {
            loadData()
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
        if (IsInternetAvailable.isInternetAvailable(this)) {
            trenerSelectBack.setOnClickListener {
                val intent = Intent(this, SelectTrener::class.java)
                startActivity(intent)
            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private val storage = FirebaseStorage.getInstance()

    private fun  loadData(){
        var value = intent.getStringExtra("id")
        Log.i("NewActivity2", value)

        var photoImage = storage.reference.child("TrenersPhoto").child(value)

        photoImage.downloadUrl.addOnSuccessListener { Uri ->
            val imageURL = Uri.toString()
            Glide.with(this)
                .load(imageURL)
                .into(photoImg)
        }


        ddb.collection("treners").document(value).addSnapshotListener{
                snapshot, e ->
            if (e != null) {
                Toast.makeText(
                    baseContext, resources.getString(R.string.error_base),
                    Toast.LENGTH_SHORT
                ).show()
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {
                costThisTrainer.text=snapshot.getString("price")
                nameThisTrainer.text=snapshot.getString("name")
                description1.text=snapshot.getString("win")
                description3.text=snapshot.getString("spec")
                description2.text=snapshot.getString("study")
            }
            else {
                Toast.makeText(
                    baseContext, resources.getString(R.string.error_empty_base),
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

    fun alert(){
        Toast.makeText(
            baseContext, resources.getString(R.string.error_internet),
            Toast.LENGTH_SHORT
        ).show()
    }
}