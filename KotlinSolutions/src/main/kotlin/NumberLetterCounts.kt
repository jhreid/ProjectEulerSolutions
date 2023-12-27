val singles = mapOf(
    1 to "one",
    2 to "two",
    3 to "three",
    4 to "four",
    5 to "five",
    6 to "six",
    7 to "seven",
    8 to "eight",
    9 to "nine")

val teens = mapOf(
    10 to "ten",
    11 to "eleven",
    12 to "twelve",
    13 to "thirteen",
    14 to "fourteen",
    15 to "fifteen",
    16 to "sixteen",
    17 to "seventeen",
    18 to "eighteen",
    19 to "nineteen"
)

val tens = mapOf(
    2 to "twenty",
    3 to "thirty",
    4 to "forty",
    5 to "fifty",
    6 to "sixty",
    7 to "seventy",
    8 to "eighty",
    9 to "ninety"
)


fun main() {
    val result = (1..1000).map { numberToWords(it) }.fold(0) { acc, next -> next.length + acc}

    println(result)
}

fun numberToWords(number: Int): String {
    return when {
        number < 10 -> singles.getOrDefault(number, "")
        number < 20 -> teens.getOrDefault(number, "")
        number < 100 -> {
            tens[number / 10]!! + singles.getOrDefault(number % 10, "")
        }
        number % 100 == 0 && number < 1000 -> singles[number / 100]!! + "hundred"
        number < 1000 -> {
            singles[number / 100]!! + "hundredand" + numberToWords(number % 100)
        }
        number == 1000 -> "onethousand"
        else -> ""
    }
}

