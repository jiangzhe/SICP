package chapter1

/**
  * Ex38
  * --
  * Desc:
  * Changes:
  * 2016/6/3 - Created by z_jiang.
  * --
  */
trait Ex38 {
  object Algo extends Ex37

  def calcE(n: Int): Double = {
    def d(idx: Int): Double = if ((idx % 3) == 1) (idx / 3 + 1) * 2 else 1
    Algo.contFracIter(_ => 1.0, d, 10) + 2
  }
}
