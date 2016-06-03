package chapter1

/**
  * Ex30
  * --
  * Desc:
  * Changes:
  * 2016/6/2 - Created by z_jiang.
  * --
  */
trait Ex31 {
  def product(term: Double => Double, a: Double, next: Double => Double, b: Double): Double =
    if (a > b) 1.0
    else term(a) * product(term, next(a), next, b)

  def factorial(n: Int): Double = product(x => x, 1.0, _ + 1.0, n.toDouble)

  def simPi(n: Int): Double = {
    def term(idx: Double): Double = {
      val nom = ((idx.toInt + 3) >> 1) << 1
      val denom = (((idx.toInt + 2) >> 1) << 1) + 1
      nom.toDouble / denom
    }
    product(term, 0.0, _ + 1, n.toDouble) * 4
  }

  def product2(term: Double => Double, a: Double, next: Double => Double, b: Double): Double = {
    def iter(term: Double => Double, a: Double, next: Double => Double, b: Double, p: Double): Double =
      if (a > b) p
      else iter(term, next(a), next, b, p * term(a))
    iter(term, a, next, b, 1.0)
  }
}
