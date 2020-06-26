package com.example.fitest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager

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



class Pitanie : AppCompatActivity() {


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
        setContentView(R.layout.activity_pitanie)
        loadMon()
        val radGrp = findViewById<RadioGroup>(R.id.tableRow2);
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                when (optionId) {

                    R.id.monday -> {
                        loadMon()
                    }

                    R.id.tuesday -> {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_T")
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
                                        if(snapshot.getString("CheckBox1")=="true")checkBox1.isChecked= true
                                        if(snapshot.getString("CheckBox2")=="true")checkBox2.isChecked= true
                                        if(snapshot.getString("CheckBox3")=="true")checkBox3.isChecked= true
                                        if(snapshot.getString("CheckBox4")=="true")checkBox4.isChecked= true
                                        if(snapshot.getString("CheckBox5")=="true")checkBox5.isChecked= true

                                    } else {
                                        Toast.makeText(
                                            baseContext, "Нет данных",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        }
                    }
                    R.id.wednesday -> {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_W")
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
                                        if(snapshot.getString("CheckBox1")=="true")checkBox1.isChecked= true
                                        if(snapshot.getString("CheckBox2")=="true")checkBox2.isChecked= true
                                        if(snapshot.getString("CheckBox3")=="true")checkBox3.isChecked= true
                                        if(snapshot.getString("CheckBox4")=="true")checkBox4.isChecked= true
                                        if(snapshot.getString("CheckBox5")=="true")checkBox5.isChecked= true
                                    } else {
                                        Toast.makeText(
                                            baseContext, "Нет данных",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        }
                    }
                    R.id.thursday -> {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_Th")
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
                                        if(snapshot.getString("CheckBox1")=="true")checkBox1.isChecked= true
                                        if(snapshot.getString("CheckBox2")=="true")checkBox2.isChecked= true
                                        if(snapshot.getString("CheckBox3")=="true")checkBox3.isChecked= true
                                        if(snapshot.getString("CheckBox4")=="true")checkBox4.isChecked= true
                                        if(snapshot.getString("CheckBox5")=="true")checkBox5.isChecked= true
                                    } else {
                                        Toast.makeText(
                                            baseContext, "Нет данных",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        }
                    }
                    R.id.friday -> {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_F")
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
                                        if(snapshot.getString("CheckBox1")=="true")checkBox1.isChecked= true
                                        if(snapshot.getString("CheckBox2")=="true")checkBox2.isChecked= true
                                        if(snapshot.getString("CheckBox3")=="true")checkBox3.isChecked= true
                                        if(snapshot.getString("CheckBox4")=="true")checkBox4.isChecked= true
                                        if(snapshot.getString("CheckBox5")=="true")checkBox5.isChecked= true

                                    } else {
                                        Toast.makeText(
                                            baseContext, "Нет данных",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        }
                    }
                    R.id.saturday -> {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_Sat")
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
                                        if(snapshot.getString("CheckBox1")=="true")checkBox1.isChecked= true
                                        if(snapshot.getString("CheckBox2")=="true")checkBox2.isChecked= true
                                        if(snapshot.getString("CheckBox3")=="true")checkBox3.isChecked= true
                                        if(snapshot.getString("CheckBox4")=="true")checkBox4.isChecked= true
                                        if(snapshot.getString("CheckBox5")=="true")checkBox5.isChecked= true

                                    } else {
                                        Toast.makeText(
                                            baseContext, "Нет данных",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        }
                    }
                    R.id.sunday -> {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_Sun")
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

                                        if(snapshot.getString("CheckBox1")=="true")checkBox1.isChecked= true
                                        if(snapshot.getString("CheckBox2")=="true")checkBox2.isChecked= true
                                        if(snapshot.getString("CheckBox3")=="true")checkBox3.isChecked= true
                                        if(snapshot.getString("CheckBox4")=="true")checkBox4.isChecked= true
                                        if(snapshot.getString("CheckBox5")=="true")checkBox5.isChecked= true

                                    } else {
                                        Toast.makeText(
                                            baseContext, "Нет данных",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        }
                    }
                    else -> throw AssertionError()
                }

            }

        }
    }
    private val ddb = FirebaseFirestore.getInstance()

    fun eatClick(view: View) {
        when (view.id) {
            R.id.checkBox1 -> {
                if (checkBox1.isChecked) {
                    if (monday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_M")
                                .update("Checkbox1", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (tuesday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_T")
                                .update("Checkbox1", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (wednesday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_W")
                                .update("Checkbox1", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (thursday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Th")
                                .update("Checkbox1", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (friday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_F")
                                .update("Checkbox1", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (saturday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Sat")
                                .update("Checkbox1", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (sunday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Sun")
                                .update("Checkbox1", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    else {
                        if (!monday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_M")
                                    .update("Checkbox1", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!tuesday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_T")
                                    .update("Checkbox1", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!wednesday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_W")
                                    .update("Checkbox1", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!thursday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Th")
                                    .update("Checkbox1", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!friday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_F")
                                    .update("Checkbox1", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!saturday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Sat")
                                    .update("Checkbox1", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!sunday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Sun")
                                    .update("Checkbox1", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                    }
                }
            }
            R.id.checkBox2 -> {
                if (checkBox2.isChecked) {
                    if (monday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_M")
                                .update("Checkbox2", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (tuesday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_T")
                                .update("Checkbox2", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (wednesday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_W")
                                .update("Checkbox2", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (thursday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Th")
                                .update("Checkbox2", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (friday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_F")
                                .update("Checkbox2", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (saturday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Sat")
                                .update("Checkbox2", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (sunday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Sun")
                                .update("Checkbox2", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    else {
                        if (!monday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_M")
                                    .update("Checkbox2", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!tuesday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_T")
                                    .update("Checkbox2", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!wednesday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_W")
                                    .update("Checkbox2", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!thursday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Th")
                                    .update("Checkbox2", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!friday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_F")
                                    .update("Checkbox2", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!saturday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Sat")
                                    .update("Checkbox2", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!sunday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Sun")
                                    .update("Checkbox2", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                    }
                }
            }
            R.id.checkBox3 -> {
                if (checkBox3.isChecked) {
                    if (monday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_M")
                                .update("Checkbox3", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (tuesday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_T")
                                .update("Checkbox3", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (wednesday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_W")
                                .update("Checkbox3", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (thursday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Th")
                                .update("Checkbox3", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (friday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_F")
                                .update("Checkbox3", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (saturday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Sat")
                                .update("Checkbox3", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (sunday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Sun")
                                .update("Checkbox3", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    else {
                        if (!monday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_M")
                                    .update("Checkbox3", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!tuesday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_T")
                                    .update("Checkbox3", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!wednesday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_W")
                                    .update("Checkbox3", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!friday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_F")
                                    .update("Checkbox3", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!saturday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Sat")
                                    .update("Checkbox3", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!sunday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Sun")
                                    .update("Checkbox3", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                    }
                }
            }
            R.id.checkBox4 -> {
                if (checkBox4.isChecked) {
                    if (monday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_M")
                                .update("Checkbox4", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (tuesday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_T")
                                .update("Checkbox4", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (wednesday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_W")
                                .update("Checkbox4", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (thursday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Th")
                                .update("Checkbox4", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (friday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_F")
                                .update("Checkbox4", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (saturday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Sat")
                                .update("Checkbox4", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (sunday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it + "_Sun")
                                .update("Checkbox4", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    else {
                        if (!monday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_M")
                                    .update("Checkbox4", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!tuesday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_T")
                                    .update("Checkbox4", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!wednesday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_W")
                                    .update("Checkbox4", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!thursday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Th")
                                    .update("Checkbox4", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!friday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_F")
                                    .update("Checkbox4", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!saturday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Sat")
                                    .update("Checkbox4", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!sunday.isChecked) {
                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("eat")
                                    .document(it+"_Sun")
                                    .update("Checkbox4", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                    }
                }
            }
            R.id.checkBox5 -> {
                if (monday.isChecked) {
                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("eat")
                            .document(it + "_M")
                            .update("Checkbox5", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (tuesday.isChecked) {
                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("eat")
                            .document(it + "_T")
                            .update("Checkbox5", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (wednesday.isChecked) {
                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("eat")
                            .document(it + "_W")
                            .update("Checkbox5", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (thursday.isChecked) {
                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("eat")
                            .document(it + "_Th")
                            .update("Checkbox5", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (friday.isChecked) {
                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("eat")
                            .document(it + "_F")
                            .update("Checkbox5", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (saturday.isChecked) {
                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("eat")
                            .document(it + "_Sat")
                            .update("Checkbox5", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (sunday.isChecked) {
                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("eat")
                            .document(it + "_Sun")
                            .update("Checkbox5", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                else {
                    if (!monday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_M")
                                .update("Checkbox5", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!tuesday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_T")
                                .update("Checkbox5", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!wednesday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_W")
                                .update("Checkbox5", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!thursday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_Th")
                                .update("Checkbox5", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!friday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_F")
                                .update("Checkbox5", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!saturday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_Sat")
                                .update("Checkbox5", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!sunday.isChecked) {
                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("eat")
                                .document(it+"_Sun")
                                .update("Checkbox5", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                }

            }
            R.id.trenning ->{

                startActivity(Intent(this, Trainings_Sportsmen::class.java))
            }
            R.id.chat ->{

                startActivity(Intent(this, Chat_Sportsmen::class.java))
            }
            R.id.imageProfile ->{
                startActivity(Intent(this, ProfileClient::class.java))
            }
        }
    }
    private fun loadMon(){
        Firebase.auth.currentUser?.uid?.let {
            ddb.collection("eat")
                .document(it+"_M")
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
                        if(snapshot.getString("CheckBox1")=="true")checkBox1.isChecked= true
                        if(snapshot.getString("CheckBox2")=="true")checkBox2.isChecked= true
                        if(snapshot.getString("CheckBox3")=="true")checkBox3.isChecked= true
                        if(snapshot.getString("CheckBox4")=="true")checkBox4.isChecked= true
                        if(snapshot.getString("CheckBox5")=="true")checkBox5.isChecked= true

                    } else {
                        Toast.makeText(
                            baseContext, "Нет данных",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}
