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



class TrainingsTrainer : AppCompatActivity() {

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
        setContentView(R.layout.activity_otchet_trainings)
        val radGrp = findViewById<RadioGroup>(R.id.radioGroup);
        var value = intent.getStringExtra("id")
        // Log.i("NewActivity", value)

        loadFirst(value, "_1")
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    when (optionId) {

                        R.id.buttonDay1 -> {
                            loadFirst(value, "_1")
                        }
                        R.id.buttonDay2 -> {
                            loadFirst(value, "_2")
                        }
                        R.id.buttonDay3 -> {
                            loadFirst(value, "_3")
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

    private fun loadFirst(value: String?, day:String) {

        ddb.collection("trainings")
            .document(value+day)
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(
                        baseContext, resources.getString(R.string.error_base),
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

                    if(snapshot.getString("Checkbox6") == "true")
                    {checkBox6.setChecked(true)} else {checkBox6.setChecked(false)}

                    if(snapshot.getString("Checkbox7") == "true")
                    {checkBox7.setChecked(true)} else {checkBox7.setChecked(false)}

                    //check(snapshot)
                }
                else {
                    Toast.makeText(
                        baseContext, resources.getString(R.string.error_empty_base),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun trenCoachClick(view: View) {
        var value= intent.getStringExtra("id")
        if (IsInternetAvailable.isInternetAvailable(this)) {
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
                R.id.profile -> {
                    val intent = Intent(this, ProfileTrainer::class.java)
                    startActivity(intent)
                }


            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun alert(){
        Toast.makeText(
            baseContext, resources.getString(R.string.error_internet),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}