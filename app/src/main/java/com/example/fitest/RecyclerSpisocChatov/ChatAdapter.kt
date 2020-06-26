package com.example.fitest.RecyclerSpisocChatov

import android.view.ViewGroup
import com.example.firestoreadapter.FirestoreAdapter
import com.example.firestoreadapter.QueryCreator

class ChatAdapter(query: QueryCreator) : FirestoreAdapter<State, ChatViewHolder>(State::class.java, query) {

    var onDeleteListener: ((position: Int) -> Unit)? = null
    var onUpListener: ((position: Int) -> Unit)? = null

    var onClickListener: ((position: Int, name:String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val holder = ChatViewHolder.inflate(parent)
        /*  holder.buttonDelete.setOnClickListener {
              val position = holder.adapterPosition
              onDeleteListener?.invoke(position)
          }
          holder.buttonUp.setOnClickListener {
              val position = holder.adapterPosition
              onUpListener?.invoke(position)
          }*/
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition

            onClickListener?.invoke(position, this.get(position).email)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(get(position))
    }
}