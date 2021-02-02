package ru.ought.magic_robot

import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect
import io.kotest.core.spec.style.FunSpec

class IntUtilsTest : FunSpec({
    test("modulo works with number in range") {
        val result = 3 modulo 5
        expect(result).toBe(3)
    }

    test("modulo works with number higher than range") {
        val result = 9 modulo 5
        expect(result).toBe(4)
    }

    test("modulo works with number lower than range") {
        val result = -2 modulo 5
        expect(result).toBe(3)
    }
})
