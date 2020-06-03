package com.example.fitest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_trainings.*

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
        val exercise1 = findViewById<EditText>(R.id.editExercise1)
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
        val profile = findViewById<Button>(R.id.profile)
        val day1 = findViewById<Button>(R.id.button_day1)
        val day2 = findViewById<Button>(R.id.button_day2)
        val day3 = findViewById<Button>(R.id.button_day3)
        val save = findViewById<Button>(R.id.button_save)
        val loadV1 = findViewById<Button>(R.id.button_loadVideo1)
        val loadV2 = findViewById<Button>(R.id.button_loadVideo2)
        val loadV3 = findViewById<Button>(R.id.button_loadVideo3)
        val loadV4 = findViewById<Button>(R.id.button_loadVideo4)
        val loadV5 = findViewById<Button>(R.id.button_loadVideo5)
        val loadV6 = findViewById<Button>(R.id.button_loadVideo6)
        val loadV7 = findViewById<Button>(R.id.button_loadVideo7)
        val clients = findViewById<Button>(R.id.button_clients)
        val clientsProfile = findViewById<Button>(R.id.button_clients_profile)
        val chat = findViewById<Button>(R.id.button_chat)
        val storage = FirebaseStorage.getInstance()
        val VideoStorage = storage.getReference().child("video")
    }

    val REQUEST_CODE = 100
   fun loadTrenClick(view:View) {
        when (view.id){
            R.id.button_loadVideo1 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                Toast.makeText(applicationContext, "Видео успешно загружено!", Toast.LENGTH_SHORT).show()
            }
            R.id.button_loadVideo2 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                Toast.makeText(applicationContext, "Видео успешно загружено!", Toast.LENGTH_SHORT).show()
            }
            R.id.button_loadVideo3 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                Toast.makeText(applicationContext, "Видео успешно загружено!", Toast.LENGTH_SHORT).show()
            }
            R.id.button_loadVideo4 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                Toast.makeText(applicationContext, "Видео успешно загружено!", Toast.LENGTH_SHORT).show()
            }
            R.id.button_loadVideo5 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                Toast.makeText(applicationContext, "Видео успешно загружено!", Toast.LENGTH_SHORT).show()
            }
            R.id.button_loadVideo6 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                Toast.makeText(applicationContext, "Видео успешно загружено!", Toast.LENGTH_SHORT).show()
            }
            R.id.button_loadVideo7 ->{
                val videoPickerIntent = Intent(Intent.ACTION_PICK)
                videoPickerIntent.type = "video/*"
                startActivityForResult(videoPickerIntent, REQUEST_CODE)
                Toast.makeText(applicationContext, "Видео успешно загружено!", Toast.LENGTH_SHORT).show()
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

            }
            R.id.button_day2 ->{

            }
            R.id.button_day3 ->{

            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            videoExercise1.setVideoURI(data?.data) // handle chosen image
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}