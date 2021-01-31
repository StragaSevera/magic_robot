package ru.ought.magic_robot

enum class MessageType {
    Render, Close
}

data class Message(val type: MessageType, val content: String = "") {
    companion object {
        fun render(content: String) = Message(MessageType.Render, content)
        fun close() = Message(MessageType.Close)
    }
}

class Game {
    private val tickMessages = listOf(Message.render("Ticked!"), Message.render("Now will close..."), Message.close())
    private val tickIterator = tickMessages.iterator()

    fun start(): Message {
        return Message.render("Started!")
    }

    fun tick(input: Char): Message {
        return tickIterator.next()
    }
}