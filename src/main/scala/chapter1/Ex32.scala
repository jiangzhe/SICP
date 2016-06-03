package chapter1

/**
  * Ex32
  * --
  * Desc:
  * Changes:
  * 2016/6/2 - Created by z_jiang.
  * --
  */
trait Ex32 {
  def accumulate(combiner: (Double, Double) => Double, nullValue: Double, term: Double => Double, a: Double, next: Double => Double, b: Double): Double =
    if (a > b) nullValue
    else combiner(term(a), accumulate(combiner, nullValue, term, next(a), next, b))

  def sum(term: Double => Double, a: Double, next: Double => Double, b: Double): Double = {
    val combiner: (Double, Double) => Double = _ + _
    val nullValue = 0.0
    accumulate(combiner, nullValue, term, a, next, b)
  }

  def product(term: Double => Double, a: Double, next: Double => Double, b: Double): Double = {
    val combiner: (Double, Double) => Double = _ * _
    val nullValue = 1.0
    accumulate(combiner, nullValue, term, a, next, b)
  }
}
