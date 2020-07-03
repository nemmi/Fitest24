package com.example.fitest

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter.LengthFilter
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_body_params_edit.*



class ParamsEdit : AppCompatActivity() {

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
        setContentView(R.layout.activity_body_params_edit)
        if (IsInternetAvailable.isInternetAvailable(this)) {
            loadData()
            editWeight.limitLength()
            editShoulder.limitLength()
            editTall.limitLength()
            editBreast.limitLength()
            editBiceps.limitLength()
            editWaist.limitLength()
            editButtocks.limitLength()
            editHip.limitLength()
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun loadData(){

        Firebase.auth.currentUser?.uid?.let {
            val up =
                ddb.collection("sportsmen")
                    .document(it)
            up
                .addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        Toast.makeText(
                            baseContext, resources.getString(R.string.error_base),
                            Toast.LENGTH_SHORT
                        ).show()
                        return@addSnapshotListener
                    }
                    if (snapshot != null && snapshot.exists()) {

                        textWeight.text = snapshot.getString("weight")
                        textShoulder.text= snapshot.getString("shoulder")
                        textBreast.text= snapshot.getString("breast")
                        textBiceps.text= snapshot.getString("biceps")
                        textWaist.text= snapshot.getString("waist")
                        textButtocks.text=snapshot.getString("buttock")
                        textHip.text= snapshot.getString("hip")
                    }
                    else {
                        Toast.makeText(
                            baseContext, resources.getString(R.string.error_empty_base),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
        }
    }
    private fun EditText.limitLength() {
        this.filters = arrayOf(LengthFilter(4))
    }


    fun paramEditClick(view: View) {
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {
                R.id.buttonSave -> {
                    editParam()
                    Toast.makeText(
                        baseContext, resources.getString(R.string.message_success),
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this, ParamsSportsman::class.java))
                }

            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private val ddb = FirebaseFirestore.getInstance()
    private fun editParam(){

        Firebase.auth.currentUser?.uid?.let {
            val up =
                ddb.collection("sportsmen")
                    .document(it)
            if(editWeight.text.toString().isNotEmpty()){
                up
                    .update(
                        "weight2",editWeight.text.toString())
                    .addOnSuccessListener {
                    }
            }
            if(editShoulder.text.toString().isNotEmpty()){
                up
                    .update(
                        "shoulder2", editShoulder.text.toString())
                    .addOnSuccessListener {
                    }
            }
            if(editBreast.text.toString().isNotEmpty()){
                up
                    .update(
                        "breast2", editBreast.text.toString())
                    .addOnSuccessListener {
                    }
            }

            if(editTall.text.toString().isNotEmpty()){
                up
                    .update(
                        "height",editTall.text.toString())
                    .addOnSuccessListener {
                    }
            }
            if(editButtocks.text.toString().isNotEmpty()){
                up
                    .update(
                        "buttock2",editButtocks.text.toString()
                    )
                    .addOnSuccessListener {
                    }
            }

            if(editHip.text.toString().isNotEmpty()){
                up
                    .update(
                        "hip2",editHip.text.toString())
                    .addOnSuccessListener {
                    }

            }
            if(editWaist.text.toString().isNotEmpty()){
                up
                    .update(
                        "waist2",editWaist.text.toString())
                    .addOnSuccessListener {
                    }

            }
            if(editBiceps.text.toString().isNotEmpty()){
                up
                    .update(
                        "biceps2",editBiceps.text.toString()
                    )
                    .addOnSuccessListener {
                    }
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


