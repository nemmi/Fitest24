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

import kotlinx.android.synthetic.main.activity_otchet_trainings.*
import kotlinx.android.synthetic.main.activity_otchet_trainings.checkBox1
import kotlinx.android.synthetic.main.activity_otchet_trainings.checkBox2
import kotlinx.android.synthetic.main.activity_otchet_trainings.checkBox3
import kotlinx.android.synthetic.main.activity_otchet_trainings.checkBox4
import kotlinx.android.synthetic.main.activity_otchet_trainings.checkBox5
import kotlinx.android.synthetic.main.activity_otchet_trainings.checkBox6
import kotlinx.android.synthetic.main.activity_otchet_trainings.textExercise2
import kotlinx.android.synthetic.main.activity_otchet_trainings.textExercise3
import kotlinx.android.synthetic.main.activity_otchet_trainings.textExercise4
import kotlinx.android.synthetic.main.activity_otchet_trainings.textExercise5
import kotlinx.android.synthetic.main.activity_otchet_trainings.textExercise6
import kotlinx.android.synthetic.main.activity_otchet_trainings.textExercise7



class Trainings_Coach : AppCompatActivity() {

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
        setContentView(R.layout.activity_otchet_trainings)
        val radGrp = findViewById<RadioGroup>(R.id.radioGroup);
        var value = intent.getStringExtra("id")
        // Log.i("NewActivity", value)

