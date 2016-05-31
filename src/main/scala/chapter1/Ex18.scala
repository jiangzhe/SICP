package chapter1

/**
  * Ex18
  * --
  * Desc:
  * Changes:
  * 2016/5/31 - Created by z_jiang.
  * --
  */
trait Ex18 {
  def double(n: Long): Long = n + n
  def halve(n: Long): Long = n >> 2

  def multiply2(a: Long, b: Long): Long = {
    def iter(r: Long, a: Long, b: Long): Long =
      if (b == 0) r
      else iter(if ((b & 1) == 1) r + a else r, double(a), halve(b))
    iter(0, a, b)
  }
}
