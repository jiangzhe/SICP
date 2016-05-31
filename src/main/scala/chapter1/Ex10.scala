package chapter1

/**
  * Ex10
  * --
  * Desc:
  * Changes:
  * 2016/5/31 - Created by z_jiang.
  * --
  */
trait Ex10 {
  def ackermann(x: Long, y: Long): Long =
    if (y == 0) 0
    else if (x == 0) 2 * y
    else if (y == 1) 2
    else ackermann(x - 1, ackermann(x, y - 1))

  def f(n: Long): Long = ackermann(0, n)
  def g(n: Long): Long = ackermann(1, n)
  def h(n: Long): Long = ackermann(2, n)
  def k(n: Long): Long = 5 * n * n
}
