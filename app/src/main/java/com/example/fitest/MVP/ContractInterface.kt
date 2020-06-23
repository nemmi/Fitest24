package com.example.fitest.MVP

import android.os.Bundle
import android.view.View

interface ContractInterface {
    interface View{
        fun hideSystemUI()
        fun onWindowFocusChanged(hasFocus: Boolean)
        fun AuthClick( view: android.view.View)
        fun doLogin()

    }

    interface Presenter{


    }

    interface Model{

    }

}