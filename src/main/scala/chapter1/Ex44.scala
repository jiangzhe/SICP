package chapter1

/**
  * Ex44
  * --
  * Desc:
  * Changes:
  * 2016/6/3 - Created by z_jiang.
  * --
  */
trait Ex44 {
  object Algo extends Ex43

  def dx = 0.00001
  def smooth(f: Double => Double): Double => Double = x => (f(x + dx) + f(x) + f(x - dx)) / 3

  def smoothN(f: Double => Double, n: Int): Double => Double = Algo.repeat(smooth(f), n)
}
