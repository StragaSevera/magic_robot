package ru.ought.magic_robot.ui

enum class UIMessageType {
    Render, Close
}

data class UIMessage(val type: UIMessageType, val content: String = "") {
    companion object {
        fun render(content: String) = UIMessage(UIMessageType.Render, content)
        fun close() = UIMessage(UIMessageType.Close)
    }
}