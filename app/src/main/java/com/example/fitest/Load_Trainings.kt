package com.example.fitest

import android.R.attr
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage

import java.io.File
import java.io.FileInputStream
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
    val storage = FirebaseStorage.getInstance()
    var VideoStorage = storage.getReference().child("video_training").child("day1").child("video")
    val REQUEST_CODE = 100
   fun loadTrenClick(view:View) {
        when (view.id){
            R.id.button_loadVideo1 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                    }
            R.id.button_loadVideo2 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                    }
            R.id.button_loadVideo3 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                    }
            R.id.button_loadVideo4 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                   }
            R.id.button_loadVideo5 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                    }
            R.id.button_loadVideo6 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                   }
            R.id.button_loadVideo7 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                   }
            R.id.button_clients ->{
                val intent = Intent(this, ListClient::class.java)
                startActivity(intent)
            }
            R.id.button_clients_profile ->{
                val intent = Intent(this, ProfileClientView::class.java)
                startActivity(intent)
            }
            R.id.button_chat ->{
                val intent = Intent(this, SpisocChatov::class.java)
                startActivity(intent)
            }
            R.id.profile ->{
                val intent = Intent(this, ProfileClient::class.java)
                startActivity(intent)
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