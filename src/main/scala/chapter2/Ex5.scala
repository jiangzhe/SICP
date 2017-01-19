package chapter2

import scala.annotation.tailrec

/**
  * Created by jiangzhe on 1/19/17.
  */
trait Ex5 {
  def cons(x: Int, y: Int): Int = (Math.pow(2, x) * Math.pow(3, y)).toInt

  def car(z: Int): Int = rec(z, 2, 0)

  def cdr(z: Int): Int = rec(z, 3, 0)

  // no consideration on perf
  @tailrec
  private def rec(z: Int, divider: Int, acc: Int): Int = {
    if ((z % divider) == 0) acc
    else rec(z / divider, divider, acc + 1)
  }
}
