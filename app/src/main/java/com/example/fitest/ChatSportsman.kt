package com.example.fitest

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
import kotlinx.android.synthetic.main.activity_chat_clients.writeMessage
import kotlinx.android.synthetic.main.activity_chat_clients.floatingActionButton
import java.util.*


class ChatSportsman : AppCompatActivity() {

    private lateinit var currentChannelId: String
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    private lateinit var messagesListenerRegistration: ListenerRegistration
    private var shouldInitRecyclerView = true
    private lateinit var messagesSection: Section


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
        setContentView(R.layout.activity_chat_clients)

        FirebaseAuth.getInstance().currentUser?.uid?.let {
            firestoreInstance.collection("sportsmen").document(it).addSnapshotListener{
                    snapshot: DocumentSnapshot?, exception: FirebaseFirestoreException? ->
                val otherUserId= snapshot!!.getString("myTrener").toString()

                FirestoreUtilSportsmen.getOrCreateChatChannel(otherUserId)
                { channelId ->
                    currentChannelId = channelId

                    messagesListenerRegistration =
                        FirestoreUtilSportsmen.addChatMessagesListener(channelId, this, this::updateRecyclerView)
                    floatingActionButton.setOnClickListener {
                        if(IsInternetAvailable.isInternetAvailable(this)){
                            if (writeMessage.text.toString().isNotEmpty()) {
                                val messageToSend =
                                    TextMessage(
                                        writeMessage.text.toString(), Calendar.getInstance().time,
                                        FirebaseAuth.getInstance().currentUser!!.uid,
                                        otherUserId, FirebaseAuth.getInstance().currentUser?.uid?.let {
                                            firestoreInstance.collection("sportsmen").document(it).addSnapshotListener{snapshot: DocumentSnapshot?, exception: FirebaseFirestoreException? ->
                                                snapshot?.getString("name")
                                            }}.toString()
                                    )
                                writeMessage.setText("")
                                FirestoreUtilSportsmen.sendMessage(messageToSend, channelId)
                            }
                            else{
                                writeMessage.error=resources.getString(R.string.error_message)
                                writeMessage.requestFocus()
                            }
                        }
                        else {
                            alert()
                            startActivity(Intent(this, MainActivity::class.java))}
                    }
                }

            }}


    }

    fun chatSportClick(view: View) {
        when (view.id) {
            R.id.profile -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    val intent = Intent(this, ProfileClient::class.java)
                    startActivity(intent)
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            R.id.buttonTraining -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    val intent = Intent(this, TrainingsSportsman::class.java)
                    startActivity(intent)
                } else {
                    alert()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            R.id.buttonEats -> {
                if (IsInternetAvailable.isInternetAvailable(this)) {
                    val intent = Intent(this, Eat::class.java)
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
                layoutManager = LinearLayoutManager(this@ChatSportsman)
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
        if (hasFocus) hideSystemUI()
    }
}