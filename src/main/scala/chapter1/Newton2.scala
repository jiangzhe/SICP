package chapter1

/**
  * Newton2
  * --
  * Desc:
  * Changes:
  * 2016/6/3 - Created by z_jiang.
  * --
  */
trait Newton2 {
  object Algo extends Ex35
  def dx = 0.00001
  def derive(g: Double => Double): Double => Double = x => (g(x + dx) - g(x)) / dx
  def newtonTransform(g: Double => Double): Double => Double = {
    val dg = derive(g)
    x => x - g(x) / dg(x)
  }

  def newtonMethod(g: Double => Double, firstGuess: Double): Double = {
    val f = newtonTransform(g)
    Algo.fixedPoint(f, firstGuess)
  }

}
