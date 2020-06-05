package com.example.fitest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage

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
        /*val exercise1 = findViewById<EditText>(R.id.editExercise1)
        val podhod1 = findViewById<EditText>(R.id.editPodhods1)
        val weight1 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment1 = findViewById<EditText>(R.id.editComment1)
        val exercise2 = findViewById<EditText>(R.id.editExercise1)
        val podhod2 = findViewById<EditText>(R.id.editPodhods1)
        val weight2 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment2 = findViewById<EditText>(R.id.editComment1)
        val exercise3 = findViewById<EditText>(R.id.editExercise1)
        val podhod3 = findViewById<EditText>(R.id.editPodhods1)
        val weight3 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment3 = findViewById<EditText>(R.id.editComment1)
        val exercise4 = findViewById<EditText>(R.id.editExercise1)
        val podhod4 = findViewById<EditText>(R.id.editPodhods1)
        val weight4 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment4 = findViewById<EditText>(R.id.editComment1)
        val exercise5 = findViewById<EditText>(R.id.editExercise1)
        val podhod5 = findViewById<EditText>(R.id.editPodhods1)
        val weight5 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment5 = findViewById<EditText>(R.id.editComment1)
        val exercise6 = findViewById<EditText>(R.id.editExercise1)
        val podhod6 = findViewById<EditText>(R.id.editPodhods1)
        val weight6 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment6 = findViewById<EditText>(R.id.editComment1)
        val exercise7 = findViewById<EditText>(R.id.editExercise1)
        val podhod7 = findViewById<EditText>(R.id.editPodhods1)
        val weight7 = findViewById<EditText>(R.id.editTakeWeight1)
        val comment7 = findViewById<EditText>(R.id.editComment1)

       */

    }
   private val storage = FirebaseStorage.getInstance()
    private var VideoStorage = storage.reference.child("video_training").child("day1").child("video")
    val REQUEST_CODE = 100


   fun loadTrenClick(view:View) {
        when (view.id){
            R.id.button_loadVideo1 ->{
                var detected: Boolean =true

                if(!detected) {
                    chooseVideo()
                    detected=true
                }
                else {
                    deleteVideo()
                    detected=false
                }

                    }
            R.id.button_loadVideo2 ->{
                var detected: Boolean =true

                if(!detected) {
                    chooseVideo()
                    detected=true
                }
                else {
                    deleteVideo()
                    detected=false
                }
                    }
            R.id.button_loadVideo3 ->{
                var detected: Boolean =true

                if(!detected) {
                    chooseVideo()
                    detected=true
                }
                else {
                    deleteVideo()
                    detected=false
                }
                    }
            R.id.button_loadVideo4 ->{
                var detected: Boolean =true

                if(!detected) {
                    chooseVideo()
                    detected=true
                }
                else {
                    deleteVideo()
                    detected=false
                }
                   }
            R.id.button_loadVideo5 ->{
                var detected: Boolean =true

                if(!detected) {
                    chooseVideo()
                    detected=true
                }
                else {
                    deleteVideo()
                    detected=false
                }
                    }
            R.id.button_loadVideo6 ->{
                var detected: Boolean =true

                if(!detected) {
                    chooseVideo()
                    detected=true
                }
                else {
                    deleteVideo()
                    detected=false
                }
                   }
            R.id.button_loadVideo7 ->{
                var detected: Boolean =true

                if(!detected) {
                    chooseVideo()
                    detected=true
                }
                else {
                    deleteVideo()
                    detected=false
                }
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
            R.id.button_day1 ->{
                VideoStorage = storage.getReference().child("video_training").child("day1").child("video")
            }
            R.id.button_day2 ->{
                VideoStorage = storage.getReference().child("video_training").child("day2").child("video")
            }
            R.id.button_day3 ->{
                VideoStorage = storage.getReference().child("video_training").child("day3").child("video")
            }
        }
    }
    private fun deleteVideo(){
        VideoStorage.delete().addOnSuccessListener {
            chooseVideo()
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

            val input: InputStream? = data!!.data?.let { contentResolver.openInputStream(it) }
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