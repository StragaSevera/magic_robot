package ru.ought.magic_robot.game.screen

import ru.ought.magic_robot.game.GameMessage
import ru.ought.magic_robot.game.GameState

data class ScreenMessage(val message: GameMessage, val next: Screen)

abstract class Screen(private val state: GameState) {
    abstract fun process(input: Char): ScreenMessage

    fun render(content: String, next: Screen) = ScreenMessage(GameMessage.render(content), next)
    fun close() = ScreenMessage(GameMessage.close(), DummyScreen(state))
}

class DummyScreen(state: GameState) : Screen(state) {
    override fun process(input: Char): ScreenMessage {
        error("Unable to render a dummy screen!")
    }
}