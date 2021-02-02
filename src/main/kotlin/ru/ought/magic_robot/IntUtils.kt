package ru.ought.magic_robot

infix fun Int.modulo(argument: Int): Int {
    var result = this % argument
    if (result < 0) result += argument
    return result
}