package com.example.fitest


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
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
import kotlinx.android.synthetic.main.activity_chat_coach.*
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
            }
        }

    }

    fun chatCoachClick(view: View) {
        var otherUserId = intent.getStringExtra("id")
        when (view.id) {
            R.id.profile -> {
                val intent = Intent(this, ProfileTrainer::class.java)
                startActivity(intent)
            }
            R.id.buttonClients -> {
                val intent = Intent(this, ListClient::class.java)
                startActivity(intent)
            }
            R.id.buttonClientsProfile -> {
                val intent = Intent(this, ProfileClientView::class.java)
                Log.i("DocId", otherUserId)
                intent.putExtra("id", otherUserId)
                Log.i("Intent", otherUserId)

                startActivity(intent)
            }
            R.id.buttonChat -> {
                val intent = Intent(this, SpisocChatov::class.java)
                startActivity(intent)
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