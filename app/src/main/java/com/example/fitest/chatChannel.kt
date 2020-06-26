package com.example.fitest

data class ChatChannel(val userIds: MutableList<String>) {
    constructor() : this(mutableListOf())
}