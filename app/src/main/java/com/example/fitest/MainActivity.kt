package com.example.fitest


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitest.dffgh.SelectTrener
import com.google.firebase.auth.FirebaseAuth
/*import es.dmoral.toasty.Toasty*/
import kotlinx.android.synthetic.main.activity_auth.*

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_auth.editPassword


class MainActivity : AppCompatActivity()/*, ILoginView*/ {

    private lateinit var auth: FirebaseAuth
    /*override fun onLoginResult(message: String) {
        Toasty.info(this, message, Toast.LENGTH_SHORT).show()
    }*/

    /*internal lateinit var loginPresenter: ILoginPresenter*/

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


    /* private val RC_SIGN_IN=1*/

    /*  private val signIn=
          listOf(
              AuthUI.IdpConfig.EmailBuilder()
              .setAllowNewAccounts(true)
              .setRequireName(true)
              .build())*/

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        auth = FirebaseAuth.getInstance()

        //Init
        /*  loginPresenter = LoginPresenter(this)


        btn_login.setOnClickListener {
            loginPresenter.onLogin(edt_email.text.toString(), edt_password.text.toString())
        }*/
    }

    fun AuthClick(view: View){
        when(view.id){
            R.id.btn_login -> {
                doLogin()
                /*  val intent=AuthUI.getInstance().createSignInIntentBuilder()
                       .setAvailableProviders(signIn).build()
                   startActivityForResult(intent, RC_SIGN_IN)*/
                /* val trener1=Intent(this, ProfileTrener::class.java)
                startActivity(trener1)*/
            }
            R.id.button_listTren ->{
                startActivity(Intent(this,SelectTrener::class.java))
            }
            R.id.SignUp  ->{
                startActivity(Intent(this, Registration::class.java))
            }
        }

    }
    private val ddb = FirebaseFirestore.getInstance()
    private fun doLogin(){


        if (editEmail.text.toString().isEmpty()) {
            editEmail.error = "Введите email"
            editEmail.requestFocus()
            return
        }

        if (editPassword.text.toString().isEmpty()) {
            editEmail.error = "Введите пароль"
            editEmail.requestFocus()
            return
        }

        else {
            auth.signInWithEmailAndPassword(editEmail.text.toString(), editPassword.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        val user = auth.currentUser
                        Toast.makeText(
                            baseContext, "Вход выполнен успешно",
                            Toast.LENGTH_SHORT
                        ).show()

                        Firebase.auth.currentUser?.uid?.let {

                            ddb.collection("treners")
                                .document(it)
                                .addSnapshotListener { snapshot, e ->
                                    if (e != null) {
                                        Toast.makeText(
                                            baseContext, "Считать неудалось$e",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        return@addSnapshotListener
                                    }
                                    if (snapshot != null && snapshot.exists()) {

                                        if (snapshot.getString("status") == "trener") {
                                            startActivity(Intent(this, ProfileTrener::class.java))
                                        }
                                    } else {
                                        ddb.collection("sportsmen")
                                            .document(it)
                                            .addSnapshotListener { snapshot, e ->
                                                if (e != null) {
                                                    Toast.makeText(
                                                        baseContext, "Считать неудалось$e",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                    return@addSnapshotListener
                                                }
                                                if (snapshot != null && snapshot.exists()) {
                                                    if (snapshot.getString("status") == "sportsmen"){
                                                        startActivity(Intent(this, ProfileClient::class.java))
                                                    }
                                                }
                                            }
                                    }

                                }
                        }
                    }

                    else {
                        Toast.makeText(
                            baseContext, "Вход не выполнен" + task.exception,
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




