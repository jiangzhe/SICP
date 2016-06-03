package chapter1

/**
  * Ex33
  * --
  * Desc:
  * Changes:
  * 2016/6/2 - Created by z_jiang.
  * --
  */
trait Ex33 {
  object Algo extends Prime with GCD

  def filteredAccumulate(combiner: (Double, Double) => Double, nullValue: Double, filter: Double => Boolean,
                         term: Double => Double, a: Double, next: Double => Double, b: Double): Double =
    if (a > b) nullValue
    else if (filter(a)) combiner(term(a), filteredAccumulate(combiner, nullValue, filter, term, next(a), next, b))
    else filteredAccumulate(combiner, nullValue, filter, term, next(a), next, b)

  def primeSumBetween(a: Long, b: Long): Long =
    filteredAccumulate(_ + _, 0, (d: Double) => Algo.prime(d.toLong), n => n, a, _ + 1, b).toLong

  def biPrimeProduct(n: Long): Double =
    filteredAccumulate(_ * _, 1.0, (d: Double) => Algo.gcd(d.toLong, n) == 1, n => n, 1, _ + 1, n)
}
