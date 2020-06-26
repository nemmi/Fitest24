package com.example.fitest

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.CheckBox
import android.widget.MediaController
import android.widget.RadioGroup
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

import kotlinx.android.synthetic.main.activity_trainings.*
import kotlinx.android.synthetic.main.activity_trainings.checkBox1
import kotlinx.android.synthetic.main.activity_trainings.checkBox2
import kotlinx.android.synthetic.main.activity_trainings.checkBox3
import kotlinx.android.synthetic.main.activity_trainings.checkBox4
import kotlinx.android.synthetic.main.activity_trainings.checkBox5
import kotlinx.android.synthetic.main.activity_trainings.textExercise2
import kotlinx.android.synthetic.main.activity_trainings.textExercise3
import kotlinx.android.synthetic.main.activity_trainings.textExercise4
import kotlinx.android.synthetic.main.activity_trainings.textExercise5
import kotlinx.android.synthetic.main.activity_trainings.textExercise6


class Trainings_Sportsmen : AppCompatActivity() {

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
        setContentView(R.layout.activity_trainings)

        val radGrp = findViewById<RadioGroup>(R.id.radioGroup);
        loadFirst()
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                when (optionId) {
                    R.id.button_day1 -> {

                        loadFirst()
                    }
                    R.id.button_day2 -> {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_2")
                                .addSnapshotListener { snapshot, e ->
                                    if (e != null) {
                                        Toast.makeText(
                                            baseContext, "Считать неудалось$e",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        return@addSnapshotListener
                                    }
                                    if (snapshot != null && snapshot.exists()) {
                                        textExercise1.text = snapshot.getString("Exercise1")
                                        textExercise2.text = snapshot.getString("Exercise2")
                                        textExercise3.text = snapshot.getString("Exercise3")
                                        textExercise4.text = snapshot.getString("Exercise4")
                                        textExercise5.text = snapshot.getString("Exercise5")
                                        textExercise6.text = snapshot.getString("Exercise6")
                                        textExercise7.text = snapshot.getString("Exercise7")


                                        textPodhod1.text = snapshot.getString("Podhod1")
                                        textPodhod2.text = snapshot.getString("Podhod2")
                                        textPodhod3.text = snapshot.getString("Podhod3")
                                        textPodhod4.text = snapshot.getString("Podhod4")
                                        textPodhod5.text = snapshot.getString("Podhod5")
                                        textPodhod6.text = snapshot.getString("Podhod6")
                                        textPodhod7.text = snapshot.getString("Podhod7")


                                        textWeight1.text = snapshot.getString("Weight1")
                                        textWeight2.text = snapshot.getString("Weight2")
                                        textWeight3.text = snapshot.getString("Weight3")
                                        textWeight4.text = snapshot.getString("Weight4")
                                        textWeight5.text = snapshot.getString("Weight5")
                                        textWeight6.text = snapshot.getString("Weight6")
                                        textWeight7.text = snapshot.getString("Weight7")


                                        textComment1.text = snapshot.getString("Comment1")
                                        textComment2.text = snapshot.getString("Comment2")
                                        textComment3.text = snapshot.getString("Comment3")
                                        textComment4.text = snapshot.getString("Comment4")
                                        textComment5.text = snapshot.getString("Comment5")
                                        textComment6.text = snapshot.getString("Comment6")
                                        textComment7.text = snapshot.getString("Comment7")

                                        if(snapshot.getString("CheckBox1")=="true")checkBox1.isChecked= true
                                        if(snapshot.getString("CheckBox2")=="true")checkBox2.isChecked= true
                                        if(snapshot.getString("CheckBox3")=="true")checkBox3.isChecked= true
                                        if(snapshot.getString("CheckBox4")=="true")checkBox4.isChecked= true
                                        if(snapshot.getString("CheckBox5")=="true")checkBox5.isChecked= true
                                        if(snapshot.getString("CheckBox6")=="true")checkBox6.isChecked= true
                                        if(snapshot.getString("CheckBox7")=="true")checkBox7.isChecked= true

                                    } else {
                                        Toast.makeText(
                                            baseContext, "Нет данных",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        }
                    }
                    R.id.button_day3 -> {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_3")
                                .addSnapshotListener { snapshot, e ->
                                    if (e != null) {
                                        Toast.makeText(
                                            baseContext, "Считать неудалось$e",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        return@addSnapshotListener
                                    }
                                    if (snapshot != null && snapshot.exists()) {

                                        textExercise1.text = snapshot.getString("Exercise1")
                                        textExercise2.text = snapshot.getString("Exercise2")
                                        textExercise3.text = snapshot.getString("Exercise3")
                                        textExercise4.text = snapshot.getString("Exercise4")
                                        textExercise5.text = snapshot.getString("Exercise5")
                                        textExercise6.text = snapshot.getString("Exercise6")
                                        textExercise7.text = snapshot.getString("Exercise7")


                                        textPodhod1.text = snapshot.getString("Podhod1")
                                        textPodhod2.text = snapshot.getString("Podhod2")
                                        textPodhod3.text = snapshot.getString("Podhod3")
                                        textPodhod4.text = snapshot.getString("Podhod4")
                                        textPodhod5.text = snapshot.getString("Podhod5")
                                        textPodhod6.text = snapshot.getString("Podhod6")
                                        textPodhod7.text = snapshot.getString("Podhod7")


                                        textWeight1.text = snapshot.getString("Weight1")
                                        textWeight2.text = snapshot.getString("Weight2")
                                        textWeight3.text = snapshot.getString("Weight3")
                                        textWeight4.text = snapshot.getString("Weight4")
                                        textWeight5.text = snapshot.getString("Weight5")
                                        textWeight6.text = snapshot.getString("Weight6")
                                        textWeight7.text = snapshot.getString("Weight7")


                                        textComment1.text = snapshot.getString("Comment1")
                                        textComment2.text = snapshot.getString("Comment2")
                                        textComment3.text = snapshot.getString("Comment3")
                                        textComment4.text = snapshot.getString("Comment4")
                                        textComment5.text = snapshot.getString("Comment5")
                                        textComment6.text = snapshot.getString("Comment6")
                                        textComment7.text = snapshot.getString("Comment7")

                                        if(snapshot.getString("CheckBox1")=="true")checkBox1.isChecked= true
                                        if(snapshot.getString("CheckBox2")=="true")checkBox2.isChecked= true
                                        if(snapshot.getString("CheckBox3")=="true")checkBox3.isChecked= true
                                        if(snapshot.getString("CheckBox4")=="true")checkBox4.isChecked= true
                                        if(snapshot.getString("CheckBox5")=="true")checkBox5.isChecked= true
                                        if(snapshot.getString("CheckBox6")=="true")checkBox6.isChecked= true
                                        if(snapshot.getString("CheckBox7")=="true")checkBox7.isChecked= true
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
    private fun loadFirst() {
        Firebase.auth.currentUser?.uid?.let {
            ddb.collection("trainings")
                .document(it + "_1")
                .addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        Toast.makeText(
                            baseContext, "Считать неудалось$e",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@addSnapshotListener
                    }
                    if (snapshot != null && snapshot.exists()) {

                        textExercise1.text = snapshot.getString("Exercise1")
                        textExercise2.text = snapshot.getString("Exercise2")
                        textExercise3.text = snapshot.getString("Exercise3")
                        textExercise4.text = snapshot.getString("Exercise4")
                        textExercise5.text = snapshot.getString("Exercise5")
                        textExercise6.text = snapshot.getString("Exercise6")
                        textExercise7.text = snapshot.getString("Exercise7")


                        textPodhod1.text = snapshot.getString("Podhod1")
                        textPodhod2.text = snapshot.getString("Podhod2")
                        textPodhod3.text = snapshot.getString("Podhod3")
                        textPodhod4.text = snapshot.getString("Podhod4")
                        textPodhod5.text = snapshot.getString("Podhod5")
                        textPodhod6.text = snapshot.getString("Podhod6")
                        textPodhod7.text = snapshot.getString("Podhod7")


                        textWeight1.text = snapshot.getString("Weight1")
                        textWeight2.text = snapshot.getString("Weight2")
                        textWeight3.text = snapshot.getString("Weight3")
                        textWeight4.text = snapshot.getString("Weight4")
                        textWeight5.text = snapshot.getString("Weight5")
                        textWeight6.text = snapshot.getString("Weight6")
                        textWeight7.text = snapshot.getString("Weight7")


                        textComment1.text = snapshot.getString("Comment1")
                        textComment2.text = snapshot.getString("Comment2")
                        textComment3.text = snapshot.getString("Comment3")
                        textComment4.text = snapshot.getString("Comment4")
                        textComment5.text = snapshot.getString("Comment5")
                        textComment6.text = snapshot.getString("Comment6")
                        textComment7.text = snapshot.getString("Comment7")

                        if(snapshot.getString("CheckBox1")=="true")checkBox1.isChecked= true
                        if(snapshot.getString("CheckBox2")=="true")checkBox2.isChecked= true
                        if(snapshot.getString("CheckBox3")=="true")checkBox3.isChecked= true
                        if(snapshot.getString("CheckBox4")=="true")checkBox4.isChecked= true
                        if(snapshot.getString("CheckBox5")=="true")checkBox5.isChecked= true
                        if(snapshot.getString("CheckBox6")=="true")checkBox6.isChecked= true
                        if(snapshot.getString("CheckBox7")=="true")checkBox7.isChecked= true

                    } else {
                        Toast.makeText(
                            baseContext, "Нет данных",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
    private val storage = FirebaseStorage.getInstance()

    private var VideoStorage = Firebase.auth.currentUser?.uid?.let {
        storage.reference.child("video_training").child(it)
    }

    private val ddb = FirebaseFirestore.getInstance()

    fun trenSportsmenClick(view: View) {
        when (view.id) {
            R.id.button_training -> {
                val intent = Intent(this, Trainings_Sportsmen::class.java)
                startActivity(intent)
            }
            R.id.button_eats -> {
                val intent = Intent(this, Pitanie::class.java)
                startActivity(intent)
            }
            R.id.button_chats -> {
                val intent = Intent(this, Chat_Sportsmen::class.java)
                startActivity(intent)
            }
            R.id.profile -> {
                val intent = Intent(this, ProfileClient::class.java)
                startActivity(intent)
            }

            R.id.checkBox1 -> {
                if (checkBox1.isChecked) {
                    if (button_day1.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_1")
                                .update("Checkbox1", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (button_day2.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_2")
                                .update("Checkbox1", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (button_day3.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_3")
                                .update("Checkbox1", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }

                    else {
                        if (!button_day1.isChecked) {

                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("trainings")
                                    .document(it+"_1")
                                    .update("Checkbox1", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!button_day2.isChecked) {

                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("trainings")
                                    .document(it + "_2")
                                    .update("Checkbox1", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!button_day3.isChecked) {

                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("trainings")
                                    .document(it + "_3")
                                    .update("Checkbox1", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                    }
                }
            }
            R.id.checkBox2 -> {
                if (button_day1.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_1")
                            .update("Checkbox2", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (button_day2.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_2")
                            .update("Checkbox2", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (button_day3.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_3")
                            .update("Checkbox2", "true")
                            .addOnSuccessListener {
                            }
                    }
                }

                else {
                    if (!button_day1.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_1")
                                .update("Checkbox2", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!button_day2.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_2")
                                .update("Checkbox2", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!button_day3.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_3")
                                .update("Checkbox2", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                }
            }
            R.id.checkBox3 -> {
                if (button_day1.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_1")
                            .update("Checkbox3", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (button_day2.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_2")
                            .update("Checkbox3", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (button_day3.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_3")
                            .update("Checkbox3", "true")
                            .addOnSuccessListener {
                            }
                    }
                }

                else {
                    if (!button_day1.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_1")
                                .update("Checkbox3", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!button_day2.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_2")
                                .update("Checkbox3", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!button_day3.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_3")
                                .update("Checkbox3", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                }
            }
            R.id.checkBox4 -> {
                if (button_day1.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_1")
                            .update("Checkbox4", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (button_day2.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_2")
                            .update("Checkbox4", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (button_day3.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_3")
                            .update("Checkbox4", "true")
                            .addOnSuccessListener {
                            }
                    }
                }

                else {
                    if (!button_day1.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_1")
                                .update("Checkbox4", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!button_day2.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_2")
                                .update("Checkbox4", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!button_day3.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_3")
                                .update("Checkbox4", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                }
            }
            R.id.checkBox5 -> {
                if (button_day1.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_1")
                            .update("Checkbox5", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (button_day2.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_2")
                            .update("Checkbox5", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (button_day3.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_3")
                            .update("Checkbox5", "true")
                            .addOnSuccessListener {
                            }
                    }
                }

                else {
                    if (!button_day1.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_1")
                                .update("Checkbox5", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!button_day2.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_2")
                                .update("Checkbox5", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!button_day3.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_3")
                                .update("Checkbox5", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                }

            }
            R.id.checkBox6 -> {
                if (button_day1.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_1")
                            .update("Checkbox6", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (button_day2.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_2")
                            .update("Checkbox6", "true")
                            .addOnSuccessListener {
                            }
                    }
                }
                if (button_day3.isChecked) {

                    Firebase.auth.currentUser?.uid?.let {
                        ddb.collection("trainings")
                            .document(it+"_3")
                            .update("Checkbox6", "true")
                            .addOnSuccessListener {
                            }
                    }
                }

                else {
                    if (!button_day1.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_1")
                                .update("Checkbox6", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!button_day2.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_2")
                                .update("Checkbox6", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (!button_day3.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it + "_3")
                                .update("Checkbox6", "false")
                                .addOnSuccessListener {
                                }
                        }
                    }
                }

            }
            R.id.checkBox7 -> {
                if (checkBox7.isChecked) {
                    if (button_day1.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_1")
                                .update("Checkbox7", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (button_day2.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_2")
                                .update("Checkbox7", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }
                    if (button_day3.isChecked) {

                        Firebase.auth.currentUser?.uid?.let {
                            ddb.collection("trainings")
                                .document(it+"_3")
                                .update("Checkbox7", "true")
                                .addOnSuccessListener {
                                }
                        }
                    }

                    else {
                        if (!button_day1.isChecked) {

                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("trainings")
                                    .document(it+"_1")
                                    .update("Checkbox7", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!button_day2.isChecked) {

                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("trainings")
                                    .document(it + "_2")
                                    .update("Checkbox7", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                        if (!button_day3.isChecked) {

                            Firebase.auth.currentUser?.uid?.let {
                                ddb.collection("trainings")
                                    .document(it + "_3")
                                    .update("Checkbox7", "false")
                                    .addOnSuccessListener {
                                    }
                            }
                        }
                    }
                }
            }
            R.id.videoExercise1 -> {
                if (button_day1.isChecked) {
                    val vid=  VideoStorage?.child("day1")?.child("video1")
                    loadVideo(vid)
                }
                if (button_day2.isChecked) {
                    val vid=  VideoStorage?.child("day2")?.child("video1")
                    loadVideo(vid)
                }
                if (button_day3.isChecked) {
                    val vid=  VideoStorage?.child("day3")?.child("video1")
                    loadVideo(vid)
                }

            }
            R.id.videoExercise2 -> {
                if (button_day1.isChecked) {
                    val vid=  VideoStorage?.child("day1")?.child("video2")
                    loadVideo(vid)
                }
                if (button_day2.isChecked) {
                    val vid=  VideoStorage?.child("day2")?.child("video2")
                    loadVideo(vid)
                }
                if (button_day3.isChecked) {
                    val vid=  VideoStorage?.child("day3")?.child("video2")
                    loadVideo(vid)
                }

            }
            R.id.videoExercise3 -> {
                if (button_day1.isChecked) {
                    val vid=  VideoStorage?.child("day1")?.child("video3")
                    loadVideo(vid)
                }
                if (button_day2.isChecked) {
                    val vid=  VideoStorage?.child("day2")?.child("video3")
                    loadVideo(vid)
                }
                if (button_day3.isChecked) {
                    val vid=  VideoStorage?.child("day3")?.child("video3")
                    loadVideo(vid)
                }

            }
            R.id.videoExercise4 -> {
                if (button_day1.isChecked) {
                    val vid=  VideoStorage?.child("day1")?.child("video4")
                    loadVideo(vid)
                }
                if (button_day2.isChecked) {
                    val vid=  VideoStorage?.child("day2")?.child("video4")
                    loadVideo(vid)
                }
                if (button_day3.isChecked) {
                    val vid=  VideoStorage?.child("day3")?.child("video4")
                    loadVideo(vid)
                }

            }
            R.id.videoExercise5 -> {
                if (button_day1.isChecked) {
                    val vid=  VideoStorage?.child("day1")?.child("video5")
                    loadVideo(vid)
                }
                if (button_day2.isChecked) {
                    val vid=  VideoStorage?.child("day2")?.child("video5")
                    loadVideo(vid)
                }
                if (button_day3.isChecked) {
                    val vid=  VideoStorage?.child("day3")?.child("video5")
                    loadVideo(vid)
                }

            }
            R.id.videoExercise6 -> {
                if (button_day1.isChecked) {
                    val vid=  VideoStorage?.child("day1")?.child("video6")
                    loadVideo(vid)
                }
                if (button_day2.isChecked) {
                    val vid=  VideoStorage?.child("day2")?.child("video6")
                    loadVideo(vid)
                }
                if (button_day3.isChecked) {
                    val vid=  VideoStorage?.child("day3")?.child("video6")
                    loadVideo(vid)
                }

            }
            R.id.videoExercise7 -> {
                if (button_day1.isChecked) {
                    val vid=  VideoStorage?.child("day1")?.child("video7")
                    loadVideo(vid)
                }
                if (button_day2.isChecked) {
                    val vid=  VideoStorage?.child("day2")?.child("video7")
                    loadVideo(vid)
                }
                if (button_day3.isChecked) {
                    val vid=  VideoStorage?.child("day3")?.child("video7")
                    loadVideo(vid)
                }

            }

        }
    }
    /*private fun listOfVideo(){
        VideoStorage.listAll()
            .addOnSuccessListener { listResult ->
                listResult.items.forEach { item ->
                    // All the items under listRef.
                }
            }
    }*/
    private fun loadVideo(vid: StorageReference?) {
        val videoUri= Uri.parse(vid?.path)
        /*val mediaPlayer: MediaPlayer? = MediaPlayer().apply {
            setAudioStreamType(AudioManager.STREAM_MUSIC)
            setDataSource(applicationContext, videoUri)
            prepare()
            start()
        }
        videoExercise1.set(mediaPlayer)
    */
        videoExercise1.setMediaController(MediaController(this))
        videoExercise1.setVideoURI(videoUri)
        videoExercise1.start()
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}