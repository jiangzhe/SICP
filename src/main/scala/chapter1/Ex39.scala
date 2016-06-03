package chapter1

/**
  * Ex39
  * --
  * Desc:
  * Changes:
  * 2016/6/3 - Created by z_jiang.
  * --
  */
trait Ex39 {
  object Algo extends Ex37
  def tanCf(x: Double, k: Int): Double = {
    val x2 = - x * x
    def d(idx: Int): Double = idx * 2 + 1
    def n(idx: Int): Double = if (idx == 0) x else x2
    Algo.contFracIter(n, d, k)
  }
}
