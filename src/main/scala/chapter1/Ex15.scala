package chapter1

/**
  * Ex15
  * --
  * Desc:
  * Changes:
  * 2016/5/31 - Created by z_jiang.
  * --
  */
trait Ex15 {
  def cube(x: Double): Double = x * x * x
  def p(x: Double): Double = x * 3 - cube(x) * 4
  def sine(angle: Double): Double = if (Math.abs(angle) <= 0.1) angle else p(sine(angle / 3.0))
}
