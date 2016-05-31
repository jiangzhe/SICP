package chapter1

/**
  * Ex11
  * --
  * Desc:
  * Changes:
  * 2016/5/31 - Created by z_jiang.
  * --
  */
trait Ex11 {
  def f(n: Long): Long =
    if (n < 3) n
    else f(n - 1) + 2 * f(n - 2) + 3 * f(n - 3)

  def f2(n: Long): Long = {
    def fIter(n: Long, a0: Long, a1: Long, a2: Long, a3: Long): Long =
      if (n < 3) n
      else if (n == 3) a0
      else {
        val newA0 = a0 + 2*a1 + 3*a2
        fIter(n-1, newA0, a0, a1, a2)
      }
    def num(n: Long): Long = n
    val a3 = num(0)
    val a2 = num(1)
    val a1 = num(2)
    val a0 = a1 + 2*a2 + 3*a3

    fIter(n,a0,a1,a2,a3)
  }


}
