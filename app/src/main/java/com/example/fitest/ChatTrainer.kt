package com.example.fitest


import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ListenerRegistration
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_chat_clients.*
import kotlinx.android.synthetic.main.activity_chat_coach.*
import kotlinx.android.synthetic.main.activity_chat_coach.floatingActionButton
import kotlinx.android.synthetic.main.activity_chat_coach.recyclerChat
import kotlinx.android.synthetic.main.activity_chat_coach.writeMessage
import java.util.*

class ChatTrainer : AppCompatActivity() {

    private lateinit var currentChannelId: String
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    private lateinit var messagesListenerRegistration: ListenerRegistration

    private var shouldInitRecyclerView = true
    private lateinit var messagesSection: Section

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
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chat_coach)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        var otherUserId = intent.getStringExtra("id")
        // Log.i("NewActivity", value)

        FirestoreUtil.getOrCreateChatChannel(otherUserId)
        { channelId ->
            currentChannelId = channelId

            messagesListenerRegistration =
                FirestoreUtil.addChatMessagesListener(channelId, this, this::updateRecyclerView)

            floatingActionButton.setOnClickListener{
                if(IsInternetAvailable.isInternetAvailable(this)){
                    if (writeMessage.text.toString().isNotEmpty()) {
                        val messageToSend =
                            TextMessage(
                                writeMessage.text.toString(), Calendar.getInstance().time,
                                FirebaseAuth.getInstance().currentUser!!.uid,
                                otherUserId, FirebaseAuth.getInstance().currentUser?.uid?.let {
                                    firestoreInstance.collection("treners").document(it).addSnapshotListener{snapshot: DocumentSnapshot?, exception: FirebaseFirestoreException? ->
                                        snapshot?.getString("name")
                                    }}.toString()
                            )
                        writeMessage.setText("")
                        FirestoreUtil.sendMessage(messageToSend, channelId)
                    }
                    else{
                        writeMessage.error=resources.getString(R.string.error_message)
                        writeMessage.requestFocus()
                    }
                }
                else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }

    }

    fun chatCoachClick(view: View) {
        var otherUserId = intent.getStringExtra("id")
        when (view.id) {
            R.id.profile -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    val intent = Intent(this, ProfileTrainer::class.java)
                    startActivity(intent)
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            R.id.buttonClients -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    val intent = Intent(this, ListClient::class.java)
                    startActivity(intent)
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            R.id.buttonClientsProfile -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    val intent = Intent(this, ProfileClientView::class.java)
                    Log.i("DocId", otherUserId)
                    intent.putExtra("id", otherUserId)
                    Log.i("Intent", otherUserId)

                    startActivity(intent)
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            R.id.buttonChat -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    val intent = Intent(this, SpisocChatov::class.java)
                    startActivity(intent)
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))

                }
            }
        }
    }
    private fun updateRecyclerView(messages: List<Item>) {
        fun init() {
            recyclerChat.apply {
                layoutManager = LinearLayoutManager(this@ChatTrainer)
                adapter = GroupAdapter<ViewHolder>().apply {
                    messagesSection = Section(messages)
                    this.add(messagesSection)
                }
            }
            shouldInitRecyclerView = false
        }

        fun updateItems() = messagesSection.update(messages)

        if (shouldInitRecyclerView)
            init()
        else
            updateItems()

        recyclerChat.scrollToPosition(recyclerChat.adapter!!.itemCount - 1)
    }

    fun alert(){
        Toast.makeText(
            baseContext, resources.getString(R.string.error_internet),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val view = window.decorView
        if (hasFocus) {//hideSystemUI()
            view.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            )
        }
    }
}