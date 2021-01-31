package ru.ought.magic_robot.ui.screen

import ru.ought.magic_robot.mechanics.GameState

class DummyScreen(state: GameState) : Screen(state) {
    override fun process(input: Char): ScreenMessage {
        error("Unable to render a dummy screen!")
    }
}