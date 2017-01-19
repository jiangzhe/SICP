package chapter2

/**
  * Created by jiangzhe on 1/19/17.
  */
trait Ex1 {
  type Rat = (Int, Int)

  def numer(rat: Rat): Int = rat._1

  def denom(rat: Rat): Int = rat._2

  def makeRat(n: Int, d: Int): Rat = if (d < 0) (-n, -d) else (n, d)
}