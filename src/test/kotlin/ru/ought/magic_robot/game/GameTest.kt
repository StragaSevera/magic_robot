package ru.ought.magic_robot.game

import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.verbs.expect
import io.kotest.core.spec.style.FunSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import ru.ought.magic_robot.game.screen.Screen
import ru.ought.magic_robot.game.screen.ScreenMessage

class GameTest : FunSpec({
    test("it works") {
        val screen1 = mockk<Screen>()
        val screen2 = mockk<Screen>()
        val input = slot<Char>()
        every { screen1.process(capture(input)) } returns ScreenMessage(GameMessage.render("test"), screen2)
        every { screen2.process(capture(input)) } returns ScreenMessage(GameMessage.close(), screen1)
        val game = Game(screen1)

        val result1 = game.process('a')
        expect(input.captured).toBe('a')
        expect(result1).toBe(
            GameMessage(GameMessageType.Render, "test")
        )

        val result2 = game.process('b')
        expect(input.captured).toBe('b')
        expect(result2).toBe(
            GameMessage(GameMessageType.Close)
        )
    }
})