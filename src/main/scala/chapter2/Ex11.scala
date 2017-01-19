package chapter2

/**
  * Created by jiangzhe on 1/19/17.
  *
  */
trait Ex11 extends Ex10 {

  override def mulInterval(a: Interval, b: Interval): Interval =
    if (upperBound(a) < 0) {
      if (upperBound(b) < 0)
        makeInterval(upperBound(a) * upperBound(b), lowerBound(a) * lowerBound(b))
      else if (lowerBound(b) >= 0)
        makeInterval(lowerBound(a) * upperBound(b), upperBound(a) * lowerBound(b))
      else
        makeInterval(lowerBound(a) * lowerBound(b), lowerBound(a) * upperBound(b))
    } else if (lowerBound(a) > 0) {
      if (upperBound(b) < 0)
        makeInterval(upperBound(a) * lowerBound(b), lowerBound(a) * upperBound(b))
      else if (lowerBound(b) >= 0)
        makeInterval(lowerBound(a) * lowerBound(b), upperBound(a) * upperBound(b))
      else
        makeInterval(upperBound(a) * lowerBound(b), upperBound(a) * upperBound(b))
    } else {
      if (upperBound(b) < 0)
        makeInterval(upperBound(a) * lowerBound(b), lowerBound(a) * lowerBound(b))
      else if (lowerBound(b) >= 0)
        makeInterval(lowerBound(a) * upperBound(b), upperBound(a) * upperBound(b))
      else {
        val p1 = lowerBound(a) * lowerBound(b)
        val p2 = lowerBound(a) * upperBound(b)
        val p3 = upperBound(a) * lowerBound(b)
        val p4 = upperBound(a) * upperBound(b)
        val arr = List(p1, p2, p3, p4)
        makeInterval(arr.min, arr.max)
      }
    }
}
