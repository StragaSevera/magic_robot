package ru.ought.magic_robot.mechanics

import ru.ought.magic_robot.mechanics.Element.*
import ru.ought.magic_robot.modulo

enum class Element {
    Wood, Fire, Earth, Metal, Water;

    val nextGen get() = GeneratingCycle.next(this)
    val prevGen get() = GeneratingCycle.prev(this)
    val nextOver get() = OvercomingCycle.next(this)
    val prevOver get() = OvercomingCycle.prev(this)

}

private sealed class Cycle {
    protected abstract val cycle: Array<Element>
    operator fun get(i: Int) = cycle[i modulo Element.values().size]
    fun next(element: Element) = get(cycle.indexOf(element) + 1)
    fun prev(element: Element) = get(cycle.indexOf(element) - 1)
}

private object GeneratingCycle : Cycle() {
    override val cycle = arrayOf(Wood, Fire, Earth, Metal, Water)
}

private object OvercomingCycle : Cycle() {
    override val cycle = arrayOf(Wood, Earth, Water, Fire, Metal)
}