package chapter1

/**
 * Created by z_jiang on 2015/5/26.
 */
object Ex4 {
  def plus(a: Int, b: Int) = a + b
  def minus(a: Int, b: Int) = a - b

  def aPlusAbsB(a: Int, b: Int) = {
    (if (b > 0) plus _ else minus _)(a, b)
  }

}
