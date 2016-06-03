package chapter1

/**
  * Prime
  * --
  * Desc:
  * Changes:
  * 2016/6/1 - Created by z_jiang.
  * --
  */
trait Prime {
  def smallestDivisor(n: Long): Long = findDivisor(n, 2)

  def findDivisor(n: Long, testDivisor: Long): Long =
    if (testDivisor * testDivisor > n) n
    else if (divides(testDivisor, n)) testDivisor
    else findDivisor(n, testDivisor + 1)

  def divides(a: Long, b: Long): Boolean = b % a == 0

  def prime(n: Long): Boolean = n == smallestDivisor(n)

}
