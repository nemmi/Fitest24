package com.example.fitest

import android.content.Intent
import android.os.Bundle
import android.view.View

import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_pitanie.*
import kotlinx.android.synthetic.main.activity_pitanie.checkBox1
import kotlinx.android.synthetic.main.activity_pitanie.checkBox2
import kotlinx.android.synthetic.main.activity_pitanie.checkBox3
import kotlinx.android.synthetic.main.activity_pitanie.checkBox4
import kotlinx.android.synthetic.main.activity_pitanie.checkBox5



class Eat : AppCompatActivity() {

    var mondayChek1 = false
    var mondayChek2 = false
    var mondayChek3 = false
    var mondayChek4 = false
    var mondayChek5 = false

    var tuesdayChek2 = false
    var tuesdayChek1 = false
    var tuesdayChek3 = false
    var tuesdayChek5 = false
    var tuesdayChek4 = false

    var wednesdayChek1 = false
    var wednesdayChek2 = false
    var wednesdayChek3 = false
    var wednesdayChek4 = false
    var wednesdayChek5 = false

    var thursdayChek1 = false
    var thursdayChek2 = false
    var thursdayChek3 = false
    var thursdayChek4 = false
    var thursdayChek5 = false

    var fridayChek1 = false
    var fridayChek2 = false
    var fridayChek3 = false
    var fridayChek4 = false
    var fridayChek5 = false

    var saturdayChek1 = false
    var saturdayChek2 = false
    var saturdayChek3 = false
    var saturdayChek4 = false
    var saturdayChek5 = false