        loadFirst(value)
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                when (optionId) {

                    R.id.button_day1 -> {
                        loadFirst(value)
                    }
                    R.id.button_day2 -> {
                        ddb.collection("trainings")
                            .document(value+"_2")
                            .addSnapshotListener { snapshot, e ->
                                if (e != null) {
                                    Toast.makeText(
                                        baseContext, "Считать неудалось$e",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@addSnapshotListener
                                }
                                if (snapshot != null && snapshot.exists()) {

                                    textExercise.text = snapshot.getString("Exercise1")
                                    textExercise2.text = snapshot.getString("Exercise2")
                                    textExercise3.text = snapshot.getString("Exercise3")
                                    textExercise4.text = snapshot.getString("Exercise4")
                                    textExercise5.text = snapshot.getString("Exercise5")
                                    textExercise6.text = snapshot.getString("Exercise6")
                                    textExercise7.text = snapshot.getString("Exercise7")


                                    editPodhody1.text = snapshot.getString("Podhod1")
                                    editPodhody2.text = snapshot.getString("Podhod2")
                                    editPodhody3.text = snapshot.getString("Podhod3")
                                    editPodhody4.text = snapshot.getString("Podhod4")
                                    editPodhody5.text = snapshot.getString("Podhod5")
                                    editPodhody6.text = snapshot.getString("Podhod6")
                                    editPodhody7.text = snapshot.getString("Podhod7")


                                    editKG.text = snapshot.getString("Weight1")
                                    editKG2.text = snapshot.getString("Weight2")
                                    editKG3.text = snapshot.getString("Weight3")
                                    editKG4.text = snapshot.getString("Weight4")
                                    editKG5.text = snapshot.getString("Weight5")
                                    editKG6.text = snapshot.getString("Weight6")
                                    editKG7.text = snapshot.getString("Weight7")

                                    check(snapshot)
                                }
                                else {
                                    Toast.makeText(
                                        baseContext, "Нет данных",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }
                    R.id.button_day3 -> {
                        ddb.collection("trainings")
                            .document(value+"_3")
                            .addSnapshotListener { snapshot, e ->
                                if (e != null) {
                                    Toast.makeText(
                                        baseContext, "Считать неудалось$e",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@addSnapshotListener
                                }
                                if (snapshot != null && snapshot.exists()) {

                                    textExercise.text = snapshot.getString("Exercise1")
                                    textExercise2.text = snapshot.getString("Exercise2")
                                    textExercise3.text = snapshot.getString("Exercise3")
                                    textExercise4.text = snapshot.getString("Exercise4")
                                    textExercise5.text = snapshot.getString("Exercise5")
                                    textExercise6.text = snapshot.getString("Exercise6")
                                    textExercise7.text = snapshot.getString("Exercise7")


                                    editPodhody1.text = snapshot.getString("Podhod1")
                                    editPodhody2.text = snapshot.getString("Podhod2")
                                    editPodhody3.text = snapshot.getString("Podhod3")
                                    editPodhody4.text = snapshot.getString("Podhod4")
                                    editPodhody5.text = snapshot.getString("Podhod5")
                                    editPodhody6.text = snapshot.getString("Podhod6")
                                    editPodhody7.text = snapshot.getString("Podhod7")


                                    editKG.text = snapshot.getString("Weight1")
                                    editKG2.text = snapshot.getString("Weight2")
                                    editKG3.text = snapshot.getString("Weight3")
                                    editKG4.text = snapshot.getString("Weight4")
                                    editKG5.text = snapshot.getString("Weight5")
                                    editKG6.text = snapshot.getString("Weight6")
                                    editKG7.text = snapshot.getString("Weight7")

                                    check(snapshot)
                                }
                                else {
                                    Toast.makeText(
                                        baseContext, "Нет данных",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }
                    else -> throw AssertionError()
                }
            }
        }
    }
    private val ddb = FirebaseFirestore.getInstance()

    private fun loadFirst(value: String?) {

        ddb.collection("trainings")
            .document(value+"_1")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(
                        baseContext, "Считать неудалось$e",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {

                    textExercise.text = snapshot.getString("Exercise1")
                    textExercise2.text = snapshot.getString("Exercise2")
                    textExercise3.text = snapshot.getString("Exercise3")
                    textExercise4.text = snapshot.getString("Exercise4")
                    textExercise5.text = snapshot.getString("Exercise5")
                    textExercise6.text = snapshot.getString("Exercise6")
                    textExercise7.text = snapshot.getString("Exercise7")


                    editPodhody1.text = snapshot.getString("Podhod1")
                    editPodhody2.text = snapshot.getString("Podhod2")
                    editPodhody3.text = snapshot.getString("Podhod3")
                    editPodhody4.text = snapshot.getString("Podhod4")
                    editPodhody5.text = snapshot.getString("Podhod5")
                    editPodhody6.text = snapshot.getString("Podhod6")
                    editPodhody7.text = snapshot.getString("Podhod7")


                    editKG.text = snapshot.getString("Weight1")
                    editKG2.text = snapshot.getString("Weight2")
                    editKG3.text = snapshot.getString("Weight3")
                    editKG4.text = snapshot.getString("Weight4")
                    editKG5.text = snapshot.getString("Weight5")
                    editKG6.text = snapshot.getString("Weight6")
                    editKG7.text = snapshot.getString("Weight7")

                    check(snapshot)
                }
                else {
                    Toast.makeText(
                        baseContext, "Нет данных",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun trenCoachClick(view: View) {
        var value= intent.getStringExtra("id")
        when (view.id){
            R.id.button_clients ->{
                val intent = Intent(this, ListClient::class.java)
                startActivity(intent)
            }
            R.id.button_clients_profile ->{
                val intent = Intent(this, ProfileClientView::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
            R.id.button_chat ->{
                val intent = Intent(this, SpisocChatov::class.java)
                startActivity(intent)
            }
            R.id.profile ->{
                val intent = Intent(this, ProfileTrener::class.java)
                startActivity(intent)
            }


        }
    }
    private fun check(snapshot: DocumentSnapshot?){

        if (snapshot != null) {
            if (snapshot.getString("Checkbox1") == "true") {
                checkBox1.isChecked = true
            }
            if (snapshot.getString("Checkbox2") == "true") {
                checkBox2.isChecked = true
            }
            if (snapshot.getString("Checkbox3") == "true") {
                checkBox3.isChecked = true
            }
            if (snapshot.getString("Checkbox4") == "true") {
                checkBox4.isChecked = true
            }
            if (snapshot.getString("Checkbox5") == "true") {
                checkBox5.isChecked = true
            }
            if (snapshot.getString("Checkbox6") == "true") {
                checkBox6.isChecked = true
            }
            if (snapshot.getString("Checkbox7") == "true") {
                checkBox7.isChecked = true
            }
        }

    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}