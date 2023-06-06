object Mult3or5 extends App {
  val result = Range(1, 1000).filter(i => i % 3 == 0 || i % 5 == 0 ).foldLeft(0)(_ + _)

  println(result)
}
