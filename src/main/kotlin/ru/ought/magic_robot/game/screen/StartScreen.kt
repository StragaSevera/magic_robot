package ru.ought.magic_robot.game.screen

import ru.ought.magic_robot.game.GameState

class StartScreen(state: GameState) : Screen(state) {
    override fun process(input: Char): ScreenMessage {
        return render("This is a Magic Robot.\nPress any key to start combat...", DummyScreen(state))
    }
}