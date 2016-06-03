package chapter1

/**
  * FixedPoint
  * --
  * Desc:
  * Changes:
  * 2016/6/2 - Created by z_jiang.
  * --
  */
trait FixedPoint {
  def tolerance = 0.000001
  def fixedPoint(f: Double => Double, firstGuess: Double): Double = {
    def closeEnough(v1: Double, v2: Double) = Math.abs(v1 - v2) < tolerance
    def tryGuess(guess: Double): Double = {
      val next = f(guess)
      if (closeEnough(guess, next)) next else tryGuess(next)
    }
    tryGuess(firstGuess)
  }

}