    var sundayChek1 = false
    var sundayChek2 = false
    var sundayChek3 = false
    var sundayChek4 = false
    var sundayChek5 = false

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
        setContentView(R.layout.activity_pitanie)
        loadEat("_M")
        val radGrp = findViewById<RadioGroup>(R.id.tableRow2);
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    when (optionId) {

                        R.id.monday -> {

                            loadEat("_M")
                            scanCheckBoxs(mondayChek1, mondayChek2, mondayChek3, mondayChek4, mondayChek5)

                        }
                        R.id.tuesday -> {

                            loadEat("_T")
                            scanCheckBoxs(tuesdayChek1, tuesdayChek2, tuesdayChek3, tuesdayChek4, tuesdayChek5)

                        }
                        R.id.wednesday -> {

                            loadEat("_W")
                            scanCheckBoxs(wednesdayChek1, wednesdayChek2, wednesdayChek3, wednesdayChek4, wednesdayChek5)

                        }
                        R.id.thursday -> {

                            loadEat("_Th")
                            scanCheckBoxs(thursdayChek1, thursdayChek2, thursdayChek3, thursdayChek4, thursdayChek5)

                        }
                        R.id.friday -> {

                            loadEat("_F")
                            scanCheckBoxs(fridayChek1, fridayChek2, fridayChek3, fridayChek4, fridayChek5)

                        }
                        R.id.saturday -> {

                            loadEat("_Sat")
                            scanCheckBoxs(saturdayChek1, saturdayChek2, saturdayChek3, saturdayChek4, saturdayChek5)

                        }
                        R.id.sunday -> {

                            loadEat("_Sun")
                            scanCheckBoxs(sundayChek1, sundayChek2, sundayChek3, sundayChek4, sundayChek5)

                        }
                        else -> throw AssertionError()
                    }

                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }}
        }
    }
    private val ddb = FirebaseFirestore.getInstance()

    fun eatClick(view: View) {
        when (view.id) {
            R.id.checkBox1 -> {
                if (monday.isChecked) {
                    mondayChek1 = checkBox1.isChecked
                    verificationId("_M", "Checkbox1", mondayChek1.toString())
                }

                if (tuesday.isChecked) {
                    tuesdayChek1 = checkBox1.isChecked
                    verificationId("_T", "Checkbox1", tuesdayChek1.toString())
                }

                if (wednesday.isChecked) {
                    wednesdayChek1 = checkBox1.isChecked
                    verificationId("_W", "Checkbox1", wednesdayChek1.toString())
                }

                if (thursday.isChecked) {
                    thursdayChek1 = checkBox1.isChecked
                    verificationId("_Th", "Checkbox1", thursdayChek1.toString())
                }
                if (friday.isChecked) {
                    fridayChek1 = checkBox1.isChecked
                    verificationId("_F", "Checkbox1", fridayChek1.toString())
                }
                if (saturday.isChecked) {
                    saturdayChek1 = checkBox1.isChecked
                    verificationId("_Sat", "Checkbox1", saturdayChek1.toString())
                }
                if (sunday.isChecked) {
                    sundayChek1 = checkBox1.isChecked
                    verificationId("_Sun", "Checkbox1", sundayChek1.toString())
                }
            }

            R.id.checkBox2 -> {
                if (monday.isChecked) {
                    mondayChek2 = checkBox2.isChecked
                    verificationId("_M", "Checkbox2", mondayChek2.toString())
                }

                if (tuesday.isChecked) {
                    tuesdayChek2 = checkBox2.isChecked
                    verificationId("_T", "Checkbox2", tuesdayChek2.toString())
                }

                if (wednesday.isChecked) {
                    wednesdayChek2 = checkBox2.isChecked
                    verificationId("_W", "Checkbox2", wednesdayChek2.toString())
                }

                if (thursday.isChecked) {
                    thursdayChek2 = checkBox2.isChecked
                    verificationId("_Th", "Checkbox2", thursdayChek2.toString())
                }
                if (friday.isChecked) {
                    fridayChek2 = checkBox2.isChecked
                    verificationId("_F", "Checkbox2", fridayChek2.toString())
                }
                if (saturday.isChecked) {
                    saturdayChek2 = checkBox2.isChecked
                    verificationId("_Sat", "Checkbox2", saturdayChek2.toString())
                }
                if (sunday.isChecked) {
                    sundayChek2 = checkBox2.isChecked
                    verificationId("_Sun", "Checkbox2", sundayChek2.toString())
                }
            }
            R.id.checkBox3 -> {
                if (monday.isChecked) {
                    mondayChek3 = checkBox3.isChecked
                    verificationId("_M", "Checkbox3", mondayChek3.toString())
                }

                if (tuesday.isChecked) {
                    tuesdayChek3 = checkBox3.isChecked
                    verificationId("_T", "Checkbox3", tuesdayChek3.toString())
                }

                if (wednesday.isChecked) {
                    wednesdayChek3 = checkBox3.isChecked
                    verificationId("_W", "Checkbox3", wednesdayChek3.toString())
                }

                if (thursday.isChecked) {
                    thursdayChek3 = checkBox3.isChecked
                    verificationId("_Th", "Checkbox3", thursdayChek3.toString())
                }
                if (friday.isChecked) {
                    fridayChek3 = checkBox3.isChecked
                    verificationId("_F", "Checkbox3", fridayChek3.toString())
                }
                if (saturday.isChecked) {
                    saturdayChek3 = checkBox3.isChecked
                    verificationId("_Sat", "Checkbox3", saturdayChek3.toString())
                }
                if (sunday.isChecked) {
                    sundayChek3 = checkBox3.isChecked
                    verificationId("_Sun", "Checkbox3", sundayChek3.toString())
                }
            }
            R.id.checkBox4 -> {
                if (monday.isChecked) {
                    mondayChek4 = checkBox4.isChecked
                    verificationId("_M", "Checkbox4", mondayChek4.toString())
                }

                if (tuesday.isChecked) {
                    tuesdayChek4 = checkBox4.isChecked
                    verificationId("_T", "Checkbox4", tuesdayChek4.toString())
                }

                if (wednesday.isChecked) {
                    wednesdayChek4 = checkBox4.isChecked
                    verificationId("_W", "Checkbox4", wednesdayChek4.toString())
                }

                if (thursday.isChecked) {
                    thursdayChek4 = checkBox4.isChecked
                    verificationId("_Th", "Checkbox4", thursdayChek4.toString())
                }
                if (friday.isChecked) {
                    fridayChek4 = checkBox4.isChecked
                    verificationId("_F", "Checkbox4", fridayChek4.toString())
                }
                if (saturday.isChecked) {
                    saturdayChek4 = checkBox4.isChecked
                    verificationId("_Sat", "Checkbox4", saturdayChek4.toString())
                }
                if (sunday.isChecked) {
                    sundayChek4 = checkBox4.isChecked
                    verificationId("_Sun", "Checkbox4", sundayChek4.toString())
                }
            }
            R.id.checkBox5 -> {
                if (monday.isChecked) {
                    mondayChek5 = checkBox5.isChecked
                    verificationId("_M", "Checkbox5", mondayChek5.toString())
                }

                if (tuesday.isChecked) {
                    tuesdayChek5 = checkBox5.isChecked
                    verificationId("_T", "Checkbox5", tuesdayChek5.toString())
                }

                if (wednesday.isChecked) {
                    wednesdayChek5 = checkBox5.isChecked
                    verificationId("_W", "Checkbox5", wednesdayChek5.toString())
                }

                if (thursday.isChecked) {
                    thursdayChek5 = checkBox5.isChecked
                    verificationId("_Th", "Checkbox5", thursdayChek5.toString())
                }
                if (friday.isChecked) {
                    fridayChek5 = checkBox5.isChecked
                    verificationId("_F", "Checkbox5", fridayChek5.toString())
                }
                if (saturday.isChecked) {
                    saturdayChek5 = checkBox5.isChecked
                    verificationId("_Sat", "Checkbox5", saturdayChek5.toString())
                }
                if (sunday.isChecked) {
                    sundayChek5 = checkBox5.isChecked
                    verificationId("_Sun", "Checkbox5", sundayChek5.toString())
                }
            }
            R.id.trenning ->{
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    startActivity(Intent(this, TrainingsSportsman::class.java))
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            R.id.chat ->{
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    startActivity(Intent(this, ChatSportsman::class.java))
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            R.id.imageProfile ->{
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    startActivity(Intent(this, ProfileClient::class.java))
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }
    }
    private fun loadEat(day:String){
        Firebase.auth.currentUser?.uid?.let {
            ddb.collection("eat")
                .document(it+day)
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

                    } else {
                        Toast.makeText(
                            baseContext, "Нет данных",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        }
    }

    private fun scanCheckBoxs(Chek1:Boolean, Chek2:Boolean, Chek3:Boolean, Chek4:Boolean, Chek5:Boolean){
        checkBox1.isChecked= false
        checkBox2.isChecked= false
        checkBox3.isChecked= false
        checkBox4.isChecked= false
        checkBox5.isChecked= false

        if(Chek1 == true) checkBox1.isChecked=true
        if(Chek2 == true) checkBox2.isChecked=true
        if(Chek3 == true) checkBox3.isChecked=true
        if(Chek4 == true) checkBox4.isChecked=true
        if(Chek5 == true) checkBox5.isChecked=true

    }

    private fun verificationId(day:String, checkbox:String, daycheck:String)
    {
        Firebase.auth.currentUser?.uid?.let {
            ddb.collection("eat")
                .document(it+day)
                .update(checkbox, daycheck)
                .addOnSuccessListener {
                }
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
