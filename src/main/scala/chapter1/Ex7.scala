package chapter1

/**
 * Created by TOSHIBA on 2015/5/26.
 */
object Ex7 {
  private def sqrtIter(guess: Double, oldGuess: Double, x: Double): Double = {
    if (goodEnough(guess, oldGuess)) guess
    else sqrtIter(improve(guess, x), guess, x)
  }
  private def improve(guess: Double, x: Double) = average(guess, x / guess)
  private def average(x: Double, y: Double) = (x + y) / 2
  private def square(x: Double) = x * x

  def sqrt(x: Double) = {
    val oldGuess = 1.0
    val newGuess = improve(oldGuess, x)
    sqrtIter(newGuess, oldGuess, x)
  }

  private def goodEnoughNaive(guess: Double, x: Double) = scala.math.abs(square(guess) - x) < 0.001
  private def goodEnoughThanOld(guess: Double, oldGuess: Double) = scala.math.abs(guess - oldGuess) < 0.001

  private val goodEnough = goodEnoughThanOld _
}
