package chapter1

/**
  * HighOrder
  * --
  * Desc:
  * Changes:
  * 2016/6/2 - Created by z_jiang.
  * --
  */
trait HighOrder {

  def sum(term: Long => Long, a: Long, next: Long => Long, b: Long): Long =
    if (a > b) 0
    else term(a) + sum(term, next(a), next, b)

  def inc(n: Long): Long = n + 1
  def cube(n: Long): Long = n * n * n

  def integral(f: Double => Double, a: Double, b: Double, dx: Double): Double = {
    def sum(term: Double => Double, a: Double, b: Double, next: Double => Double, s: Double): Double =
      if (a > b) s
      else sum(term, next(a), b, next, s + term(a) * dx)

    def addDx(n: Double): Double = n + dx
    sum(f, a + addDx(a) / 2, b, addDx, 0.0)
  }
}
