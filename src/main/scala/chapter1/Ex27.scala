package chapter1

/**
  * Ex27
  * --
  * Desc:
  * Changes:
  * 2016/6/2 - Created by z_jiang.
  * --
  */
trait Ex27 {
  def carmichael(n: Long): Boolean = {
//    def iter(n: Long, a: Long): Boolean =
//      if (a == n) true
//      else if (expmod(n, a, n) != a) false
//      else iter(n, a + 1)
//    iter(n, 2)
    Stream.from(2).takeWhile(_ < n).forall(a => {
      val r = expmod(n, a, n)
      r == a
    })
  }

  def expmod(n: Long, base: Long, exp: Long): Long =
    if (exp == 0) 1
    else if ((exp & 1) == 1) (expmod(n, (base * base) % n, exp >> 1) * base) % n
    else expmod(n, (base * base) % n, exp >> 1) % n
}
