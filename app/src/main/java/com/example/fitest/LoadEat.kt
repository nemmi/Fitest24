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



class LoadEat : AppCompatActivity() {



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
        buttonSaveEat.setOnClickListener{
            if(monday.isChecked){
                loadEat(value,"_M")
            }
            if(tuesday.isChecked){
                loadEat(value,"_T")
            }
            if(wednesday.isChecked){
                loadEat(value,"_W")
            }
            if(thursday.isChecked){
                loadEat(value,"_Th")
            }
            if(friday.isChecked){
                loadEat(value,"_F")
            }

            if(saturday.isChecked){
                loadEat(value,"_Sat")
            }

            if(sunday.isChecked){
                loadEat(value,"_Sun")
            }
        }
        val radGrp = findViewById<RadioGroup>(R.id.tableRow2);
        radGrp.setOnCheckedChangeListener { radGrp, optionId ->
            run {
                when (optionId) {
                    R.id.monday -> {
                        setEat()
                    }
                    R.id.tuesday -> {
                        setEat()
                    }
                    R.id.wednesday -> {
                        setEat()
                    }
                    R.id.thursday -> {
                        setEat()
                }
                    R.id.friday -> {
                        setEat()
                    }
                    R.id.saturday -> {
                        setEat()
                    }
                    R.id.sunday -> {
                        setEat()
                    }
                    else -> throw AssertionError()
                }
            }
        }
    }
            private fun setEat() {
                eatTxt1.setText("")
                eatTxt2.setText("")
                eatTxt3.setText("")
                eatTxt4.setText("")
                eatTxt5.setText("")
            }
    fun loadEat(value:String, day:String){
        val FIELD__PATTERN = Regex(pattern = "[0-9a-zA-Zа-яА-Я -., \n \r]{3,300}")

        val up=  ddb.collection("eat")
            .document(value+day)

        if(eatTxt1.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eatTxt1.text.toString())) {
            up
                .update(
                    "eat1", eatTxt1.text.toString()
                )
                .addOnSuccessListener {}
        }
        else if(eatTxt1.text.toString().isEmpty()){
            up
                .update(
                    "eat1", ""
                )
                .addOnSuccessListener {}
        }

        if(eatTxt2.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eatTxt2.text.toString())) {
            up
                .update(
                    "eat2", eatTxt2.text.toString()
                )
                .addOnSuccessListener {}
        }
        else if(eatTxt2.text.toString().isEmpty()){
            up
                .update(
                    "eat2", ""
                )
                .addOnSuccessListener {}
        }

        if(eatTxt3.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eatTxt3.text.toString())) {
            up
                .update(
                    "eat3", eatTxt3.text.toString()
                )
                .addOnSuccessListener {}
        }
        else if(eatTxt3.text.toString().isEmpty()){
            up
                .update(
                    "eat3", ""
                )
                .addOnSuccessListener {}
        }

        if(eatTxt4.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eatTxt4.text.toString())) {
            up
                .update(
                    "eat4", eatTxt4.text.toString()
                )
                .addOnSuccessListener {}
        }
        else if(eatTxt4.text.toString().isEmpty()){
            up
                .update(
                    "eat4", ""
                )
                .addOnSuccessListener {}
        }
        if(eatTxt5.text.toString().isNotEmpty()&& FIELD__PATTERN.matches(eatTxt5.text.toString())) {
            up
                .update(
                    "eat5",eatTxt5.text.toString()
                )
                .addOnSuccessListener {}
        }
        else if(eatTxt5.text.toString().isEmpty()){
            up
                .update(
                    "eat5", ""
                )
                .addOnSuccessListener {}
        }

        Toast.makeText(
            baseContext,  resources.getString(R.string.message_success),
            Toast.LENGTH_SHORT
        ).show()

    }
    fun eatLoadClick(view: View) {

        var value= intent.getStringExtra("id")
        if (IsInternetAvailable.isInternetAvailable(this)) {
            when (view.id) {
                R.id.imageProfile -> {
                    val backtotrener = Intent(this, ProfileTrainer::class.java)
                    startActivity(backtotrener)
                }
                R.id.btnClients -> {
                    val Clienty = Intent(this, ListClient::class.java)
                    startActivity(Clienty)
                }
                R.id.btnChat -> {
                    val Chat = Intent(this, SpisocChatov::class.java)
                    startActivity(Chat)
                }
                R.id.btnProfileClient -> {

                    val intent = Intent(this, ProfileClientView::class.java)
                    Log.i("DocId", value)
                    intent.putExtra("id", value)
                    Log.i("Intent", value)

                    startActivity(intent)
                }
            }
        } else {
            alert()
            startActivity(Intent(this, MainActivity::class.java))
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