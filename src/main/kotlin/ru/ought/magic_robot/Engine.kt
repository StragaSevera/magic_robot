package ru.ought.magic_robot

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import org.fusesource.jansi.Ansi
import org.jline.terminal.Terminal
import org.jline.utils.NonBlockingReader
import ru.ought.magic_robot.game.Game
import ru.ought.magic_robot.game.GameMessageType.Close
import ru.ought.magic_robot.game.GameMessageType.Render
import ru.ought.magic_robot.game.GameState
import ru.ought.magic_robot.game.screen.StartScreen

class Engine(terminal: Terminal) {
    private val reader = terminal.reader()
    private val exitCodes = arrayOf(NonBlockingReader.EOF, 3, 4)
    private val game = buildDefaultGame()

    // Injecting dependencies into Game
    private fun buildDefaultGame(): Game {
        val gameState = GameState()
        val initialScreen = StartScreen(gameState)
        return Game(initialScreen)
    }

    suspend fun start() = coroutineScope {
        var message = game.process(0.toChar())
        while (true) {
            clr()
            when (message.type) {
                Render -> println(message.content)
                Close -> break
            }
            val input = reader.readSuspending()
            if (input in exitCodes) break
            message = game.process(input.toChar())
        }
    }

    @Suppress("BlockingMethodInNonBlockingContext", "ControlFlowWithEmptyBody")
    private suspend fun NonBlockingReader.readSuspending() = withContext(Dispatchers.IO) {
        var result = read()
        // Unifying Windows CR to LF
        if (result == 13) result = 10
        // Skipping additional characters that can be added by a "dumb" terminal
        while (read(1) != NonBlockingReader.READ_EXPIRED) {
        }
        result
    }

    private fun clr() {
        print(Ansi.ansi().eraseScreen().cursor(1, 1))
    }
}