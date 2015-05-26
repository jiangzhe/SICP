package chapter1

/**
 * Created by TOSHIBA on 2015/5/26.
 */
object Ex8 {
  private def cubeRootIter(guess: Double, oldGuess: Double, x: Double): Double = {
    if (goodEnough(guess, oldGuess)) guess
    else cubeRootIter(improve(guess, x), guess, x)
  }
  private def goodEnough(guess: Double, oldGuess: Double) = scala.math.abs(guess - oldGuess) < 0.001
  private def improve(guess: Double, x: Double) = (x / guess / guess + 2 * guess) / 3

  def cubeRoot(x: Double) = {
    val oldGuess = 1.0
    val newGuess = improve(1.0, x)
    cubeRootIter(newGuess, oldGuess, x)
  }
}
