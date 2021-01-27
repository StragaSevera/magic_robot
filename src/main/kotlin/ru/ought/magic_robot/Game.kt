package ru.ought.magic_robot

enum class MessageType {
    Render, Close
}
data class Message(val type: MessageType, val content: String = "")

