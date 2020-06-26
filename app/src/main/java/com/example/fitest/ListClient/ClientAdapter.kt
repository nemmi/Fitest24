package com.example.fitest.ListClient

import android.app.Person
import android.view.View
import android.view.ViewGroup
import com.example.firestoreadapter.FirestoreAdapter
import com.example.firestoreadapter.QueryCreator
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.item_client.view.*

class ClientAdapter(query: QueryCreator) : FirestoreAdapter<State, ClientViewHolder>(State::class.java, query) {
    var onItemClick: ((pos: Int, view: View) -> Unit)? = null
    var onDeleteListener: ((position: Int) -> Unit)? = null
    var onUpListener: ((position: Int) -> Unit)? = null
    var onClickListener: ((position: Int, name:String) -> Unit)? = null
    var setOnClick:((Person)-> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val holder = ClientViewHolder.inflate(parent)
        /*  holder.buttonDelete.setOnClickListener {
              val position = holder.adapterPosition
              onDeleteListener?.invoke(position)
          }
          holder.buttonUp.setOnClickListener {
              val position = holder.adapterPosition
              onUpListener?.invoke(position)
          }*/

/*holder.imagebutton.setOnClickListener {
    fun onClick(v: View) {
        val position = holder.adapterPosition
        onItemClick?.invoke(position, v)
    }
}*/

        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition

            onClickListener?.invoke(position, this.get(position).email)
        }
        /*  holder.itemView.setOnClickListener {
              val position = holder.adapterPosition
              onClickListener?.invoke(position)
          }*/
        return holder
    }


    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        holder.bind(get(position))


    }
}