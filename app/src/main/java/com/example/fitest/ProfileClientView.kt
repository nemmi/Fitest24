package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.firestore.FirebaseFirestore
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
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile_client_view)

        if (IsInternetAvailable.isInternetAvailable(this)) {
            read()
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private fun read() {

        var value = intent.getStringExtra("id")
        Log.i("NewActivity", value)

        ddb.collection("sportsmen").document(value).addSnapshotListener{
                snapshot, e ->
            if (e != null) {
                Toast.makeText(
                    baseContext, resources.getString(R.string.error_base),
                    Toast.LENGTH_SHORT
                ).show()
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {
                textMail.text=snapshot.getString("email")
                textName.text=snapshot.getString("name")
                textPhone.text=snapshot.getString("phoneNumber")
                textNumOfTren.text=snapshot.getString("num")
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

    fun profileSpViewClick(view: View) {
        var value = intent.getStringExtra("id")
        Log.i("NewActivity", value)
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {
                R.id.lookForm -> {
                    val intent = Intent(this, FormSportsmanView::class.java)
                    Log.i("DocId", value)
                    intent.putExtra("id", value)
                    Log.i("Intent", value)

                    startActivity(intent)
                }
                R.id.iconChat -> {
                    val intent = Intent(this, ChatTrainer::class.java)
                    Log.i("DocId", value)
                    intent.putExtra("id", value)
                    Log.i("Intent", value)

                    startActivity(intent)
                }
                R.id.programmTrainings -> {
                    val intent = Intent(this, LoadTrainings::class.java)
                    Log.i("DocId", value)
                    intent.putExtra("id", value)
                    Log.i("Intent", value)

                    startActivity(intent)
                }
                R.id.programmEat -> {
                    val intent = Intent(this, LoadEat::class.java)
                    Log.i("DocId", value)
                    intent.putExtra("id", value)
                    Log.i("Intent", value)

                    startActivity(intent)
                }
                R.id.formTrainings -> {
                    val intent = Intent(this, TrainingsTrainer::class.java)
                    Log.i("DocId", value)
                    intent.putExtra("id", value)
                    Log.i("Intent", value)

                    startActivity(intent)
                }
                R.id.formEat -> {
                    val intent = Intent(this, ReportEat::class.java)
                    Log.i("DocId", value)
                    intent.putExtra("id", value)
                    Log.i("Intent", value)

                    startActivity(intent)
                }
                R.id.formParams -> {
                    val intent = Intent(this, ParamsTrainer::class.java)
                    Log.i("DocId", value)
                    intent.putExtra("id", value)
                    Log.i("Intent", value)

                    startActivity(intent)
                }
                R.id.listClients -> {
                    startActivity(Intent(this, ListClient::class.java))
                }
                R.id.openYourProfile -> {
                    startActivity(Intent(this, ProfileTrainer::class.java))
                }
                R.id.chat -> {
                    startActivity(Intent(this, SpisocChatov::class.java))
                }

            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
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