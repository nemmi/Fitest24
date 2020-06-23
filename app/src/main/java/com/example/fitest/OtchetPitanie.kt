package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.android.synthetic.main.activity_otchet_eat.*
import kotlinx.android.synthetic.main.activity_otchet_eat.checkBox1
import kotlinx.android.synthetic.main.activity_otchet_eat.checkBox3
import kotlinx.android.synthetic.main.activity_otchet_eat.checkBox4
import kotlinx.android.synthetic.main.activity_otchet_eat.checkBox5
import kotlinx.android.synthetic.main.activity_otchet_eat.eat1txt
import kotlinx.android.synthetic.main.activity_otchet_eat.eat2txt
import kotlinx.android.synthetic.main.activity_otchet_eat.eat3txt
import kotlinx.android.synthetic.main.activity_otchet_eat.eat4txt
import kotlinx.android.synthetic.main.activity_otchet_eat.eat5txt
import kotlinx.android.synthetic.main.activity_otchet_eat.friday
import kotlinx.android.synthetic.main.activity_otchet_eat.imageView40
import kotlinx.android.synthetic.main.activity_otchet_eat.imageView444
import kotlinx.android.synthetic.main.activity_otchet_eat.imageView48
import kotlinx.android.synthetic.main.activity_otchet_eat.monday
import kotlinx.android.synthetic.main.activity_otchet_eat.saturday
import kotlinx.android.synthetic.main.activity_otchet_eat.sunday
import kotlinx.android.synthetic.main.activity_otchet_eat.thursday
import kotlinx.android.synthetic.main.activity_otchet_eat.tuesday
import kotlinx.android.synthetic.main.activity_otchet_eat.wednesday



