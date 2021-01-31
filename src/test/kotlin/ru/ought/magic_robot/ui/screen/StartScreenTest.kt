package ru.ought.magic_robot.ui.screen

import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect
import io.kotest.core.spec.style.FunSpec
import ru.ought.magic_robot.ui.UIMessage
import ru.ought.magic_robot.mechanics.GameState

class StartScreenTest : FunSpec({
    test("it works") {
        val screen = StartScreen(GameState())

        val message = screen.process('0')

        expect(message.next).isA<DummyScreen>()
        expect(message.message).toBe(UIMessage.render("This is a Magic Robot.\nPress any key to start combat..."))
    }
})