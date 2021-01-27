package ru.ought.magic_robot

import org.fusesource.jansi.Ansi.ansi
import org.jline.terminal.TerminalBuilder

fun main(@Suppress("UNUSED_PARAMETER") args: Array<String>) {
    val terminal = TerminalBuilder.terminal().apply { enterRawMode() }
    println("Hello World!")
    val reader = terminal.reader()
    if (reader.read() == 'c'.toInt()) {
        println("Closing...")
    } else {
        println("I dunno...")
    }
    println(ansi().eraseScreen().cursor(1, 1).render("@|red,bg_white HELLO, HUMAN!|@"))
    reader.read()
}