package chapter1

/**
  * Ex17
  * --
  * Desc:
  * Changes:
  * 2016/5/31 - Created by z_jiang.
  * --
  */
trait Ex17 {
  def multiply(a: Long, b: Long): Long =
    if (b == 0) a
    else multiply(a, b-1) + a

  def double(n: Long): Long = n + n
  def halve(n: Long): Long = n >> 2

  def multiply2(a: Long, b: Long): Long =
    if (b == 0) a
    else {
      if ((b & 1) == 1) a + multiply2(double(a),halve(b))
      else multiply2(double(a),halve(b))
    }
}
