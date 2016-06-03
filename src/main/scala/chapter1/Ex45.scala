package chapter1

/**
  * Ex45
  * --
  * Desc:
  * Changes:
  * 2016/6/3 - Created by z_jiang.
  * --
  */
trait Ex45 {
  object Algo extends FixedPoint with Ex43

  def averageDamp(f: Double => Double): Double => Double = x => (x + f(x)) / 2

  def averageDampK(f: Double => Double, k: Int): Double => Double = Algo.repeat(averageDamp(f), k)



}
