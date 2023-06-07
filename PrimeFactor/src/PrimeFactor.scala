object PrimeFactor extends App {
  val n = 600_851_475_143L
  //val n = 13_195L

  private def factorise(n: Long, factors: List[Long], last: Long): List[Long] = {
    if (last > Math.sqrt(n))
      factors
    else
      factorise(n, if (n % last == 0 & isPrime(last)) last :: factors else factors, last + 2)
  }

  private def isPrime(n: Long): Boolean = {
    if (n == 2) false
    else {
      if (n % 2 == 0) false

      def helper(n: Long, l: Long): Boolean = {
        if (l == n) return true

        if (n % l == 0) false else helper(n, l + 2)
      }

      helper(n, 3)
    }
  }

  factorise(n, Nil, 3).foreach(println(_))
}
