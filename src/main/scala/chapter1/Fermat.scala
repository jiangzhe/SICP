package chapter1

/**
  * Fermat
  * --
  * Desc:
  * Changes:
  * 2016/6/1 - Created by z_jiang.
  * --
  */
trait Fermat {
  def square(n: Long): Long = n * n

  def expmod(base: Long, exp: Long, m: Long): Long =
    if (exp == 0) 1
    else if ((exp & 1) == 0) square(expmod(base, exp / 2, m)) % m
    else (base * expmod(base, exp - 1, m)) % m

  def fermatTest(n: Long): Boolean = {
    def tryIt(a: Long): Boolean = expmod(a, n, n) == a
    tryIt(scala.util.Random.nextInt(n.toInt))
  }

  def fastPrime(n: Long, times: Int): Boolean =
    if (times == 0) true
    else if (fermatTest(n)) fastPrime(n, times - 1)
    else false
}
