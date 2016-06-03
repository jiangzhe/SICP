package chapter1

/**
  * Ex42
  * --
  * Desc:
  * Changes:
  * 2016/6/3 - Created by z_jiang.
  * --
  */
trait Ex42 {

  def compose[A,B,C](f: B => C)(g: A => B): A => C = (a: A) => f(g(a))

}
