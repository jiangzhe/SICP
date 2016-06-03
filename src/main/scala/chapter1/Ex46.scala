package chapter1

/**
  * Ex46
  * --
  * Desc:
  * Changes:
  * 2016/6/3 - Created by z_jiang.
  * --
  */
trait Ex46 {
  def iterativeImprove(goodEnough: (Double, Double) => Boolean, improve: Double => Double): Double => Double =
    guess => {
      val next = improve(guess)
      if (goodEnough(guess, next)) next
      else iterativeImprove(goodEnough, improve)(next)
    }

  def sqrt(x: Double): Double = {
    def goodEnough = (a: Double, b: Double) => Math.abs(a - b) < 0.00001
    def improve(guess: Double): Double = (guess + x / guess) / 2
    iterativeImprove(goodEnough, improve)(x)
  }

  def fixedPoint(f: Double => Double, firstGuess: Double): Double = {
    def goodEnough = (a: Double, b: Double) => Math.abs(a - b) < 0.00001
    iterativeImprove(goodEnough, f)(firstGuess)
  }
}
