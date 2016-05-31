package chapter1

/**
  * Ex12
  * --
  * Desc:
  * Changes:
  * 2016/5/31 - Created by z_jiang.
  * --
  */
trait Ex12 {
  def p(n: Int): List[Int] =
    if (n < 1) throw new IllegalArgumentException("argument should be not less than 1.")
    else if (n == 1) List(1)
    else {
      val prev: List[Int] = p(n-1)
      (0 :: prev).zip(prev :+ 0).map(t => t._1 + t._2)
    }
}
