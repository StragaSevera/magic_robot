package ru.ought.magic_robot.ui.screen

import ru.ought.magic_robot.mechanics.GameState

class StartScreen(state: GameState) : Screen(state) {
    override fun process(input: Char): ScreenMessage {
        return render("This is a Magic Robot.\nPress any key to start combat...", DummyScreen(state))
    }
}