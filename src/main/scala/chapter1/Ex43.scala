package chapter1

/**
  * Ex43
  * --
  * Desc:
  * Changes:
  * 2016/6/3 - Created by z_jiang.
  * --
  */
trait Ex43 {
  def repeat[A](f: A => A, k: Int): A => A = {
    if (k == 1) f
    else (a: A) => repeat(f, k - 1)(f(a))
  }
}
