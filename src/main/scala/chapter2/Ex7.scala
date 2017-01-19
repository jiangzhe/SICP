package chapter2

/**
  * Created by jiangzhe on 1/19/17.
  */
trait Ex7 extends IntervalBase {
  type Interval = (Double, Double)
  def lowerBound(i: Interval): Double = i._1
  def upperBound(i: Interval): Double = i._2
  def makeInterval(lowerBound: Double, upperBound: Double): Interval = (lowerBound, upperBound)
}

trait IntervalBase {
  type Interval
  def lowerBound(i: Interval): Double
  def upperBound(i: Interval): Double
  def makeInterval(lowerBound: Double, upperBound: Double): Interval
  def addInterval(a: Interval, b: Interval): Interval = makeInterval(lowerBound(a) + lowerBound(b), upperBound(a) + upperBound(b))
  def mulInterval(a: Interval, b: Interval): Interval = {
    val p1 = lowerBound(a) * lowerBound(b)
    val p2 = lowerBound(a) * upperBound(b)
    val p3 = upperBound(a) * lowerBound(b)
    val p4 = upperBound(a) * upperBound(b)
    val arr = List(p1, p2, p3, p4)
    makeInterval(arr.min, arr.max)
  }
  def divInterval(a: Interval, b: Interval): Interval = mulInterval(a, makeInterval(1.0 / upperBound(b), 1.0 / lowerBound(b)))

}