package ru.ought.magic_robot.ui.screen

import ru.ought.magic_robot.ui.UIMessage
import ru.ought.magic_robot.mechanics.GameState

data class ScreenMessage(val message: UIMessage, val next: Screen)

abstract class Screen(protected val state: GameState) {
    abstract fun process(input: Char): ScreenMessage

    fun render(content: String, next: Screen) = ScreenMessage(UIMessage.render(content), next)
    fun close() = ScreenMessage(UIMessage.close(), DummyScreen(state))
}