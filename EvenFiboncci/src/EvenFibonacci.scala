object EvenFibonacci extends App{
  def evenFib(total: Int, fib1: Int, fib2: Int, maxFib: Int): Int = {
    if (fib2 > maxFib) return total

    evenFib(if (fib2 % 2 == 0) total + fib2 else total, fib2, fib1 + fib2, maxFib)
  }

  println(evenFib(0, 1, 1, 4_000_000))
}
