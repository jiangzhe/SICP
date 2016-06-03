package chapter1

/**
  * Ex40
  * --
  * Desc:
  * Changes:
  * 2016/6/3 - Created by z_jiang.
  * --
  */
trait Ex40 {
  object Algo extends Newton2

  def cubic(a: Double, b: Double, c: Double): Double => Double = x => x*x*x + a * x*x + b * x + c

  def solve(a: Double, b: Double, c: Double): Double = Algo.newtonMethod(cubic(a, b, c), 1.0)
}
