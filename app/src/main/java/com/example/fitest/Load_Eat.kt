package com.example.fitest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.RadioGroup
import android.widget.Toast
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_load_eat.*



class Load_Eat : AppCompatActivity() {



    private val ddb: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

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
        setContentView(R.layout.activity_load_eat)
        var value= intent.getStringExtra("id")
        var pusto = ""
        buttonSaveEat.setOnClickListener{
            val FIELD__PATTERN = Regex(pattern = "[0-9a-zA-Zа-яА-Я -.,!? \n \r]{3,175}")

            if(monday.isChecked){
                val up=  ddb.collection("eat")
                    .document(value+"_M") /*здесь будет айди спортсмена*/
                if(eat1txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat1txt.text.toString())) {
                    up
                        .update(
                            "eat1", eat1txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }

                if(eat2txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat2txt.text.toString())) {
                    up
                        .update(
                            "eat2", eat2txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }

                if(eat3txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat3txt.text.toString())) {
                    up
                        .update(
                            "eat3", eat3txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }

                if(eat4txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat4txt.text.toString())) {
                    up
                        .update(
                            "eat4", eat4txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }

                if(eat5txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat5txt.text.toString())) {
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
                    .document(value+"_T") /*здесь будет айди спортсмена*/

                if(eat1txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat1txt.text.toString())) {
                    up
                        .update(
                            "eat1", eat1txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }

                if(eat2txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat2txt.text.toString())) {
                    up
                        .update(
                            "eat2", eat2txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }

                if(eat3txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat3txt.text.toString())) {
                    up
                        .update(
                            "eat3", eat3txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }

                if(eat4txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat4txt.text.toString())) {
                    up
                        .update(
                            "eat4", eat4txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }

                if(eat5txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat5txt.text.toString())) {
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
                    .document(value+"_W") /*здесь будет айди спортсмена*/
                if(eat1txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat1txt.text.toString())) {
                    up
                        .update(
                            "eat1", eat1txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }

                if(eat2txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat2txt.text.toString())) {
                    up
                        .update(
                            "eat2", eat2txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }

                if(eat3txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat3txt.text.toString())) {
                    up
                        .update(
                            "eat3", eat3txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat4txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat4txt.text.toString())) {
                    up
                        .update(
                            "eat4", eat4txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat5txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat5txt.text.toString())) {
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
                    .document(value+"_Th") /*здесь будет айди спортсмена*/
                if(eat1txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat1txt.text.toString())) {
                    up
                        .update(
                            "eat1", eat1txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat2txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat2txt.text.toString())) {
                    up
                        .update(
                            "eat2", eat2txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat3txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat3txt.text.toString())) {
                    up
                        .update(
                            "eat3", eat3txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat4txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat4txt.text.toString())) {
                    up
                        .update(
                            "eat4", eat4txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat5txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat5txt.text.toString())) {
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
                    .document(value+"_F") /*здесь будет айди спортсмена*/
                if(eat1txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat1txt.text.toString())) {
                    up
                        .update(
                            "eat1", eat1txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat2txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat2txt.text.toString())) {
                    up
                        .update(
                            "eat2", eat2txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat3txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat3txt.text.toString())) {
                    up
                        .update(
                            "eat3", eat3txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat4txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat4txt.text.toString())) {
                    up
                        .update(
                            "eat4", eat4txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat5txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat5txt.text.toString())) {
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
                    .document(value+"_Sat") /*здесь будет айди спортсмена*/
                if(eat1txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat1txt.text.toString())) {
                    up
                        .update(
                            "eat1", eat1txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat2txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat2txt.text.toString())) {
                    up
                        .update(
                            "eat2", eat2txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat3txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat3txt.text.toString())) {
                    up
                        .update(
                            "eat3", eat3txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat4txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat4txt.text.toString())) {
                    up
                        .update(
                            "eat4", eat4txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat5txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat5txt.text.toString())) {
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
                    .document(value+"_Sun") /*здесь будет айди спортсмена*/
                if(eat1txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat1txt.text.toString())) {
                    up
                        .update(
                            "eat1", eat1txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat2txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat2txt.text.toString())) {
                    up
                        .update(
                            "eat2", eat2txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat3txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat3txt.text.toString())) {
                    up
                        .update(
                            "eat3", eat3txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat4txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat4txt.text.toString())) {
                    up
                        .update(
                            "eat4", eat4txt.text.toString()
                        )
                        .addOnSuccessListener {}
                }
                if(eat5txt.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eat5txt.text.toString())) {
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
        val radGrp = findViewById<RadioGroup>(R.id.tableRow2);
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                when (optionId) {
                    R.id.monday -> {
                        eat1txt.setText("")
                        eat2txt.setText("")
                        eat3txt.setText("")
                        eat4txt.setText("")
                        eat5txt.setText("")
                    }
                    R.id.tuesday -> {
                        eat1txt.setText("")
                        eat2txt.setText("")
                        eat3txt.setText("")
                        eat4txt.setText("")
                        eat5txt.setText("")
                    }
                    R.id.wednesday -> {
                        eat1txt.setText("")
                        eat2txt.setText("")
                        eat3txt.setText("")
                        eat4txt.setText("")
                        eat5txt.setText("")
                    }
                    R.id.thursday -> {
                        eat1txt.setText("")
                        eat2txt.setText("")
                        eat3txt.setText("")
                        eat4txt.setText("")
                        eat5txt.setText("")
                    }
                    R.id.friday -> {
                        eat1txt.setText("")
                        eat2txt.setText("")
                        eat3txt.setText("")
                        eat4txt.setText("")
                        eat5txt.setText("")
                    }
                    R.id.saturday -> {
                        eat1txt.setText("")
                        eat2txt.setText("")
                        eat3txt.setText("")
                        eat4txt.setText("")
                        eat5txt.setText("")
                    }
                    R.id.sunday -> {
                        eat1txt.setText("")
                        eat2txt.setText("")
                        eat3txt.setText("")
                        eat4txt.setText("")
                        eat5txt.setText("")
                    }
                    else -> throw AssertionError()
                }
            }
        }
    }

    fun eatLoadClick(view: View) {
        var value= intent.getStringExtra("id")
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
                val intent = Intent(this, ProfileClientView::class.java)
                Log.i("DocId", value)
                intent.putExtra("id", value)
                Log.i("Intent", value)

                startActivity(intent)
            }
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}