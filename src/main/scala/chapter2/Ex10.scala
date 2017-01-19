package chapter2

/**
  * Created by jiangzhe on 1/19/17.
  */
trait Ex10 extends Ex8 {
  override def divInterval(a: Interval, b: Interval): Interval =
    if (lowerBound(b) <= 0 && upperBound(b) >= 0) throw new IllegalArgumentException("divided interval spanning 0")
    else super.divInterval(a, b)
}
