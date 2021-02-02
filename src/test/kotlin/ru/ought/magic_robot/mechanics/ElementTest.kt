package ru.ought.magic_robot.mechanics

import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.verbs.expect
import io.kotest.core.datatest.forAll
import io.kotest.core.spec.style.FunSpec
import ru.ought.magic_robot.mechanics.Element.*

class ElementTest : FunSpec({
    context("cycles") {
        context("generating cycle correctly gets next and previous element") {
            forAll(
                Wood to Fire, Fire to Earth, Earth to Metal, Metal to Water, Water to Wood
            ) { (a, b) ->
                expect(a.nextGen).toBe(b)
                expect(b.prevGen).toBe(a)
            }
        }

        context("overcoming cycle correctly gets next and previous element") {
            forAll(
                Wood to Earth, Earth to Water, Water to Fire, Fire to Metal, Metal to Wood
            ) { (a, b) ->
                expect(a.nextOver).toBe(b)
                expect(b.prevOver).toBe(a)
            }
        }
    }
})