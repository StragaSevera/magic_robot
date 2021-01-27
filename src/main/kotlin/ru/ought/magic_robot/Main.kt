package ru.ought.magic_robot

import kotlinx.coroutines.runBlocking
import org.jline.terminal.TerminalBuilder

fun main(@Suppress("UNUSED_PARAMETER") args: Array<String>) = runBlocking {
    val terminal = TerminalBuilder.terminal().apply { enterRawMode() }
    Engine(terminal, this).start()
}