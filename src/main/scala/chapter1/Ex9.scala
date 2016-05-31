package chapter1

/**
  * Ex9
  * --
  * Desc:
  * Changes:
  * 2016/5/31 - Created by z_jiang.
  * --
  */
trait Ex9 {
  def inc(a: Int) = a + 1
  def dec(a: Int) = a - 1

  def plus(a: Int, b: Int): Int = if (a == 0) b else inc(plus(dec(a), b))
  def plus2(a: Int, b: Int): Int = if (a == 0) b else plus(dec(a), inc(b))
}
