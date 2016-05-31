package chapter1

/**
  * Ex19
  * --
  * Desc:
  * Changes:
  * 2016/5/31 - Created by z_jiang.
  * --
  */
trait Ex19 {
  def fib(n: Long): Long = {
    def iter(a: Long, b: Long, p: Long, q: Long, count: Long): Long =
      if (count == 0) b
      else if ((count & 1) == 1) {
        val newA = b * q + a * p + a * q
        val newB = b * p + a * q
        iter(newA, newB, p, q, count - 1)
      } else {
        val newP = p * p + q * q
        val newQ = q * q + 2 * p * q
        iter(a, b, newP, newQ, count >> 1)
      }
    iter(1, 0, 0, 1, n)
  }
}
