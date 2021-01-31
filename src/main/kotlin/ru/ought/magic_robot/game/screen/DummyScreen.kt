package ru.ought.magic_robot.game.screen

import ru.ought.magic_robot.game.GameState

class DummyScreen(state: GameState) : Screen(state) {
    override fun process(input: Char): ScreenMessage {
        error("Unable to render a dummy screen!")
    }
}