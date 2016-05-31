package chapter1


/**
  * Newton
  * --
  * Desc:
  * Changes:
  * 2016/5/19 - Created by z_jiang.
  * --
  */
trait NewtonMethod {
  // x => x*x - 3
  def targetFunction: Double => Double

  def errorLimit: Double = 0.000001
  def epsilon: Double = 0.0001
  def lambda: Double = 1.0

  def goodEnough(guess: Double, x: Double): Boolean = Math.abs(guess - x) < errorLimit

  //
  def improve: Double => Double = {
    x: Double =>
      x - targetFunction(x) / df(x) * lambda
  }

  def newtonIter(x: Double): Double = {
    val guess = improve(x)
    if (goodEnough(guess, x)) guess
    else newtonIter(guess)
  }

  def df: Double => Double = {
    x: Double =>
      (targetFunction(x + epsilon) - targetFunction(x - epsilon)) / epsilon / 2
  }

  def newton: Double = newtonIter(1.0)
}

object NewtonMethodTest extends NewtonMethod {
  override def targetFunction: Double => Double = (x: Double) => x * x - 10

  def main(args: Array[String]): Unit = {
    println(newton)
  }
}
