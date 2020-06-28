package com.example.fitest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.Toast
import android.widget.VideoView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

import kotlinx.android.synthetic.main.activity_trainings.*
import kotlinx.android.synthetic.main.activity_trainings.button_day1
import kotlinx.android.synthetic.main.activity_trainings.button_day2
import kotlinx.android.synthetic.main.activity_trainings.button_day3
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
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_trainings)
     //   horizontalScrollView.fullScroll(ScrollView.FOCUS_LEFT)
        val radGrp = findViewById<RadioGroup>(R.id.radioGroup);
        loadFirst("_1")
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                when (optionId) {
                    R.id.button_day1 -> {
                        loadFirst("_1")
                    }
                    R.id.button_day2 -> {
                        loadFirst("_2")
                    }
                    R.id.button_day3 -> {
                        loadFirst("_3")
                    }
                    else -> throw AssertionError()
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
                            baseContext, "Нет данных",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
    private val storage = FirebaseStorage.getInstance()

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

                if(textExercise1.text.toString().isNotEmpty()) {
                    val vid = textExercise1.text.toString()
                    loadVideo(vid, videoExercise1)
                }
            }
            R.id.videoExercise2 -> {

                if(textExercise2.text.toString().isNotEmpty()) {
                    val vid = textExercise2.text.toString()
                    loadVideo(vid, videoExercise2)
                }

            }
            R.id.videoExercise3 -> {

                if(textExercise3.text.toString().isNotEmpty()) {
                    val vid = textExercise3.text.toString()
                    loadVideo(vid, videoExercise3)
                }

            }
            R.id.videoExercise4 -> {

                if(textExercise4.text.toString().isNotEmpty()) {
                    val vid = textExercise4.text.toString()
                    loadVideo(vid, videoExercise4)
                }

            }
            R.id.videoExercise5 -> {

                if(textExercise5.text.toString().isNotEmpty()) {
                    val vid = textExercise5.text.toString()
                    loadVideo(vid, videoExercise5)
                }

            }
            R.id.videoExercise6 -> {

                if(textExercise6.text.toString().isNotEmpty()) {
                    val vid = textExercise6.text.toString()
                    loadVideo(vid, videoExercise6)
                }

            }
            R.id.videoExercise7 -> {

                if(textExercise7.text.toString().isNotEmpty()) {
                    val vid = textExercise7.text.toString()
                    loadVideo(vid, videoExercise7)
                }

            }

        }
    }

    private fun loadVideo(vid: String, exers: VideoView) {
        if(button_day1.isChecked) {
            Firebase.auth.currentUser?.uid?.let {
                ddb.collection("trainings")
                    .document(it + "_1")
                    .addSnapshotListener { snapshot, e ->
                        if (snapshot?.get("test_week") == true) {
                            Toast.makeText(
                                baseContext,
                                "Это тестовое видео, до загрузки упражнений тренером, оно одно на все упражнения этого дня.",
                                Toast.LENGTH_SHORT
                            ).show()

                            var VideoStorage = Firebase.auth.currentUser?.uid?.let {
                                storage.reference.child("video_training").child("test_week")
                                    .child("2020-05-29-13-07-09-2754.mp4")
                            }
                            val localFile = File.createTempFile("video", "mp4")

                            VideoStorage?.getFile(localFile)?.addOnSuccessListener {

                                val videoUri = Uri.fromFile(localFile)
                                exers.setVideoURI(videoUri)
                                exers.start()

                            }?.addOnFailureListener { e ->
                                Toast.makeText(
                                    baseContext, "Неудачно " + e.localizedMessage,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            var VideoStorage = Firebase.auth.currentUser?.uid?.let {
                                storage.reference.child("video_training").child(it).child(vid)
                            }
                            val localFile = File.createTempFile("video", "mp4")

                            VideoStorage?.getFile(localFile)?.addOnSuccessListener {

                                val videoUri = Uri.fromFile(localFile)
                                exers.setVideoURI(videoUri)
                                exers.start()

                            }?.addOnFailureListener { e ->
                                Toast.makeText(
                                    baseContext, "Неудачно " + e.localizedMessage,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
            }
        }

        if(button_day2.isChecked) {
            Firebase.auth.currentUser?.uid?.let {
                ddb.collection("trainings")
                    .document(it + "_2")
                    .addSnapshotListener { snapshot, e ->
                        if (snapshot?.get("test_week") == true) {
                            Toast.makeText(
                                baseContext,
                                "Это тестовое видео, до загрузки упражнений тренером, оно одно на все упражнения этого дня.",
                                Toast.LENGTH_SHORT
                            ).show()

                            var VideoStorage = Firebase.auth.currentUser?.uid?.let {
                                storage.reference.child("video_training").child("test_week")
                                    .child("2020-05-29-13-31-17-6499.mp4")
                            }
                            val localFile = File.createTempFile("video", "mp4")

                            VideoStorage?.getFile(localFile)?.addOnSuccessListener {

                                val videoUri = Uri.fromFile(localFile)
                                exers.setVideoURI(videoUri)
                                exers.start()

                            }?.addOnFailureListener { e ->
                                Toast.makeText(
                                    baseContext, "Неудачно " + e.localizedMessage,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            var VideoStorage = Firebase.auth.currentUser?.uid?.let {
                                storage.reference.child("video_training").child(it).child(vid)
                            }
                            val localFile = File.createTempFile("video", "mp4")

                            VideoStorage?.getFile(localFile)?.addOnSuccessListener {

                                val videoUri = Uri.fromFile(localFile)
                                exers.setVideoURI(videoUri)
                                exers.start()

                            }?.addOnFailureListener { e ->
                                Toast.makeText(
                                    baseContext, "Неудачно " + e.localizedMessage,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
            }
        }

        if(button_day3.isChecked) {
            Firebase.auth.currentUser?.uid?.let {
                ddb.collection("trainings")
                    .document(it + "_3")
                    .addSnapshotListener { snapshot, e ->
                        if (snapshot?.get("test_week") == true) {
                            Toast.makeText(
                                baseContext,
                                "Это тестовое видео, до загрузки упражнений тренером, оно одно на все упражнения  этого дня.",
                                Toast.LENGTH_SHORT
                            ).show()

                            var VideoStorage = Firebase.auth.currentUser?.uid?.let {
                                storage.reference.child("video_training").child("test_week")
                                    .child("2020-05-29-13-30-27-1061.mp4")
                            }
                            val localFile = File.createTempFile("video", "mp4")

                            VideoStorage?.getFile(localFile)?.addOnSuccessListener {

                                val videoUri = Uri.fromFile(localFile)
                                exers.setVideoURI(videoUri)
                                exers.start()

                            }?.addOnFailureListener { e ->
                                Toast.makeText(
                                    baseContext, "Неудачно " + e.localizedMessage,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            var VideoStorage = Firebase.auth.currentUser?.uid?.let {
                                storage.reference.child("video_training").child(it).child(vid)
                            }
                            val localFile = File.createTempFile("video", "mp4")

                            VideoStorage?.getFile(localFile)?.addOnSuccessListener {

                                val videoUri = Uri.fromFile(localFile)
                                exers.setVideoURI(videoUri)
                                exers.start()

                            }?.addOnFailureListener { e ->
                                Toast.makeText(
                                    baseContext, "Неудачно " + e.localizedMessage,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
            }
        }


        // val videoUri= Uri.parse(vid?.path)



    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}