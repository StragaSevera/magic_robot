package ru.ought.magic_robot.game

import ru.ought.magic_robot.game.screen.Screen

class GameState

class Game(var screen: Screen) {
    fun process(input: Char): GameMessage {
        val (content, newScreen) = screen.process(input)
        screen = newScreen
        return content
    }
}