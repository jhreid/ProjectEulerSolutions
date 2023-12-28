fun main() {
    var daysSinceASunday = 366
    var sundaysOnFirst = 0
    for (year in 1901..2000) {
        for (month in 1..12) {
            println("Month $month, Year $year, days ${daysInMonth(month, year)}")
            if (daysSinceASunday % 7 == 0) {
                sundaysOnFirst += 1
                println("Got a Sunday")
            }
            daysSinceASunday += daysInMonth(month, year)
        }
    }
    println(sundaysOnFirst)
}

fun isLeapYear(year: Int): Boolean {
    return when {
        year % 400 == 0 -> true
        year % 100 == 0 -> false
        year % 4 == 0 -> true
        else -> false
    }
}

fun daysInMonth(month: Int, year: Int): Int {
    return when(month) {
        4, 6, 9, 11 -> 30
        2 -> if (isLeapYear(year)) 29 else 28
        else -> 31
    }
}