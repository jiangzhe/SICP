package chapter1

/**
  * GCD
  * --
  * Desc:
  * Changes:
  * 2016/6/1 - Created by z_jiang.
  * --
  */
trait GCD {
  def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)
}
