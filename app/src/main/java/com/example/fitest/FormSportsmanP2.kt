package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.fitest.SelectTrener.SelectTrener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase

import kotlinx.android.synthetic.main.activity_sportsmen_anketa2.*

class FormSportsmanP2 : AppCompatActivity() {

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
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sportsmen_anketa2)
    }

    override fun onBackPressed() {
    }

    fun anketaSp2Click(view: View) {
        when (view.id) {
          /*  R.id.toolbarAnketaView -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    val intent = Intent(this, FormSportsmanP1::class.java)
                    startActivity(intent)
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }*/
            R.id.buttonToCoach -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    upProfile()
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }

        }
    }

    private fun upProfile() {
        val FIELD__PATTERN = Regex(pattern = resources.getString(R.string.pattern_field))

        if (!FIELD__PATTERN.matches(editBelok.text.toString())) {
            editBelok.error  = resources.getString(R.string.error_valid_three_fifty)
            editBelok.requestFocus()
            return
        }
        if (!FIELD__PATTERN.matches(editFats.text.toString())) {
            editFats.error =  resources.getString(R.string.error_valid_three_fifty)
            editFats.requestFocus()
            return
        }
        if (!FIELD__PATTERN.matches(editCarbs.text.toString())) {
            editCarbs.error =  resources.getString(R.string.error_valid_three_fifty)
            editCarbs.requestFocus()
            return
        }

        if (editBelok.text.toString().isEmpty()) {
            editBelok.error =  resources.getString(R.string.error_valid_for_empty_field)
            editBelok.requestFocus()
            return
        }
        if (editFats.text.toString().isEmpty()) {
            editFats.error = resources.getString(R.string.error_valid_for_empty_field)
            editFats.requestFocus()
            return
        }
        if (editCarbs.text.toString().isEmpty()) {
            editCarbs.error = resources.getString(R.string.error_valid_for_empty_field)
            editCarbs.requestFocus()
            return
        }

        if ((editBelok.text.length > 50) or (editBelok.text.length < 10)) {
            editBelok.error = resources.getString(R.string.error_valid_ten_fifty)
            editBelok.requestFocus()
            return
        }
        if ((editCarbs.text.length > 50) or (editCarbs.text.length < 10)) {
            editCarbs.error = resources.getString(R.string.error_valid_ten_fifty)
            editCarbs.requestFocus()
            return
        }
        if ((editFats.text.length > 50) or (editFats.text.length < 10)) {
            editFats.error = resources.getString(R.string.error_valid_ten_fifty)
            editFats.requestFocus()
            return
        }
        else {

            val user = hashMapOf(

                "belock" to editBelok.text.toString(),
                "carbs" to editCarbs.text.toString(),
                "fats" to editFats.text.toString(),

                "shoulder" to   "",
                "breast" to   "",
                "biceps" to  "",
                "waist" to  "",
                "buttock" to "",
                "hip" to "",

                "weight2" to "",
                "shoulder2" to   "",
                "breast2" to   "",
                "biceps2" to  "",
                "waist2" to  "",
                "buttock2" to "",
                "hip2" to "",

                "myTrener" to "null"

            )
            val eatM =hashMapOf(

                "eat1" to "омлет+ кофе, сыр 30г",
                "eat2" to "курица+ овощи",
                "eat3" to "",
                "eat4" to "",
                "eat5" to "",

                "Checkbox1" to "false",
                "Checkbox2" to "false",
                "Checkbox3" to "false",
                "Checkbox4" to "false",
                "Checkbox5" to "false"
            )
            val eatT =hashMapOf(

                "eat1" to "каша + сыр+ кофе",
                "eat2" to "курица+ овощи",
                "eat3" to "рыба + овощи",
                "eat4" to "творог",
                "eat5" to "",

                "Checkbox1" to "false",
                "Checkbox2" to "false",
                "Checkbox3" to "false",
                "Checkbox4" to "false",
                "Checkbox5" to "false"
            )

            val eatW =hashMapOf(

                "eat1" to "овсяная каша, кофе, сыр 30г",
                "eat2" to "курица+ овощи",
                "eat3" to "кальмар+ рис",
                "eat4" to "творог",
                "eat5" to "",

                "Checkbox1" to "false",
                "Checkbox2" to "false",
                "Checkbox3" to "false",
                "Checkbox4" to "false",
                "Checkbox5" to "false"
            )
            val eatTh =hashMapOf(

                "eat1" to "омлет + сыр 30 г, кофе/чай",
                "eat2" to "водичка",
                "eat3" to "водичка",
                "eat4" to "вода",
                "eat5" to "",

                "Checkbox1" to "false",
                "Checkbox2" to "false",
                "Checkbox3" to "false",
                "Checkbox4" to "false",
                "Checkbox5" to "false"
            )
            val eatFr =hashMapOf(

                "eat1" to "овсяная каша, кофе, сыр 30г",
                "eat2" to "курица+гречка",
                "eat3" to "рыба+овощи",
                "eat4" to "творог",
                "eat5" to "",

                "Checkbox1" to "false",
                "Checkbox2" to "false",
                "Checkbox3" to "false",
                "Checkbox4" to "false",
                "Checkbox5" to "false"
            )
            val eatSat =hashMapOf(

                "eat1" to "водичка",
                "eat2" to "водичка",
                "eat3" to "вода",
                "eat4" to "",
                "eat5" to "",

                "Checkbox1" to "false",
                "Checkbox2" to "false",
                "Checkbox3" to "false",
                "Checkbox4" to "false",
                "Checkbox5" to "false"
            )
            val eatSun =hashMapOf(
                "eat1" to "",
                "eat2" to "",
                "eat3" to "",
                "eat4" to "",
                "eat5" to "",

                "Checkbox1" to "false",
                "Checkbox2" to "false",
                "Checkbox3" to "false",
                "Checkbox4" to "false",
                "Checkbox5" to "false"
            )

            val tren1 =hashMapOf(
                "Comment1" to "",
                "Comment2" to "",
                "Comment3" to "",
                "Comment4" to "вес в каждую руку",
                "Comment5" to "",
                "Comment6" to "",
                "Comment7" to "",

                "Exercise1" to "Румынская тяга",
                "Exercise2" to "Тяга верхнего блока",
                "Exercise3" to "Скрестные выпады",
                "Exercise4" to "Плие",
                "Exercise5" to "Отжимания",
                "Exercise6" to "Планка",
                "Exercise7" to "",

                "Podhod1" to "4х20",
                "Podhod2" to "3Х20",
                "Podhod3" to "4х15",
                "Podhod4" to "4х20",
                "Podhod5" to "3х12",
                "Podhod6" to "4хмакс",
                "Podhod7" to "",

                "Weight1" to "10",
                "Weight2" to "12",
                "Weight3" to "6",
                "Weight4" to "24",
                "Weight5"  to "",
                "Weight6" to "",
                "Weight7" to "",

                "Checkbox1" to "false",
                "Checkbox2" to "false",
                "Checkbox3" to "false",
                "Checkbox4" to "false",
                "Checkbox5" to "false",
                "Checkbox6" to "false",
                "Checkbox7" to "false",

                "test_week" to true
            )
            val tren2 =hashMapOf(

                "Comment1" to "",
                "Comment2" to "",
                "Comment3" to "вес в каждую руку",
                "Comment4" to "",
                "Comment5" to "любое упражнение",
                "Comment6" to "",
                "Comment7" to "",

                "Exercise1" to "Тяга блока к груди",
                "Exercise2" to "Тяга блока к поясу",
                "Exercise3" to "Жим гантелей лежа",
                "Exercise4" to "Гиперэкстензия",
                "Exercise5" to "Скручивания",
                "Exercise6" to "",
                "Exercise7" to "",

                "Podhod1" to "3х20",
                "Podhod2" to "3Х20",
                "Podhod3" to "3х15",
                "Podhod4" to "4х25",
                "Podhod5" to "4х20",
                "Podhod6" to "",
                "Podhod7" to "",

                "Weight1" to "12",
                "Weight2" to "16",
                "Weight3" to "6",
                "Weight4" to "5",
                "Weight5"  to "",
                "Weight6" to "",
                "Weight7" to "",

                "Checkbox1" to "false",
                "Checkbox2" to "false",
                "Checkbox3" to "false",
                "Checkbox4" to "false",
                "Checkbox5" to "false",
                "Checkbox6" to "false",
                "Checkbox7" to "false",

                "test_week" to true
            )
            val tren3 =hashMapOf(
                "Comment1" to "",
                "Comment2" to "",
                "Comment3" to "",
                "Comment4" to "вес в каждую руку",
                "Comment5" to "",
                "Comment6" to "",
                "Comment7" to "",

                "Exercise1" to "Румынская тяга",
                "Exercise2" to "Тяга верхнего блока",
                "Exercise3" to "Скрестные выпады",
                "Exercise4" to "Плие",
                "Exercise5" to "Отжимания",
                "Exercise6" to "Планка",
                "Exercise7" to "",

                "Podhod1" to "4х20",
                "Podhod2" to "3Х20",
                "Podhod3" to "4х15",
                "Podhod4" to "4х20",
                "Podhod5" to "3х12",
                "Podhod6" to "4хмакс",
                "Podhod7" to "",

                "Weight1" to "10",
                "Weight2" to "12",
                "Weight3" to "6",
                "Weight4" to "24",
                "Weight5"  to "",
                "Weight6" to "",
                "Weight7" to "",

                "Checkbox1" to "false",
                "Checkbox2" to "false",
                "Checkbox3" to "false",
                "Checkbox4" to "false",
                "Checkbox5" to "false",
                "Checkbox6" to "false",
                "Checkbox7" to "false",

                "test_week" to true
            )

            Firebase.auth.currentUser?.uid?.let {
                ddb.collection("eat")
                    .document(it+"_M")
                    .set(eatM as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                    }
                ddb.collection("eat")
                    .document(it+"_T")
                    .set(eatT as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                    }
                ddb.collection("eat")
                    .document(it+"_W")
                    .set(eatW as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                    }
                ddb.collection("eat")
                    .document(it+"_Th")
                    .set(eatTh as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                    }
                ddb.collection("eat")
                    .document(it+"_F")
                    .set(eatFr as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                    }
                ddb.collection("eat")
                    .document(it+"_Sat")
                    .set(eatSat as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                    }
                ddb.collection("eat")
                    .document(it+"_Sun")
                    .set(eatSun as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                    }

                ddb.collection("trainings")
                    .document(it+"_1")
                    .set(tren1 as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->

                    }

                ddb.collection("trainings")
                    .document(it+"_2")
                    .set(tren2 as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->

                    }
                ddb.collection("trainings")
                    .document(it+"_3")
                    .set(tren3 as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->

                    }
                ddb.collection("sportsmen")
                    .document(it)
                    .set(user as Map<String, Any>, SetOptions.merge())
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(
                            baseContext, resources.getString(R.string.message_success),
                            Toast.LENGTH_SHORT
                        ).show()
                        val num="true"
                        val intent = Intent(this, SelectTrener::class.java)
                        intent.putExtra("num", num)
                        startActivity(intent)
                        finish()
                    }
                    .addOnFailureListener{e ->
                        Toast.makeText(
                            baseContext, resources.getString(R.string.message_unsuccess) + e.localizedMessage,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
        }
    }

    private val ddb = FirebaseFirestore.getInstance()

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