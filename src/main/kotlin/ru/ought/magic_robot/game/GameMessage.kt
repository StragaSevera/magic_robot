package ru.ought.magic_robot.game

enum class GameMessageType {
    Render, Close
}

data class GameMessage(val type: GameMessageType, val content: String = "") {
    companion object {
        fun render(content: String) = GameMessage(GameMessageType.Render, content)
        fun close() = GameMessage(GameMessageType.Close)
    }
}