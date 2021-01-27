package ru.ought.magic_robot

import org.fusesource.jansi.Ansi
import org.jline.terminal.Terminal

class Engine(private val terminal: Terminal) {
    private val reader = terminal.reader()

    fun start() {
        clr()
        println("Hello World!")
        reader.read()
    }

    private fun clr() {
        print(Ansi.ansi().eraseScreen().cursor(1, 1))
    }
}