package com.example.fitest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.VideoView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

import kotlinx.android.synthetic.main.activity_trainings.*
import kotlinx.android.synthetic.main.activity_trainings.buttonDay1
import kotlinx.android.synthetic.main.activity_trainings.buttonDay2
import kotlinx.android.synthetic.main.activity_trainings.buttonDay3
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
import java.io.File


class TrainingsSportsman : AppCompatActivity() {

    var mondayChek1 = false
    var mondayChek2 = false
    var mondayChek3 = false
    var mondayChek4 = false
    var mondayChek5 = false
    var mondayChek6 = false
    var mondayChek7 = false

    var tuesdayChek2 = false
    var tuesdayChek1 = false
    var tuesdayChek3 = false
    var tuesdayChek5 = false
    var tuesdayChek4 = false
    var tuesdayChek6 = false
    var tuesdayChek7 = false

    var wednesdayChek1 = false
    var wednesdayChek2 = false
    var wednesdayChek3 = false
    var wednesdayChek4 = false
    var wednesdayChek5 = false
    var wednesdayChek6 = false
    var wednesdayChek7 = false

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
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_trainings)
        //   horizontalScrollView.fullScroll(ScrollView.FOCUS_LEFT)
        val radGrp = findViewById<RadioGroup>(R.id.radioGroup);
        loadFirst("_1")
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    when (optionId) {
                        R.id.buttonDay1 -> {
                            CheckThisOut(mondayChek1, mondayChek2, mondayChek3, mondayChek4, mondayChek5, mondayChek6, mondayChek7)
                            loadFirst("_1")

                        }
                        R.id.buttonDay2 -> {
                            loadFirst("_2")
                            CheckThisOut(tuesdayChek1, tuesdayChek2, tuesdayChek3, tuesdayChek4, tuesdayChek5, tuesdayChek6, tuesdayChek7)
                        }
                        R.id.buttonDay3 -> {
                            loadFirst("_3")
                            CheckThisOut(wednesdayChek1, wednesdayChek2, wednesdayChek3, wednesdayChek4, wednesdayChek5, wednesdayChek6, wednesdayChek7)
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
    private fun loadFirst(chek:String) {
        Firebase.auth.currentUser?.uid?.let {
            ddb.collection("trainings")
                .document(it + chek)
                .addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        Toast.makeText(
                            baseContext, resources.getString(R.string.error_base),
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

                    } else {
                        Toast.makeText(
                            baseContext, resources.getString(R.string.error_empty_base),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
    private val storage = FirebaseStorage.getInstance()

    private val ddb = FirebaseFirestore.getInstance()

    fun trenSportsmenClick(view: View) {
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {
                R.id.buttonTraining -> {
                    val intent = Intent(this, TrainingsSportsman::class.java)
                    startActivity(intent)
                }
                R.id.buttonEats -> {
                    val intent = Intent(this, Eat::class.java)
                    startActivity(intent)
                }
                R.id.buttonChats -> {
                    val intent = Intent(this, ChatSportsman::class.java)
                    startActivity(intent)
                }
                R.id.profile -> {
                    val intent = Intent(this, ProfileClient::class.java)
                    startActivity(intent)
                }

                R.id.checkBox1 -> {

                    if (buttonDay1.isChecked) {

                        mondayChek1 = checkBox1.isChecked
                        CheckID("_1", "Checkbox1", mondayChek1.toString())


                    }
                    if (buttonDay2.isChecked) {

                        tuesdayChek1 = checkBox1.isChecked
                        CheckID("_2", "Checkbox1", tuesdayChek1.toString())
                    }
                    if (buttonDay3.isChecked) {

                        wednesdayChek1 = checkBox1.isChecked
                        CheckID("_3", "Checkbox1", wednesdayChek1.toString())
                    }

                }

                R.id.checkBox2 -> {
                    if (buttonDay1.isChecked) {

                        mondayChek2 = checkBox2.isChecked
                        CheckID("_1", "Checkbox2", mondayChek2.toString())
                    }
                    if (buttonDay2.isChecked) {

                        tuesdayChek2 = checkBox2.isChecked
                        CheckID("_2", "Checkbox2", tuesdayChek2.toString())
                    }
                    if (buttonDay3.isChecked) {

                        wednesdayChek2 = checkBox2.isChecked
                        CheckID("_3", "Checkbox2", wednesdayChek2.toString())
                    }

                }
                R.id.checkBox3 -> {
                    if (buttonDay1.isChecked) {

                        mondayChek3 = checkBox3.isChecked
                        CheckID("_1", "Checkbox3", mondayChek3.toString())
                    }
                    if (buttonDay2.isChecked) {

                        tuesdayChek3 = checkBox3.isChecked
                        CheckID("_2", "Checkbox3", tuesdayChek3.toString())
                    }
                    if (buttonDay3.isChecked) {

                        wednesdayChek3 = checkBox3.isChecked
                        CheckID("_3", "Checkbox3", wednesdayChek3.toString())
                    }

                }
                R.id.checkBox4 -> {
                    if (buttonDay1.isChecked) {

                        mondayChek4 = checkBox4.isChecked
                        CheckID("_1", "Checkbox4", mondayChek4.toString())
                    }
                    if (buttonDay2.isChecked) {

                        tuesdayChek4 = checkBox4.isChecked
                        CheckID("_2", "Checkbox4", tuesdayChek4.toString())
                    }
                    if (buttonDay3.isChecked) {

                        wednesdayChek4 = checkBox4.isChecked
                        CheckID("_3", "Checkbox4", wednesdayChek4.toString())
                    }

                }
                R.id.checkBox5 -> {
                    if (buttonDay1.isChecked) {

                        mondayChek5 = checkBox5.isChecked
                        CheckID("_1", "Checkbox5", mondayChek5.toString())
                    }
                    if (buttonDay2.isChecked) {

                        tuesdayChek5 = checkBox5.isChecked
                        CheckID("_2", "Checkbox5", tuesdayChek5.toString())
                    }
                    if (buttonDay3.isChecked) {

                        wednesdayChek5 = checkBox5.isChecked
                        CheckID("_3", "Checkbox5", wednesdayChek5.toString())
                    }

                }
                R.id.checkBox6 -> {
                    if (buttonDay1.isChecked) {

                        mondayChek6 = checkBox6.isChecked
                        CheckID("_1", "Checkbox6", mondayChek6.toString())
                    }
                    if (buttonDay2.isChecked) {

                        tuesdayChek6 = checkBox6.isChecked
                        CheckID("_2", "Checkbox6", tuesdayChek6.toString())
                    }
                    if (buttonDay3.isChecked) {

                        wednesdayChek6 = checkBox6.isChecked
                        CheckID("_3", "Checkbox6", wednesdayChek6.toString())
                    }

                }
                R.id.checkBox7 -> {

                    if (buttonDay1.isChecked) {

                        mondayChek7 = checkBox7.isChecked
                        CheckID("_1", "Checkbox7", mondayChek7.toString())
                    }
                    if (buttonDay2.isChecked) {

                        tuesdayChek7 = checkBox7.isChecked
                        CheckID("_2", "Checkbox7", tuesdayChek7.toString())
                    }
                    if (buttonDay3.isChecked) {

                        wednesdayChek7 = checkBox7.isChecked
                        CheckID("_3", "Checkbox7", wednesdayChek7.toString())
                    }
                }
                R.id.videoExercise1 -> {

                    if (textExercise1.text.toString().isNotEmpty()) {
                        val vid = textExercise1.text.toString()
                        loadVideo(vid, videoExercise1)
                    }
                }
                R.id.videoExercise2 -> {

                    if (textExercise2.text.toString().isNotEmpty()) {
                        val vid = textExercise2.text.toString()
                        loadVideo(vid, videoExercise2)
                    }

                }
                R.id.videoExercise3 -> {

                    if (textExercise3.text.toString().isNotEmpty()) {
                        val vid = textExercise3.text.toString()
                        loadVideo(vid, videoExercise3)
                    }

                }
                R.id.videoExercise4 -> {

                    if (textExercise4.text.toString().isNotEmpty()) {
                        val vid = textExercise4.text.toString()
                        loadVideo(vid, videoExercise4)
                    }

                }
                R.id.videoExercise5 -> {

                    if (textExercise5.text.toString().isNotEmpty()) {
                        val vid = textExercise5.text.toString()
                        loadVideo(vid, videoExercise5)
                    }

                }
                R.id.videoExercise6 -> {

                    if (textExercise6.text.toString().isNotEmpty()) {
                        val vid = textExercise6.text.toString()
                        loadVideo(vid, videoExercise6)
                    }

                }
                R.id.videoExercise7 -> {

                    if (textExercise7.text.toString().isNotEmpty()) {
                        val vid = textExercise7.text.toString()
                        loadVideo(vid, videoExercise7)
                    }

                }

            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun loadVideo(vid: String, exers: VideoView) {

        if(buttonDay1.isChecked) {
            loadVideoInDay(vid,exers,"_1")
        }

        if(buttonDay2.isChecked) {
            loadVideoInDay(vid,exers,"_2")
        }

        if(buttonDay3.isChecked) {
            loadVideoInDay(vid,exers,"_3")
        }

    }
    private fun loadVideoInDay(vid: String, exers: VideoView, day: String){
        Firebase.auth.currentUser?.uid?.let {
            ddb.collection("trainings")
                .document(it + day)
                .addSnapshotListener { snapshot, e ->
                    if (snapshot?.get("test_week") == true) {
                        Toast.makeText(
                            baseContext,
                            resources.getString(R.string.message_about_video),
                            Toast.LENGTH_SHORT
                        ).show()

                        var videoStorage = Firebase.auth.currentUser?.uid?.let {
                            storage.reference.child("video_training").child("test_week")
                                .child("2020-05-29-13-30-27-1061.mp4")
                        }
                        val localFile = File.createTempFile("video", "mp4")

                        videoStorage?.getFile(localFile)?.addOnSuccessListener {

                            val videoUri = Uri.fromFile(localFile)
                            exers.setVideoURI(videoUri)
                            exers.start()

                        }?.addOnFailureListener { e ->
                            Toast.makeText(
                                baseContext, resources.getString(R.string.message_unsuccess) + e.localizedMessage,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        var videoStorage = Firebase.auth.currentUser?.uid?.let {
                            storage.reference.child("video_training").child(it).child(vid)
                        }
                        val localFile = File.createTempFile("video", "mp4")

                        videoStorage?.getFile(localFile)?.addOnSuccessListener {

                            val videoUri = Uri.fromFile(localFile)
                            exers.setVideoURI(videoUri)
                            exers.start()

                        }?.addOnFailureListener { e ->
                            Toast.makeText(
                                baseContext, resources.getString(R.string.message_unsuccess) + e.localizedMessage,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
        }
    }

    private fun CheckID(day:String, checkbox:String, daycheck:String){
        Firebase.auth.currentUser?.uid?.let {
            ddb.collection("trainings")
                .document(it+day)
                .update(checkbox, daycheck)
                .addOnSuccessListener {
                }
        }


    }

    private fun CheckThisOut(Chek1:Boolean, Chek2:Boolean, Chek3:Boolean, Chek4:Boolean, Chek5:Boolean, Chek6:Boolean, Chek7:Boolean){
        checkBox1.isChecked= false
        checkBox2.isChecked= false
        checkBox3.isChecked= false
        checkBox4.isChecked= false
        checkBox5.isChecked= false
        checkBox6.isChecked= false
        checkBox7.isChecked= false

        if(Chek1 == true) checkBox1.isChecked=true
        if(Chek2 == true) checkBox2.isChecked=true
        if(Chek3 == true) checkBox3.isChecked=true
        if(Chek4 == true) checkBox4.isChecked=true
        if(Chek5 == true) checkBox5.isChecked=true
        if(Chek6 == true) checkBox6.isChecked=true
        if(Chek7 == true) checkBox6.isChecked=true
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