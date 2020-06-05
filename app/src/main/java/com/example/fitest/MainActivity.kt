package com.example.fitest


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
/*import es.dmoral.toasty.Toasty*/
import kotlinx.android.synthetic.main.activity_auth.*

import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_auth.editPassword


class MainActivity : AppCompatActivity()/*, ILoginView*/ {

   /* private lateinit var auth: FirebaseAuth*/
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


    private val RC_SIGN_IN=1

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
        val currentUser = auth.currentUser
        updateUI(currentUser)

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
                startActivity(Intent(this,SelectTrenerNotReg::class.java))
            }
            R.id.SignUp  ->{
                startActivity(Intent(this, Registration::class.java))
            }
        }

    }

    private fun doLogin(){
        val PASSWORD__PATTERN = Regex(pattern = "[0-9a-zA-Z]{8,15}")
        val matched = PASSWORD__PATTERN.matches(editPassword.text.toString())

        if (editEmail.text.toString().isEmpty()) {
            editEmail.error = "Введите email"
            editEmail.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(editEmail.text.toString()).matches()) {
            editEmail.error = "Введите корректный email"
            editEmail.requestFocus()
            return
        }
        if (editEmail.text.length>30) {
            editEmail.error = "email должен содержать не более 30 символов"
            editEmail.requestFocus()
            return
        }
        if (editEmail.text.length<10) {
            editEmail.error = "email должен содержать не менее 10 символов"
            editEmail.requestFocus()
            return
        }
        if (editPassword.text.toString().isEmpty()) {
            editEmail.error = "Введите пароль"
            editEmail.requestFocus()
            return
        }
        if (!matched) {
            editEmail.error = "Пароль должен содержать не менее 8 цифр"
            editEmail.requestFocus()
            return
        }
        else{
            auth.signInWithEmailLink(editEmail.text.toString(), editPassword.text.toString())
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {

                val user = auth.currentUser
                Toast.makeText(
                    baseContext, "Вход выполнен успешно",
                    Toast.LENGTH_SHORT
                ).show()
                updateUI(user)

            } else {
                Toast.makeText(
                    baseContext, "Вход не выполнен" + task.exception,
                    Toast.LENGTH_SHORT
                ).show()

                updateUI(null)
            }
        }
    }
    }
    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null)
            startActivity(Intent(this, ProfileTrener::class.java))
        else {
            Toast.makeText(
                baseContext, "Вход не выполнен",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
  /*  private fun startActivityForResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            val responce = IdpResponse.fromResultIntent(data)

            if(resultCode == Activity.RESULT_OK){

                 val user = FirebaseAuth.getInstance().currentUser
                Toast.makeText(applicationContext, "Вход выполнен успешно", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ProfileTrener::class.java))

            }
            else if(resultCode == Activity.RESULT_CANCELED){
                if(responce==null) return
                when (responce.error?.errorCode)
                {
                    ErrorCodes.NO_NETWORK ->
                        Toast.makeText(applicationContext, "Нет сети", Toast.LENGTH_SHORT).show()
                    ErrorCodes.UNKNOWN_ERROR ->
                        Toast.makeText(applicationContext, "Неизвестая ошибка", Toast.LENGTH_SHORT).show()
                }
            }
        }

}*/

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }


}




