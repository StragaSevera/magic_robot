package ru.ought.magic_robot.ui

import ru.ought.magic_robot.ui.screen.Screen

class UI(var screen: Screen) {
    fun process(input: Char): UIMessage {
        val (content, newScreen) = screen.process(input)
        screen = newScreen
        return content
    }
}