class OtchetPitanie : AppCompatActivity() {

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
        setContentView(R.layout.activity_otchet_eat)
        val radGrp = findViewById<RadioGroup>(R.id.tableRow2);
        loadMon()
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                when (optionId) {

                    R.id.monday -> {
                        loadMon()
                    }

                    R.id.tuesday -> {

                        ddb.collection("eat")
                            .document("test_week") /*здесь будет айди спортсмена*/
                            .addSnapshotListener { snapshot, e ->
                                if (e != null) {
                                    Toast.makeText(
                                        baseContext, "Считать неудалось$e",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@addSnapshotListener
                                }
                                if (snapshot != null && snapshot.exists()) {

                                    val eat: List<String> = snapshot.get("tue") as List<String>
                                    eat1txt.text = eat[0]
                                    eat2txt.text = eat[1]
                                    eat3txt.text = eat[2]
                                    eat4txt.text = eat[3]
                                    eat5txt.text = eat[4]

                                } else {
                                    Toast.makeText(
                                        baseContext, "Нет данных",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }

                    R.id.wednesday -> {

                        ddb.collection("eat")
                            .document("test_week") /*здесь будет айди спортсмена*/
                            .addSnapshotListener { snapshot, e ->
                                if (e != null) {
                                    Toast.makeText(
                                        baseContext, "Считать неудалось$e",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@addSnapshotListener
                                }
                                if (snapshot != null && snapshot.exists()) {
                                    val eat: List<String> = snapshot.get("we") as List<String>
                                    eat1txt.text = eat[0]
                                    eat2txt.text = eat[1]
                                    eat3txt.text = eat[2]
                                    eat4txt.text = eat[3]
                                    check(snapshot)

                                } else {
                                    Toast.makeText(
                                        baseContext, "Нет данных",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }

                    R.id.thursday ->{

                        ddb.collection("eat")
                            .document("test_week") /*здесь будет айди спортсмена*/
                            .addSnapshotListener { snapshot, e ->
                                if (e != null) {
                                    Toast.makeText(
                                        baseContext, "Считать неудалось$e",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@addSnapshotListener
                                }
                                if (snapshot != null && snapshot.exists()) {
                                    val eat: List<String> = snapshot.get("thur") as List<String>
                                    eat1txt.text = eat[0]
                                    eat2txt.text = eat[1]
                                    eat3txt.text = eat[2]
                                    eat4txt.text = eat[3]
                                    eat5txt.text = eat[4]
                                    check(snapshot)

                                } else {
                                    Toast.makeText(
                                        baseContext, "Нет данных",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }

                    R.id.friday ->{
                        ddb.collection("eat")
                            .document("test_week") /*здесь будет айди спортсмена*/
                            .addSnapshotListener { snapshot, e ->
                                if (e != null) {
                                    Toast.makeText(
                                        baseContext, "Считать неудалось$e",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@addSnapshotListener
                                }
                                if (snapshot != null && snapshot.exists()) {
                                    val eat: List<String> = snapshot.get("fri") as List<String>
                                    eat1txt.text = eat[0]
                                    eat2txt.text = eat[1]
                                    eat3txt.text = eat[2]
                                    eat4txt.text = eat[3]
                                    eat5txt.text = eat[4]
                                    check(snapshot)

                                } else {
                                    Toast.makeText(
                                        baseContext, "Нет данных",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }

                    R.id.saturday ->{
                        ddb.collection("eat")
                            .document("test_week") /*здесь будет айди спортсмена*/
                            .addSnapshotListener { snapshot, e ->
                                if (e != null) {
                                    Toast.makeText(
                                        baseContext, "Считать неудалось$e",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@addSnapshotListener
                                }
                                if (snapshot != null && snapshot.exists()) {

                                    val eat: List<String> = snapshot.get("sat") as List<String>
                                    eat1txt.text = eat[0]
                                    eat2txt.text = eat[1]
                                    eat3txt.text = eat[2]
                                    eat4txt.text = eat[3]
                                    eat5txt.text = eat[4]
                                    check(snapshot)

                                } else {
                                    Toast.makeText(
                                        baseContext, "Нет данных",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }

                    R.id.sunday ->{
                        ddb.collection("eat")
                            .document("test_week") /*здесь будет айди спортсмена*/
                            .addSnapshotListener { snapshot, e ->
                                if (e != null) {
                                    Toast.makeText(
                                        baseContext, "Считать неудалось$e",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@addSnapshotListener
                                }
                                if (snapshot != null && snapshot.exists()) {

                                    val eat: List<String> = snapshot.get("sun") as List<String>
                                    eat1txt.text = eat[0]
                                    eat2txt.text = eat[1]
                                    eat3txt.text = eat[2]
                                    eat4txt.text = eat[3]
                                    eat5txt.text = eat[4]
                                    check(snapshot)

                                } else {
                                    Toast.makeText(
                                        baseContext, "Нет данных",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }
                    else -> throw AssertionError()
                }

            }

        }
    }

    private fun loadMon() {
        ddb.collection("eat")
            .document("test_week") /*здесь будет айди спортсмена*/
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(
                        baseContext, "Считать неудалось$e",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {

                    val eat: List<String> = snapshot.get("mon") as List<String>
                    eat1txt.text = eat[0]
                    eat2txt.text = eat[1]
                    eat3txt.text = eat[2]
                    eat4txt.text = eat[3]
                    eat5txt.text = eat[4]
                    check(snapshot)

                }
                else {
                    Toast.makeText(
                        baseContext, "Нет данных",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private val ddb = FirebaseFirestore.getInstance()
    private fun check(snapshot: DocumentSnapshot?){
        if (snapshot != null) {
            if (snapshot.get("Checkbox1") == true) {
                checkBox1.isChecked = true
            }
            if (snapshot.get("Checkbox2") == true) {
                checkBox2.isChecked = true
            }
            if (snapshot.get("Checkbox3") == true) {
                checkBox3.isChecked = true
            }
            if (snapshot.get("Checkbox4") == true) {
                checkBox4.isChecked = true
            }
            if (snapshot.get("Checkbox5") == true) {
                checkBox5.isChecked = true
            }
        }

    }

    fun otchEatClick(view: View) {
        when (view.id){

            R.id.imageProfile ->{
                startActivity(Intent(this, ProfileTrener::class.java))
            }
            R.id.Clienti ->{

                startActivity(Intent(this, ListClient::class.java))
            }
            R.id.groupchat ->{

                startActivity(Intent(this, SpisocChatov::class.java))
            }
            R.id.btn_profileClient ->{
                startActivity(Intent(this, ProfileClientView::class.java))
            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}
