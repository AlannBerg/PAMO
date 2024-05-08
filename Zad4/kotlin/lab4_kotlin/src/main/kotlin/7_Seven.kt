/**
 * https://kotlinlang.org/docs/kotlin-reference.pdf
 *
 * Using a when expression, update the following program so that when you input the names of Game Boy buttons, the actions are printed to output.
 *
 * fun main() {
 * val button = "A"
 * println(
 * // Write your code here
 * ) }
 */

fun main() {
    val button = "A"
    println(
        when (button) {
            "A" -> "Jump"
            "B" -> "Run"
            "Start" -> "Pause"
            "Select" -> "Menu"
            else -> "Unknown button"
        }
    )
}