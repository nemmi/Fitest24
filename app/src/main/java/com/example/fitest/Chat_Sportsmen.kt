package com.example.fitest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager

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
import kotlinx.android.synthetic.main.activity_chat_clients.editText3
import kotlinx.android.synthetic.main.activity_chat_clients.floatingActionButton
import java.util.*


class Chat_Sportsmen : AppCompatActivity() {

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
                        if (editText3.text.toString().isNotEmpty()) {
                            val messageToSend =
                                TextMessage(
                                    editText3.text.toString(), Calendar.getInstance().time,
                                    FirebaseAuth.getInstance().currentUser!!.uid,
                                    otherUserId, FirebaseAuth.getInstance().currentUser?.uid?.let {
                                        firestoreInstance.collection("sportsmen").document(it).addSnapshotListener{snapshot: DocumentSnapshot?, exception: FirebaseFirestoreException? ->
                                            snapshot?.getString("name")
                                        }}.toString()
                                )
                            editText3.setText("")
                            FirestoreUtilSportsmen.sendMessage(messageToSend, channelId)
                        }
                    }
                }

            }}


    }

    fun chatSportClick(view: View) {
        when (view.id) {
            R.id.profile -> {
                val intent = Intent(this, ProfileClient::class.java)
                startActivity(intent)
            }
            R.id.button_training -> {
                val intent = Intent(this, Trainings_Sportsmen::class.java)
                startActivity(intent)
            }
            R.id.button_eats -> {
                val intent = Intent(this, Pitanie::class.java)
                startActivity(intent)
            }
        }
    }

    private fun updateRecyclerView(messages: List<Item>) {
        fun init() {
            recyclerChat.apply {
                layoutManager = LinearLayoutManager(this@Chat_Sportsmen)
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