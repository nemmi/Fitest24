package com.example.fitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_body_params_edit.*
import kotlinx.android.synthetic.main.activity_load_eat.*


class Load_Eat : AppCompatActivity() {

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
        setContentView(R.layout.activity_load_eat)
        val radGrp = findViewById<RadioGroup>(R.id.tableRow2);
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                when (optionId) {

                    R.id.monday -> {
                        eat1txt.clearComposingText()
                        eat2txt.clearComposingText()
                        eat3txt.clearComposingText()
                        eat4txt.clearComposingText()
                        eat5txt.clearComposingText()
                    }
                    R.id.tuesday -> {
                        eat1txt.clearComposingText()
                        eat2txt.clearComposingText()
                        eat3txt.clearComposingText()
                        eat4txt.clearComposingText()
                        eat5txt.clearComposingText()
                    }
                    R.id.wednesday -> {
                        eat1txt.clearComposingText()
                        eat2txt.clearComposingText()
                        eat3txt.clearComposingText()
                        eat4txt.clearComposingText()
                        eat5txt.clearComposingText()
                    }
                    R.id.thursday -> {
                        eat1txt.clearComposingText()
                        eat2txt.clearComposingText()
                        eat3txt.clearComposingText()
                        eat4txt.clearComposingText()
                        eat5txt.clearComposingText()
                    }
                    R.id.friday -> {
                        eat1txt.clearComposingText()
                        eat2txt.clearComposingText()
                        eat3txt.clearComposingText()
                        eat4txt.clearComposingText()
                        eat5txt.clearComposingText()
                    }
                    R.id.saturday -> {
                        eat1txt.clearComposingText()
                        eat2txt.clearComposingText()
                        eat3txt.clearComposingText()
                        eat4txt.clearComposingText()
                        eat5txt.clearComposingText()
                    }
                    R.id.sunday -> {
                        eat1txt.clearComposingText()
                        eat2txt.clearComposingText()
                        eat3txt.clearComposingText()
                        eat4txt.clearComposingText()
                        eat5txt.clearComposingText()

                    }
                    else -> throw AssertionError()
                }
            }
        }
    }
    private val ddb = FirebaseFirestore.getInstance()

    fun eatLoadClick(view: View) {
        when (view.id){
            R.id.imageProfile ->{
                val backtotrener= Intent(this, ProfileTrener::class.java)
                startActivity(backtotrener)
            }
            R.id.Clienti ->{
                val Clienty= Intent(this, ListClient::class.java)
                startActivity(Clienty)
            }
            R.id.groupchat ->{
                val Chat= Intent(this, SpisocChatov::class.java)
                startActivity(Chat)
            }
            R.id.btn_profileClient ->{
                val Client= Intent(this, ProfileClientView::class.java)
                startActivity(Client)
            }
            R.id.buttonSaveEat ->{
                if(monday.isChecked){
                    val up=  ddb.collection("eat")
                        .document("test_load"+"_M") /*здесь будет айди спортсмена*/
                    if(eat1txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat1", eat1txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat2txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat2",eat2txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat3txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat3",eat3txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat4txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat4",eat4txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat5txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat5",eat5txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }

                    Toast.makeText(
                        baseContext, "Программа успешно загружена",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                if(tuesday.isChecked){
                    val up= ddb.collection("eat")
                        .document("test_load"+"_T") /*здесь будет айди спортсмена*/
                    if(eat1txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat1", eat1txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat2txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat2",eat2txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat3txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat3",eat3txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat4txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat4",eat4txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat5txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat5",eat5txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }

                    Toast.makeText(
                        baseContext, "Программа успешно загружена",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if(wednesday.isChecked){
                    val up=  ddb.collection("eat")
                        .document("test_load"+"_W") /*здесь будет айди спортсмена*/
                    if(eat1txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat1", eat1txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat2txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat2",eat2txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat3txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat3",eat3txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat4txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat4",eat4txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat5txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat5",eat5txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }

                    Toast.makeText(
                        baseContext, "Программа успешно загружена",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if(thursday.isChecked){
                    val up= ddb.collection("eat")
                        .document("test_load"+"_Th") /*здесь будет айди спортсмена*/
                    if(eat1txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat1", eat1txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat2txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat2",eat2txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat3txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat3",eat3txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat4txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat4",eat4txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat5txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat5",eat5txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }

                    Toast.makeText(
                        baseContext, "Программа успешно загружена",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if(friday.isChecked){
                    val up=    ddb.collection("eat")
                        .document("test_load"+"_F") /*здесь будет айди спортсмена*/
                    if(eat1txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat1", eat1txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat2txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat2",eat2txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat3txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat3",eat3txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat4txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat4",eat4txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat5txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat5",eat5txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }

                    Toast.makeText(
                        baseContext, "Программа успешно загружена",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if(saturday.isChecked){
                    val up=  ddb.collection("eat")
                        .document("test_load"+"_Sat") /*здесь будет айди спортсмена*/
                    if(eat1txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat1", eat1txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat2txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat2",eat2txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat3txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat3",eat3txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat4txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat4",eat4txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat5txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat5",eat5txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }

                    Toast.makeText(
                        baseContext, "Программа успешно загружена",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if(sunday.isChecked){
                    val up=  ddb.collection("eat")
                        .document("test_load"+"_Sun") /*здесь будет айди спортсмена*/
                    if(eat1txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat1", eat1txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat2txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat2",eat2txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat3txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat3",eat3txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat4txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat4",eat4txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }
                    if(eat5txt.text.toString().isNotEmpty()) {
                        up
                            .update(
                                "eat5",eat5txt.text.toString()
                            )
                            .addOnSuccessListener {}
                    }

                    Toast.makeText(
                        baseContext, "Программа успешно загружена",
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
