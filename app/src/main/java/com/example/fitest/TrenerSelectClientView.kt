package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.fitest.dffgh.SelectTrener
import com.google.firebase.auth.FirebaseAuth
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
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_trener_select_client_view)

        var value = intent.getStringExtra("id")
        Log.i("NewActivity2", value)




        imageButton27.setOnClickListener {
            if(Firebase.auth.currentUser?.uid?.let {
                    it=="caBlWtPi6idpzBQUZ7M9Ta7w70q2"
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


        loadData()

        imageButton26.setOnClickListener { val intent = Intent(this, SelectTrener::class.java)
        startActivity(intent)}

    }

    private val storage = FirebaseStorage.getInstance()

    private fun  loadData(){


        var value = intent.getStringExtra("id")
        Log.i("NewActivity2", value)

        var PhotoImage = storage.reference.child("TrenersPhoto").child(value) /* чайлд до айди*/

        PhotoImage.downloadUrl.addOnSuccessListener { Uri ->
            val imageURL = Uri.toString()
            Glide.with(this)
                .load(imageURL)
                .into(photoImg)
        }


        ddb.collection("treners").document(value).addSnapshotListener{
                snapshot, e ->
            if (e != null) {
                Toast.makeText(
                    baseContext, "Считать неудалось$e",
                    Toast.LENGTH_SHORT
                ).show()
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {
                textView7.text=snapshot.getString("price")
                textView3.text=snapshot.getString("name")
                textViewR.text=snapshot.getString("win")
                textView8.text=snapshot.getString("spec")
                textView2.text=snapshot.getString("study")
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