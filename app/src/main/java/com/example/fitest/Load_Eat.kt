package com.example.fitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
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
    }

    fun eatLoadClick(view: View) {
        when (view.id){
            R.id.monday ->{

            }
            R.id.tuesday ->{

            }
            R.id.wednesday ->{

            }
            R.id.thursday ->{

            }
            R.id.friday ->{

            }
            R.id.saturday ->{

            }
            R.id.sunday ->{

            }
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
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}
