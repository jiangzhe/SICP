package chapter1

/**
  * Ex35
  * --
  * Desc:
  * Changes:
  * 2016/6/2 - Created by z_jiang.
  * --
  */
trait Ex35 {
  def tolerance = 0.00001
  def fixedPoint(f: Double => Double, firstGuess: Double): Double = {
    def closeEnough(v1: Double, v2: Double): Boolean = Math.abs(v1 - v2) < tolerance
    def iter(guess: Double): Double = {
      val next = f(guess)
      if (closeEnough(next, guess)) next else {
        println(next)
        iter(next)
      }
    }
    iter(firstGuess)
  }

  def averageFixedPoint(f: Double => Double, firstGuess: Double): Double = {
    val avg: Double => Double = x => (x + f(x)) / 2
    fixedPoint(avg, firstGuess)
  }
}
