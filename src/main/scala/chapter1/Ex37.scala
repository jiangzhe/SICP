package chapter1

import scala.annotation.tailrec

/**
  * Ex37
  * --
  * Desc:
  * Changes:
  * 2016/6/2 - Created by z_jiang.
  * --
  */
trait Ex37 {
  // from zero
  def contFrac(n: Int => Double, d: Int => Double, k: Int): Double = {
    def f(idx: Int): Double => Double = x => n(idx) / (d(idx) + x)
    def rec(idx: Int): Double = if (idx == k) 0.0 else f(idx)(rec(idx+1))
    rec(0)
  }

  def contFracIter(n: Int => Double, d: Int => Double, k: Int): Double = {
    def f(idx: Int): Double => Double = x => n(idx) / (d(idx) + x)
    @tailrec
    def iter(idx: Int, result: Double): Double = if (idx == 0) f(0)(result) else iter(idx - 1, f(idx)(result))
    iter(k - 1, 0.0)
  }
}
