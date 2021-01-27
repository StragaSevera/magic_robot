package ru.ought.magic_robot

import kotlinx.coroutines.*
import org.fusesource.jansi.Ansi
import org.jline.terminal.Terminal
import java.io.Reader
import java.math.BigInteger

class Engine(terminal: Terminal, private val scope: CoroutineScope) {
    private val reader = terminal.reader()

    suspend fun start() {
        clr()
        println("Hello World!")
        val sumOfBigNumbers = sumOfBigNumbers()
        println(sumOfBigNumbers)
        reader.readSuspending()
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    private suspend fun Reader.readSuspending() {
        withContext(Dispatchers.IO) { read() }
    }

    private suspend fun sumOfBigNumbers(): BigInteger {
        val deferreds = (0..10_000_000_000 step 100_000_000)
            .map(Long::toBigInteger)
            .zipWithNext { a, b ->
                scope.async(Dispatchers.Default) {
                    var result = BigInteger.ZERO
                    for ((counter, i) in (a..b).withIndex()) {
                        result += i
                        if (counter % 1_000_000 == 0 && counter != 0) {
                            log("Progress for $a..$b: #$counter $result")
                            yield()
                        }
                    }
                    log("Finished for $a..$b: $result")
                    result
                }
            }
        return deferreds.map { it.await() }.sumOf { it }
    }

    private fun clr() {
        print(Ansi.ansi().eraseScreen().cursor(1, 1))
    }
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

operator fun BigInteger.rangeTo(other: BigInteger) =
    BigIntegerRange(this, other)

class BigIntegerRange(
    override val start: BigInteger,
    override val endInclusive: BigInteger
) : ClosedRange<BigInteger>, Iterable<BigInteger> {
    override operator fun iterator(): Iterator<BigInteger> =
        BigIntegerRangeIterator(this)
}

class BigIntegerRangeIterator(
    private val range: ClosedRange<BigInteger>
) : Iterator<BigInteger> {
    private var current = range.start

    override fun hasNext(): Boolean =
        current <= range.endInclusive

    override fun next(): BigInteger {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        return current++
    }
}