import org.jline.terminal.TerminalBuilder
import ru.ought.magic_robot.parseArgs
import java.util.*

fun main(args: Array<String>) {
    val params = parseArgs(args)
    val terminal = TerminalBuilder.terminal()
    println("Hello World!")
    val reader = terminal.reader()
    if (reader.read() == 'c'.toInt()) {
        println("Closing...")
    } else {
        println("I dunno...")
    }
    val lol = Scanner(terminal.input()).next()
    println("Lol... $lol")
    reader.read()
}