package ru.ought.magic_robot

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.fusesource.jansi.Ansi
import org.jline.terminal.Terminal
import org.jline.utils.NonBlockingReader
import ru.ought.magic_robot.MessageType.Close
import ru.ought.magic_robot.MessageType.Render

class Engine(terminal: Terminal) {
    private val reader = terminal.reader()
    private val game = Game()
    private val exitCodes = arrayOf(NonBlockingReader.EOF, 3, 4)

    suspend fun start() {
        var message = game.start()
        while (true) {
            clr()
            when (message.type) {
                Render -> println(message.content)
                Close -> break
            }
            val input = reader.readSuspending()
            if (input in exitCodes) break
            message = game.tick(input.toChar())
        }
    }

    @Suppress("BlockingMethodInNonBlockingContext", "ControlFlowWithEmptyBody")
    private suspend fun NonBlockingReader.readSuspending() = withContext(Dispatchers.IO) {
        var result = read()
        // Unifying Windows CR to LF
        if (result == 13) result = 10
        // Skipping additional characters that can be added by a "dumb" terminal
        while (read(1) != NonBlockingReader.READ_EXPIRED) {}
        result
    }

    private fun clr() {
        print(Ansi.ansi().eraseScreen().cursor(1, 1))
    }
}