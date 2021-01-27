package ru.ought.magic_robot

import org.jline.terminal.TerminalBuilder

fun main(@Suppress("UNUSED_PARAMETER") args: Array<String>) {
    val terminal = TerminalBuilder.terminal().apply { enterRawMode() }
    Engine(terminal).start()
}