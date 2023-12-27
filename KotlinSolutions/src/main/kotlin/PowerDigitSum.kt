import java.math.BigInteger

fun main() {
    var two = BigInteger("2")

    for (i in 2..1000) {
        two *= BigInteger("2")
    }

    println(two.toString().toCharArray().fold(0) { acc, next -> acc + next.digitToInt() })
}
