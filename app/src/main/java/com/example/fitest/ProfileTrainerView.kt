package com.example.fitest

import android.app.Activity
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast

import com.bumptech.glide.Glide

import com.google.firebase.auth.FirebaseAuth


import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView

import kotlinx.android.synthetic.main.activity_profile_trener_view.*
import kotlinx.android.synthetic.main.activity_profile_trener_view.downloadPhoto


lateinit var REF_STORAGE_ROOT: StorageReference

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
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile_trener_view)
        REF_STORAGE_ROOT=FirebaseStorage.getInstance().reference
    }
    private val uid= FirebaseAuth.getInstance().currentUser?.uid

    fun ProfileTrenerClick(view: View) {
        when (view.id){
            R.id.btnDownloadPhoto->{
                chooserPhoto()

            }
            R.id.back ->{
                val intent = Intent(this, FormTrainer::class.java)
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
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE &&
            resultCode== Activity.RESULT_OK && data!=null) {

            val uri =CropImage.getActivityResult(data).uri
            val path = uid?.let { REF_STORAGE_ROOT.child("TrenersPhoto").child(it) }

            if (path != null) {
                path.putFile(uri).addOnSuccessListener {
                    Toast.makeText(applicationContext, "Фото успешно загружено", Toast.LENGTH_SHORT).show()
                    btnDownloadPhoto.visibility=View.INVISIBLE
                }

                Glide.with(this)
                    .load(path)
                    .into(downloadPhoto)

            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}


