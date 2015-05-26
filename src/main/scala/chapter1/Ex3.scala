package chapter1

/**
 * Created by z_jiang on 2015/5/26.
 */
object Ex3 {
  def SumSquareOfBigTwo(a: Int, b: Int, c: Int) = {
    if (a > b) {
      val another = if (b > c) b else c
      a * a + another * another
    } else {
      val another = if (a > c) a else c
      b * b + another * another
    }
  }
}
