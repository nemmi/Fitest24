package com.example.fitest

import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_trainings.*


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
        setContentView(R.layout.activity_trainings)
        loadVideo()
    }
    private val storage = FirebaseStorage.getInstance()
    private var VideoStorage = storage.reference.child("video_training").child("test_week").child("2020-05-29-13-07-09-2754.mp4")

        fun trenSportsmenClick(view: View) {
            when (view.id){
                R.id.button_training ->{
                    val intent = Intent(this, Trainings_Sportsmen::class.java)
                    startActivity(intent)
                }
                R.id.button_eats ->{
                    val intent = Intent(this, Anketa_Coach::class.java)
                    startActivity(intent)
                }
                R.id.button_chats ->{
                    val intent = Intent(this, Chat_Sportsmen::class.java)
                    startActivity(intent)
                }
                R.id.profile ->{
                    val intent = Intent(this, ProfileClient::class.java)
                    startActivity(intent)
                }
                R.id.button_day1 ->{

                }
                R.id.button_day2 ->{

                }
                R.id.button_day3 ->{

                }
                R.id.videoExercise1 ->{}
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
   private fun loadVideo(){
        val videoUri= Uri.parse(VideoStorage.path)
        videoExercise1.setMediaController(MediaController(this))
        videoExercise1.setVideoURI(videoUri)
        videoExercise1.start()

    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}