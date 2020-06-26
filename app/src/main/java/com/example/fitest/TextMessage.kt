package com.example.fitest

import java.util.*


data class TextMessage(val text: String,
                       override val time: Date,
                       override val senderId: String,
                       override val recipientId: String,
                       override val senderName: String)
    : Message {
    constructor() : this("", Date(0), "", "", "")
}