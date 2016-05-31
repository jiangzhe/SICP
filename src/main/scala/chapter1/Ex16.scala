package chapter1

/**
  * Ex16
  * --
  * Desc:
  * Changes:
  * 2016/5/31 - Created by z_jiang.
  * --
  */
trait Ex16 {
  def fastExp(x: Long, n: Int): Long = {
    // x^n = 1 * x^n
    def iter(r: Long, x: Long, n: Int): Long =
      if (n == 0) r
      else if ((n & 1) == 1) iter(r * x, x * x, n >> 1)
      else iter(r, x * x, n >> 1)

    iter(1, x, n)
  }
}
