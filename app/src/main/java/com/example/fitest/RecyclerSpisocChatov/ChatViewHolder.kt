package com.example.fitest.RecyclerSpisocChatov


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitest.R

class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun inflate(parent: ViewGroup): ChatViewHolder {
            return ChatViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chat, parent, false))
        }
    }

    var textTitle: TextView = itemView.findViewById(R.id.listName)
    // var textSubtitle: TextView = itemView.findViewById(R.id.text_subtitle)

    //   var buttonDelete: View = itemView.findViewById(R.id.button_delete)
    //  var buttonUp: View = itemView.findViewById(R.id.button_up)

    fun bind(state: State) {
        textTitle.text = state.name
        //  textSubtitle.text = state.abbreviation

    }
}