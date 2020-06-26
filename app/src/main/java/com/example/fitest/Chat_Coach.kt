package com.example.fitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitest.ListClient.ListClient
import com.example.fitest.RecyclerSpisocChatov.SpisocChatov


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ListenerRegistration
import java.util.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder

import kotlinx.android.synthetic.main.activity_chat_coach.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast


import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException

class Chat_Coach : AppCompatActivity() {

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
        var otherUserId = intent.getStringExtra("id")
        // Log.i("NewActivity", value)

        FirestoreUtil.getOrCreateChatChannel(otherUserId)
        { channelId ->
            currentChannelId = channelId

            messagesListenerRegistration =
                FirestoreUtil.addChatMessagesListener(channelId, this, this::updateRecyclerView)

            floatingActionButton.setOnClickListener{
                if (editText3.text.toString().isNotEmpty()) {
                    val messageToSend =
                        TextMessage(
                            editText3.text.toString(), Calendar.getInstance().time,
                            FirebaseAuth.getInstance().currentUser!!.uid,
                            otherUserId, FirebaseAuth.getInstance().currentUser?.uid?.let {
                                firestoreInstance.collection("treners").document(it).addSnapshotListener{snapshot: DocumentSnapshot?, exception: FirebaseFirestoreException? ->
                                    snapshot?.getString("name")
                                }}.toString()
                        )
                    editText3.setText("")
                    FirestoreUtil.sendMessage(messageToSend, channelId)
                }
            }
        }

    }

    fun chatCoachClick(view: View) {
        when (view.id) {
            R.id.profile -> {
                val intent = Intent(this, ProfileTrener::class.java)
                startActivity(intent)
            }
            R.id.button_clients -> {
                val intent = Intent(this, ListClient::class.java)
                startActivity(intent)
            }
            R.id.button_clients_profile -> {
                val intent = Intent(this, ProfileClientView::class.java)
                startActivity(intent)
            }
            R.id.button_chat -> {
                val intent = Intent(this, SpisocChatov::class.java)
                startActivity(intent)
            }
        }
    }
    private fun updateRecyclerView(messages: List<Item>) {
        fun init() {
            recyclerChat.apply {
                layoutManager = LinearLayoutManager(this@Chat_Coach)
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
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}