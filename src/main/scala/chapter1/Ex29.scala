package chapter1

import scala.annotation.tailrec

/**
  * Ex29
  * --
  * Desc:
  * Changes:
  * 2016/6/2 - Created by z_jiang.
  * --
  */
trait Ex29 {
  def simpson(f: Double => Double, a: Double, b: Double, n: Int): Double = {
    val h = (b - a) / n
    def coeff(idx: Int): Int = if (idx == 0 || idx == n) 1 else ((idx & 1) + 1) << 1
    def term(idx: Int): Double = coeff(idx) * f(a + idx * h)
    @tailrec
    def sum(idx: Int, s: Double): Double = if (idx > n) s else sum(idx + 1, s + term(idx))
    sum(0, 0.0) * h / 3
  }
}
