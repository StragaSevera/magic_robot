package ru.ought.magic_robot.ui.screen

import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect
import io.kotest.core.spec.style.FunSpec
import ru.ought.magic_robot.mechanics.GameState

class DummyScreenTest : FunSpec({
    test("it works") {
        val screen = DummyScreen(GameState())
        expect { screen.process('a') }.toThrow<IllegalStateException>()
    }
})