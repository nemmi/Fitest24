package com.example.fitest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitest.Presenter.ILoginPresenter
import com.example.fitest.Presenter.LoginPresenter
import com.example.fitest.View.ILoginView
/*import es.dmoral.toasty.Toasty*/
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_main.*
/*import com.firebase.ui.auth.AuthUI*/
import com.google.firebase.auth.FirebaseAuth

private lateinit var auth:FirebaseAuth

class MainActivity : AppCompatActivity()/*, ILoginView*/ {

    /*override fun onLoginResult(message: String) {
        Toasty.info(this, message, Toast.LENGTH_SHORT).show()
    }*/

    /*internal lateinit var loginPresenter: ILoginPresenter*/
/*private val RC_SIGN_IN=1*/
    /*??????????????
    private val signIn=
        listOf(AuthUI.IdpConfig.EmailBuilder()
            .setAllowNewAccounts(true)
            .setRequireName(true)
            .build())????????????????
*/
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
        setContentView(R.layout.activity_auth)
     /*   val currentUser=auth.currentUser()
            updateUI(currentUser)*/
        //Init
      /*  loginPresenter = LoginPresenter(this)


        btn_login.setOnClickListener {
            loginPresenter.onLogin(edt_email.text.toString(), edt_password.text.toString())
        }*/
        /*btn_login.setOnClickListener{val intent=Intent(this, ProfileClient::class.java)
            startActivity(intent)}*/

            btn_login.setOnClickListener {
            /*    val intent=AuthUi.getInstance().createSignInIntentBuilder()
                    .setAvailableProviders(signInProviders).build()

                startActivityForResult(intent, RC_SIGN_IN)*/
               /* val trener1=Intent(this, ProfileTrener::class.java)
                startActivity(trener1)*/
            }

        imageButton6.setOnClickListener { val chektrener = Intent(this, SelectTrenerNotReg::class.java)
        startActivity(chektrener)}

        imageButton7.setOnClickListener { val reg = Intent(this, Registration::class.java)
            startActivity(reg)}

        }
   /* fun updateUI(currentUser:FirebaseAuth?){

    }*/
/*private fun startActivityForResult(){

}*/

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }


}


