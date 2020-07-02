package com.example.fitest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_load_trainings.*
import kotlinx.android.synthetic.main.activity_load_trainings.buttonDay1
import kotlinx.android.synthetic.main.activity_load_trainings.buttonDay2
import kotlinx.android.synthetic.main.activity_load_trainings.buttonDay3

import java.io.InputStream


class LoadTrainings : AppCompatActivity() {

    private val storage: FirebaseStorage by lazy { FirebaseStorage.getInstance() }


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
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_load_trainings)

        var value = intent.getStringExtra("id")
        buttonSave.setOnClickListener {
            if (IsInternetAvailable.isInternetAvailable(this)) {
                if (buttonDay1.isChecked) {
                    loadData(value,"_1")

                }
                if (buttonDay2.isChecked) {
                    loadData(value,"_2")

                }
                if (buttonDay3.isChecked) {
                    loadData(value,"_3")

                }

            } else {
                alert()
                startActivity(Intent(this, MainActivity::class.java))
            }

        }
        /*val radGrp = findViewById<RadioGroup>(R.id.radioGroup);
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run { if (IsInternetAvailable.isInternetAvailable(this)) {

                when (optionId) {
                    R.id.buttonDay1 -> {
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
                    R.id.buttonDay2 -> {
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
                    R.id.buttonDay3 -> {
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
            } else {
                alert()
                startActivity(Intent(this, MainActivity::class.java))
            }

        }
        }*/

    }

    val REQUEST_CODE = 100

    private val ddb = FirebaseFirestore.getInstance()

    fun loadTrenClick(view:View) {
        if (IsInternetAvailable.isInternetAvailable(this)) {
            var value= intent.getStringExtra("id")
            when (view.id){
                R.id.buttonLoadVideo1 ->{
                    loadEx(editExercise1)
                }
                R.id.buttonLoadVideo2 ->{
                    loadEx(ediExercise2)
                }
                R.id.buttonLoadVideo3 ->{
                    loadEx(ediExercise3)
                }
                R.id.buttonLoadVideo4 ->{
                    loadEx(ediExercise4)
                }
                R.id.buttonLoadVideo5 ->{
                    loadEx(ediExercise5)
                }
                R.id.buttonLoadVideo6 ->{
                    loadEx(ediExercise6)
                }
                R.id.buttonLoadVideo7 ->{
                    loadEx(ediExercise7)
                }


                R.id.buttonClients ->{
                    startActivity(Intent(this, ListClient::class.java))
                }
                R.id.buttonClientsProfile ->{
                    val intent = Intent(this, ProfileClientView::class.java)
                    Log.i("DocId", value)
                    intent.putExtra("id", value)
                    Log.i("Intent", value)

                    startActivity(intent)
                }
                R.id.buttonChat ->{
                    startActivity(Intent(this, SpisocChatov::class.java))
                }
                R.id.profile ->{
                    startActivity(Intent(this, ProfileTrainer::class.java))
                }

            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun loadData(value:String,day:String){
        val up = ddb.collection("trainings")
            .document(value + day)

        if (editExercise1.text.toString().isNotEmpty()) {
            up
                .update(
                    "Comment1", editComment1.text.toString(),
                    "Exercise1", editExercise1.text.toString(),
                    "Podhod1", editPodhods1.text.toString(),
                    "Weight1", editTakeWeight1.text.toString(),
                    "test_week", false
                ).addOnSuccessListener {}
        } else {
            editExercise1.error = "Введите упражнение"
            editExercise1.requestFocus()
        }
        if (ediExercise2.text.toString().isNotEmpty()) {
            up
                .update(
                    "Comment2", editComment2.text.toString(),
                    "Exercise2", ediExercise2.text.toString(),
                    "Podhod2", editPodhods2.text.toString(),
                    "Weight2", editTakeWeight2.text.toString()
                ).addOnSuccessListener {}
        } else {
            ediExercise2.error = "Введите упражнение"
            ediExercise2.requestFocus()
        }
        if (ediExercise3.text.toString().isNotEmpty()) {
            up
                .update(
                    "Comment3", editComment3.text.toString(),
                    "Exercise3", ediExercise3.text.toString(),
                    "Podhod3", editPodhods3.text.toString(),
                    "Weight3", editTakeWeight3.text.toString()
                ).addOnSuccessListener {}
        } else {
            ediExercise3.error = "Введите упражнение"
            ediExercise3.requestFocus()
        }
        if (ediExercise4.text.toString().isNotEmpty()) {
            up
                .update(
                    "Comment4", editComment4.text.toString(),
                    "Exercise4", ediExercise4.text.toString(),
                    "Podhod4", editPodhods4.text.toString(),
                    "Weight4", editTakeWeight4.text.toString()
                ).addOnSuccessListener {}
        } else {
            up
                .update(
                    "Comment4", "",
                    "Exercise4", "",
                    "Podhod4", "",
                    "Weight4", ""
                ).addOnSuccessListener {}
        }
        if (ediExercise5.text.toString().isNotEmpty()) {
            up
                .update(
                    "Comment5", editComment5.text.toString(),
                    "Exercise5", ediExercise5.text.toString(),
                    "Podhod5", editPodhods5.text.toString(),
                    "Weight5", editTakeWeight5.text.toString()
                ).addOnSuccessListener {}
        } else {
            up
                .update(
                    "Comment5", "",
                    "Exercise5", "",
                    "Podhod5", "",
                    "Weight5", ""
                ).addOnSuccessListener {}
        }
        if (ediExercise6.text.toString().isNotEmpty()) {
            up
                .update(
                    "Comment6", editComment6.text.toString(),
                    "Exercise6", ediExercise6.text.toString(),
                    "Podhod6", editPodhods6.text.toString(),
                    "Weight6", editTakeWeight6.text.toString()
                ).addOnSuccessListener {}
        } else {
            up
                .update(
                    "Comment6", "",
                    "Exercise6", "",
                    "Podhod6", "",
                    "Weight6", ""
                ).addOnSuccessListener {}
        }
        if (ediExercise7.text.toString().isNotEmpty()) {
            up
                .update(
                    "Comment7", editComment7.text.toString(),
                    "Exercise7", ediExercise7.text.toString(),
                    "Podhod7", editPodhods7.text.toString(),
                    "Weight7", editTakeWeight7.text.toString()
                )
                .addOnSuccessListener {}
        } else {
            up
                .update(
                    "Comment7", "",
                    "Exercise7", "",
                    "Podhod7", "",
                    "Weight7", ""
                )
                .addOnSuccessListener {}
        }

        Toast.makeText(
            baseContext, "Программа успешно загружена",
            Toast.LENGTH_SHORT
        ).show()
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
    private fun loadEx(exer: EditText) {
        if(exer.text.toString().isNotEmpty()) {
            chooseVideo()
        }
        else
        {
            Toast.makeText(
                baseContext,  resources.getString(R.string.error_valid_for_empty_field),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    private fun chooseVideo() {
        val videoPickerIntent = Intent(Intent.ACTION_PICK)
        videoPickerIntent.type = "video/*"

        startActivityForResult(videoPickerIntent, REQUEST_CODE)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data!=null) {
            var value = intent.getStringExtra("id")
            var ex:String

            if(buttonLoadVideo1.isChecked)  {
                ex = editExercise1.text.toString()
                video(data,value,ex)
            }

            if(buttonLoadVideo2.isChecked)  {
                ex = ediExercise2.text.toString()
                video(data,value,ex)
            }

            if(buttonLoadVideo3.isChecked)  {
                ex = ediExercise3.text.toString()
                video(data,value,ex)
            }
            if(buttonLoadVideo4.isChecked)  {
                ex = ediExercise4.text.toString()
                video(data,value,ex)
            }

            if(buttonLoadVideo5.isChecked)  {
                ex = ediExercise5.text.toString()
                video(data,value,ex)
            }
            if(buttonLoadVideo6.isChecked)  {
                ex = ediExercise6.text.toString()
                video(data,value,ex)
            }
            if(buttonLoadVideo7.isChecked)  {
                ex = ediExercise7.text.toString()
                video(data,value,ex)
            }

        }
    }
    private fun video(data: Intent?, value: String, ex: String){
        val videoStorage = storage.reference.child("video_training").child(value).child(ex)
        val input: InputStream? = data?.data?.let { contentResolver.openInputStream(it) }
        val uploadTask = input?.let { videoStorage.putStream(it) }
        uploadTask!!.addOnProgressListener { taskSnapshot ->
            val progress = (100.0 * taskSnapshot.bytesTransferred) / taskSnapshot.totalByteCount
            println("Upload is $progress% done")
        }
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(
                        applicationContext,
                        resources.getString(R.string.message_success),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
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