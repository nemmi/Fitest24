package com.example.fitest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_load_trainings.*

import java.io.InputStream


class Load_Trainings : AppCompatActivity() {

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
        setContentView(R.layout.activity_load_trainings)
         val radGrp = findViewById<RadioGroup>(R.id.tableRow2);
         radGrp.setOnCheckedChangeListener { radGrp, optionId ->
             run {
                 when (optionId) {

                     R.id.button_day1 -> {
                         editExercise1.setText("")
                         editComment1.setText("")
                         editPodhods1.setText("")
                         editTakeWeight1.setText("")
                         ediExercise2.setText("")
                         editComment2.setText("")
                         editPodhods2.setText("")
                         editTakeWeight2.setText("")
                         ediExercise3.setText("")
                         editComment3.setText("")
                         editPodhods3.setText("")
                         editTakeWeight3.setText("")
                         ediExercise4.setText("")
                         editComment4.setText("")
                         editPodhods4.setText("")
                         editTakeWeight4.setText("")
                         ediExercise5.setText("")
                         editComment5.setText("")
                         editPodhods5.setText("")
                         editTakeWeight5.setText("")
                         ediExercise6.setText("")
                         editComment6.setText("")
                         editPodhods6.setText("")
                         editTakeWeight6.setText("")
                         ediExercise7.setText("")
                         editComment7.setText("")
                         editPodhods7.setText("")
                         editTakeWeight7.setText("")
                     }
                     R.id.button_day2 -> {
                         editExercise1.setText("")
                         editComment1.setText("")
                         editPodhods1.setText("")
                         editTakeWeight1.setText("")
                         ediExercise2.setText("")
                         editComment2.setText("")
                         editPodhods2.setText("")
                         editTakeWeight2.setText("")
                         ediExercise3.setText("")
                         editComment3.setText("")
                         editPodhods3.setText("")
                         editTakeWeight3.setText("")
                         ediExercise4.setText("")
                         editComment4.setText("")
                         editPodhods4.setText("")
                         editTakeWeight4.setText("")
                         ediExercise5.setText("")
                         editComment5.setText("")
                         editPodhods5.setText("")
                         editTakeWeight5.setText("")
                         ediExercise6.setText("")
                         editComment6.setText("")
                         editPodhods6.setText("")
                         editTakeWeight6.setText("")
                         ediExercise7.setText("")
                         editComment7.setText("")
                         editPodhods7.setText("")
                         editTakeWeight7.setText("")
                     }
                     R.id.button_day3 -> {
                         editExercise1.setText("")
                         editComment1.setText("")
                         editPodhods1.setText("")
                         editTakeWeight1.setText("")
                         ediExercise2.setText("")
                         editComment2.setText("")
                         editPodhods2.setText("")
                         editTakeWeight2.setText("")
                         ediExercise3.setText("")
                         editComment3.setText("")
                         editPodhods3.setText("")
                         editTakeWeight3.setText("")
                         ediExercise4.setText("")
                         editComment4.setText("")
                         editPodhods4.setText("")
                         editTakeWeight4.setText("")
                         ediExercise5.setText("")
                         editComment5.setText("")
                         editPodhods5.setText("")
                         editTakeWeight5.setText("")
                         ediExercise6.setText("")
                         editComment6.setText("")
                         editPodhods6.setText("")
                         editTakeWeight6.setText("")
                         ediExercise7.setText("")
                         editComment7.setText("")
                         editPodhods7.setText("")
                         editTakeWeight7.setText("")
                     }
                     else -> throw AssertionError()

                 }
             }
         }

    }
    private val storage = FirebaseStorage.getInstance()
    private var value = intent.getStringExtra("id")
  //  Log.i("NewActivity", value)

    private var VideoStorage = storage.reference.child("video_training").child(value).child("day1").child("video")
    val REQUEST_CODE = 100

    private val ddb = FirebaseFirestore.getInstance()

    fun loadTrenClick(view:View) {
        when (view.id){
            R.id.button_loadVideo1 ->{
                if(button_day1.isChecked){
                    VideoStorage = storage.reference.child("video_training").child(value).child("day1").child("video1")
                }
                if(button_day2.isChecked){
                    VideoStorage = storage.reference.child("video_training").child(value).child("day2").child("video1")
                }
                if(button_day3.isChecked){
                    VideoStorage = storage.reference.child("video_training").child(value).child("day3").child("video1")
                }
                chooseVideo()

            }
            R.id.button_loadVideo2 ->{
                if(button_day1.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day1").child("video2")
                }
                if(button_day2.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day2").child("video2")
                }
                if(button_day3.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day3").child("video2")
                }
                chooseVideo()
            }
            R.id.button_loadVideo3 ->{
                if(button_day1.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day1").child("video3")
                }
                if(button_day2.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day2").child("video3")
                }
                if(button_day3.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day3").child("video3")
                }
                chooseVideo()
            }
            R.id.button_loadVideo4 ->{
                if(button_day1.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day1").child("video4")
                }
                if(button_day2.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day2").child("video4")
                }
                if(button_day3.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day3").child("video4")
                }
                chooseVideo()
            }
            R.id.button_loadVideo5 ->{
                if(button_day1.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day1").child("video5")
                }
                if(button_day2.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day2").child("video5")
                }
                if(button_day3.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day3").child("video5")
                }
                chooseVideo()
            }
            R.id.button_loadVideo6 ->{
                if(button_day1.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day1").child("video6")
                }
                if(button_day2.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day2").child("video6")
                }
                if(button_day3.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day3").child("video6")
                }
                chooseVideo()
            }
            R.id.button_loadVideo7 ->{
                if(button_day1.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day1").child("video7")
                }
                if(button_day2.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day2").child("video7")
                }
                if(button_day3.isChecked){
                    VideoStorage = storage.getReference().child("video_training").child(value).child("day3").child("video7")
                }
                chooseVideo()
            }

            R.id.button_clients ->{
                startActivity(Intent(this, ListClient::class.java))
            }
            R.id.button_clients_profile ->{
                startActivity(Intent(this, ProfileClientView::class.java))
            }
            R.id.button_chat ->{
                startActivity(Intent(this, SpisocChatov::class.java))
            }
            R.id.profile ->{
                startActivity(Intent(this, ProfileClient::class.java))
            }
            R.id.buttonSave->{
                if(button_day1.isChecked) {
                    val up= ddb.collection("training")
                        .document(value + "_1") /*здесь будет айди спортсмена*/

                    if(editExercise1.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment1" ,editComment1.text.toString(),
                                "Exercise1", editExercise1.text.toString(),
                                "Podhod1",editPodhods1.text.toString(),
                                "Weight1",editTakeWeight1.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise2.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment2" ,editComment2.text.toString(),
                                "Exercise2", ediExercise2.text.toString(),
                                "Podhod2",editPodhods2.text.toString(),
                                "Weight2",editTakeWeight2.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise3.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment3" ,editComment3.text.toString(),
                                "Exercise3", ediExercise3.text.toString(),
                                "Podhod3",editPodhods3.text.toString(),
                                "Weight3",editTakeWeight3.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise4.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment4" ,editComment4.text.toString(),
                                "Exercise4", ediExercise4.text.toString(),
                                "Podhod4",editPodhods4.text.toString(),
                                "Weight4",editTakeWeight4.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise5.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment5" ,editComment5.text.toString(),
                                "Exercise5", ediExercise5.text.toString(),
                                "Podhod5",editPodhods5.text.toString(),
                                "Weight5",editTakeWeight5.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise6.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment6" ,editComment6.text.toString(),
                                "Exercise6", ediExercise6.text.toString(),
                                "Podhod6",editPodhods6.text.toString(),
                                "Weight6",editTakeWeight6.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise7.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment7" ,editComment7.text.toString(),
                                "Exercise7", ediExercise7.text.toString(),
                                "Podhod7",editPodhods7.text.toString(),
                                "Weight7",editTakeWeight7.text.toString()
                            )
                            .addOnSuccessListener {}
                    }

                    Toast.makeText(
                        baseContext, "Программа успешно загружена",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                if(button_day2.isChecked){
                    val up= ddb.collection("training")
                        .document(value + "_2") /*здесь будет айди спортсмена*/
                    if(editExercise1.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment1" ,editComment1.text.toString(),
                                "Exercise1", editExercise1.text.toString(),
                                "Podhod1",editPodhods1.text.toString(),
                                "Weight1",editTakeWeight1.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise2.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment2" ,editComment2.text.toString(),
                                "Exercise2", ediExercise2.text.toString(),
                                "Podhod2",editPodhods2.text.toString(),
                                "Weight2",editTakeWeight2.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise3.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment3" ,editComment3.text.toString(),
                                "Exercise3", ediExercise3.text.toString(),
                                "Podhod3",editPodhods3.text.toString(),
                                "Weight3",editTakeWeight3.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise4.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment4" ,editComment4.text.toString(),
                                "Exercise4", ediExercise4.text.toString(),
                                "Podhod4",editPodhods4.text.toString(),
                                "Weight4",editTakeWeight4.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise5.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment5" ,editComment5.text.toString(),
                                "Exercise5", ediExercise5.text.toString(),
                                "Podhod5",editPodhods5.text.toString(),
                                "Weight5",editTakeWeight5.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise6.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment6" ,editComment6.text.toString(),
                                "Exercise6", ediExercise6.text.toString(),
                                "Podhod6",editPodhods6.text.toString(),
                                "Weight6",editTakeWeight6.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise7.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment7" ,editComment7.text.toString(),
                                "Exercise7", ediExercise7.text.toString(),
                                "Podhod7",editPodhods7.text.toString(),
                                "Weight7",editTakeWeight7.text.toString()
                            )
                            .addOnSuccessListener {}
                    }

                    Toast.makeText(
                        baseContext, "Программа успешно загружена",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                if(button_day3.isChecked){
                    val up= ddb.collection("training")
                        .document(value + "_3") /*здесь будет айди спортсмена*/
                    if(editExercise1.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment1" ,editComment1.text.toString(),
                                "Exercise1", editExercise1.text.toString(),
                                "Podhod1",editPodhods1.text.toString(),
                                "Weight1",editTakeWeight1.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise2.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment2" ,editComment2.text.toString(),
                                "Exercise2", ediExercise2.text.toString(),
                                "Podhod2",editPodhods2.text.toString(),
                                "Weight2",editTakeWeight2.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise3.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment3" ,editComment3.text.toString(),
                                "Exercise3", ediExercise3.text.toString(),
                                "Podhod3",editPodhods3.text.toString(),
                                "Weight3",editTakeWeight3.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise4.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment4" ,editComment4.text.toString(),
                                "Exercise4", ediExercise4.text.toString(),
                                "Podhod4",editPodhods4.text.toString(),
                                "Weight4",editTakeWeight4.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise5.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment5" ,editComment5.text.toString(),
                                "Exercise5", ediExercise5.text.toString(),
                                "Podhod5",editPodhods5.text.toString(),
                                "Weight5",editTakeWeight5.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise6.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment6" ,editComment6.text.toString(),
                                "Exercise6", ediExercise6.text.toString(),
                                "Podhod6",editPodhods6.text.toString(),
                                "Weight6",editTakeWeight6.text.toString()
                            ).addOnSuccessListener {}
                    }
                    if(ediExercise7.text.toString().isNotEmpty()){
                        up
                            .update(
                                "Comment7" ,editComment7.text.toString(),
                                "Exercise7", ediExercise7.text.toString(),
                                "Podhod7",editPodhods7.text.toString(),
                                "Weight7",editTakeWeight7.text.toString()
                            )
                            .addOnSuccessListener {}
                    }

                    Toast.makeText(
                        baseContext, "Программа успешно загружена",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                editExercise1.setText("")
                editComment1.setText("")
                editPodhods1.setText("")
                editTakeWeight1.setText("")
                ediExercise2.setText("")
                editComment2.setText("")
                editPodhods2.setText("")
                editTakeWeight2.setText("")
                ediExercise3.setText("")
                editComment3.setText("")
                editPodhods3.setText("")
                editTakeWeight3.setText("")
                ediExercise4.setText("")
                editComment4.setText("")
                editPodhods4.setText("")
                editTakeWeight4.setText("")
                ediExercise5.setText("")
                editComment5.setText("")
                editPodhods5.setText("")
                editTakeWeight5.setText("")
                ediExercise6.setText("")
                editComment6.setText("")
                editPodhods6.setText("")
                editTakeWeight6.setText("")
                ediExercise7.setText("")
                editComment7.setText("")
                editPodhods7.setText("")
                editTakeWeight7.setText("")
            }

        }
    }

    private fun chooseVideo(){
        val videoPickerIntent = Intent(Intent.ACTION_PICK)
        videoPickerIntent.type = "video/*"
        startActivityForResult(videoPickerIntent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data!=null) {

            val input: InputStream? = data.data?.let { contentResolver.openInputStream(it) }
            val uploadTask = input?.let { VideoStorage.putStream(it) }

            uploadTask!!.addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(
                        applicationContext,
                        "Видео успешно загружено!",
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