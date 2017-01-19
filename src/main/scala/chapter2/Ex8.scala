package chapter2

/**
  * Created by jiangzhe on 1/19/17.
  */
trait Ex8 extends Ex7 {
  def subInterval(a: Interval, b: Interval): Interval = addInterval(a, makeInterval(-upperBound(b), -lowerBound(b)))
}
