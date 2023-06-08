object LargestPalindrome extends App {
  val range = 999 to 900 by -1

  range.foreach{ i => {
    range.foreach{ j => {
      val n = (i * j).toString
      if (n.equals(n.reverse)) println(n)
    }}
  }}
}
