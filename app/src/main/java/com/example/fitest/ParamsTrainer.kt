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
import kotlinx.android.synthetic.main.activity_body_params_coach_otchet.*


class ParamsTrainer : AppCompatActivity() {


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
        setContentView(R.layout.activity_body_params_coach_otchet)
        var value = intent.getStringExtra("id")
        // Log.i("NewActivity", value)
        loadData(value)

    }
    private val ddb = FirebaseFirestore.getInstance()

    private fun loadData(value: String) {

        ddb.collection("sportsmen")
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
    fun paramsCoachClick(view: View) {
        var value= intent.getStringExtra("id")
        when (view.id) {
            R.id.buttonClients -> {
                val intent = Intent(this, ListClient::class.java)
                startActivity(intent)
            }
            R.id.buttonClientsProfile -> {
                val intent = Intent(this, ProfileClientView::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
            R.id.buttonChat -> {
                val intent = Intent(this, SpisocChatov::class.java)
                startActivity(intent)
            }
            R.id.profileCircle -> {
                val intent = Intent(this, ProfileTrainer::class.java)
                startActivity(intent)
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