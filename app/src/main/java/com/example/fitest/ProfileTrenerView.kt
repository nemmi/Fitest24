package com.example.fitest

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.fitest.Model.User

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.activity_profile_client.*
import kotlinx.android.synthetic.main.activity_profile_trener_view.*
import kotlinx.android.synthetic.main.activity_profile_trener_view.imageView61
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream


class ProfileTrenerView : AppCompatActivity() {

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
        setContentView(R.layout.activity_profile_trener_view)


    }
    val storage = FirebaseStorage.getInstance()
    val ImageStorage = storage.getReference().child("TrenersPhoto")
    val REQUEST_CODE = 100

    fun AnketaCoachClick(view: View) {
        when (view.id){
            R.id.imageButton25->{
                chooserPhoto()

            }
            R.id.imageButton9 ->{
                val intent = Intent(this, Anketa_Coach::class.java)
                startActivity(intent)
            }
        }

    }
    private fun chooserPhoto(){
        CropImage.activity()
            .setAspectRatio(1,1)
            .setRequestedSize(600,600)
            .setCropShape(CropImageView.CropShape.RECTANGLE)
            .start(this)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            val uri =CropImage.getActivityResult(data).uri
            val path = ImageStorage
            path.putFile(uri).addOnFailureListener {
                Toast.makeText(applicationContext, "Упс", Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(applicationContext, "Фото успешно загружено!", Toast.LENGTH_SHORT).show()
            }
        }
        }
            /* fun xz(){val photoPickerIntent = Intent(Intent.ACTION_PICK)
    photoPickerIntent.type = "image/*"
    startActivityForResult(photoPickerIntent, REQUEST_CODE)}*/

    */
            /*  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            val stream = FileInputStream(File(data?.data?.path.toString()))
           /* imageView61.setImageURI(data?.data) // handle chosen image
            val bitmap = (imageView61.drawable as BitmapDrawable).bitmap
            val baos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val data = baos.toByteArray()

            var uploadTask = ImageStorage.putBytes(data)
            uploadTask.addOnFailureListener {
                // Handle unsuccessful uploads
            }.addOnSuccessListener {
                // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
                // ...
            }*/
            var uploadTask = ImageStorage.putStream(stream)
            uploadTask.addOnFailureListener {

                    Toast.makeText(applicationContext, "Упс", Toast.LENGTH_SHORT).show()

            }.addOnSuccessListener {
                Toast.makeText(applicationContext, "Фото успешно загружено!", Toast.LENGTH_SHORT).show()
            }
        }
    }*/

            override fun onWindowFocusChanged(hasFocus: Boolean) {
                super.onWindowFocusChanged(hasFocus)
                if (hasFocus) hideSystemUI()
            }
        }
