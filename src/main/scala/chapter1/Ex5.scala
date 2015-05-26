package chapter1

/**
 * Created by TOSHIBA on 2015/5/26.
 */
object Ex5 {
  def infinite(): Int = infinite()
  def wrongTest(x: Int, y: Int) = if (x == 0) 0 else y
  def rightTest1(x: Int, y: => Int) = if (x == 0) 0 else y
}
