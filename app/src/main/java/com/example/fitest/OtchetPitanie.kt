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
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.android.synthetic.main.activity_otchet_eat.checkBox1
import kotlinx.android.synthetic.main.activity_otchet_eat.checkBox2
import kotlinx.android.synthetic.main.activity_otchet_eat.checkBox3
import kotlinx.android.synthetic.main.activity_otchet_eat.checkBox4
import kotlinx.android.synthetic.main.activity_otchet_eat.checkBox5
import kotlinx.android.synthetic.main.activity_otchet_eat.eat1txt
import kotlinx.android.synthetic.main.activity_otchet_eat.eat2txt
import kotlinx.android.synthetic.main.activity_otchet_eat.eat3txt
import kotlinx.android.synthetic.main.activity_otchet_eat.eat4txt
import kotlinx.android.synthetic.main.activity_otchet_eat.eat5txt
import kotlinx.android.synthetic.main.activity_otchet_trainings.*


class OtchetPitanie : AppCompatActivity() {

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
        setContentView(R.layout.activity_otchet_eat)
        val radGrp = findViewById<RadioGroup>(R.id.tableRow2);

        var value = intent.getStringExtra("id")

        loadinfo(value, "_M")

        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                when (optionId) {

                    R.id.monday -> {
                        loadinfo(value, "_M")
                    }

                    R.id.tuesday -> {
                        loadinfo(value, "_T")
                    }

                    R.id.wednesday -> {
                        loadinfo(value, "_W")
                    }

                    R.id.thursday ->{
                       loadinfo(value, "_Th")
                    }

                    R.id.friday ->{
                        loadinfo(value, "_F")
                    }

                    R.id.saturday ->{
                        loadinfo(value, "_Sat")
                    }

                    R.id.sunday ->{
                        loadinfo(value, "_Sun")
                    }
                    else -> throw AssertionError()
                }
            }
        }
    }



    private val ddb = FirebaseFirestore.getInstance()


    private fun loadinfo(value:String, day:String){
        ddb.collection("eat")
            .document(value+day) /*здесь будет айди спортсмена*/
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(
                        baseContext, "Считать неудалось$e",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {

                    eat1txt.text = snapshot.getString("eat1")
                    eat2txt.text = snapshot.getString("eat2")
                    eat3txt.text = snapshot.getString("eat3")
                    eat4txt.text = snapshot.getString("eat4")
                    eat5txt.text = snapshot.getString("eat5")

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



                       // check(snapshot)
                }
                else {
                    Toast.makeText(
                        baseContext, "Нет данных",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun otchEatClick(view: View) {
        var value= intent.getStringExtra("id")
        when (view.id){

            R.id.imageProfile ->{
                startActivity(Intent(this, ProfileTrener::class.java))
            }
            R.id.Clienti ->{

                startActivity(Intent(this, ListClient::class.java))
            }
            R.id.groupchat ->{

                startActivity(Intent(this, SpisocChatov::class.java))
            }
            R.id.btn_profileClient ->{
                val intent = Intent(this, ProfileClientView::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}
