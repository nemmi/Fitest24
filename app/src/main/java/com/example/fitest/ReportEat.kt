package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.RadioGroup
import android.widget.Toast
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_otchet_eat.*


class ReportEat : AppCompatActivity() {

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
        setContentView(R.layout.activity_otchet_eat)
        val radGrp = findViewById<RadioGroup>(R.id.tableRow2);

        var value = intent.getStringExtra("id")

        loadInfo(value, "_M")

        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    when (optionId) {

                        R.id.monday -> {
                            loadInfo(value, "_M")
                        }

                        R.id.tuesday -> {
                            loadInfo(value, "_T")
                        }

                        R.id.wednesday -> {
                            loadInfo(value, "_W")
                        }

                        R.id.thursday -> {
                            loadInfo(value, "_Th")
                        }

                        R.id.friday -> {
                            loadInfo(value, "_F")
                        }

                        R.id.saturday -> {
                            loadInfo(value, "_Sat")
                        }

                        R.id.sunday -> {
                            loadInfo(value, "_Sun")
                        }
                        else -> throw AssertionError()
                    }
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }
    }



    private val ddb = FirebaseFirestore.getInstance()


    private fun loadInfo(value:String, day:String){
        ddb.collection("eat")
            .document(value+day) /*здесь будет айди спортсмена*/
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(
                        baseContext, resources.getString(R.string.error_base),
                        Toast.LENGTH_SHORT
                    ).show()
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {

                    eatTxt1.text = snapshot.getString("eat1")
                    eatTxt2.text = snapshot.getString("eat2")
                    eatTxt3.text = snapshot.getString("eat3")
                    eatTxt4.text = snapshot.getString("eat4")
                    eatTxt5.text = snapshot.getString("eat5")

                    if(snapshot.getString("Checkbox1") == "true")
                    {checkBox1.setChecked(true)} else {checkBox1.setChecked(false)}

                    if(snapshot.getString("Checkbox2") == "true")
                    {checkBox2.setChecked(true)} else {checkBox2.setChecked(false)}

                    if(snapshot.getString("Checkbox3") == "true")
                    {checkBox3.setChecked(true)} else {checkBox3.setChecked(false)}

                    if(snapshot.getString("Checkbox4") == "true")
                    {checkBox4.setChecked(true)} else {checkBox4.setChecked(false)}

                    if(snapshot.getString("Checkbox5") == "true")
                    {checkBox5.setChecked(true)} else {checkBox5.setChecked(false)}

                }
                else {
                    Toast.makeText(
                        baseContext, resources.getString(R.string.error_empty_base),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun otchEatClick(view: View) {
        var value = intent.getStringExtra("id")
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {

                R.id.imageProfile -> {
                    startActivity(Intent(this, ProfileTrainer::class.java))
                }
                R.id.btnClients -> {

                    startActivity(Intent(this, ListClient::class.java))
                }
                R.id.btnChat -> {

                    startActivity(Intent(this, SpisocChatov::class.java))
                }
                R.id.btnProfileClient -> {
                    val intent = Intent(this, ProfileClientView::class.java)
                    Log.i("DocId", value)
                    intent.putExtra("id", value)
                    Log.i("Intent", value)

                    startActivity(intent)
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
