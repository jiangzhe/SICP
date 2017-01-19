package chapter2

/**
  * Created by jiangzhe on 1/20/17.
  */
trait Ex12 {
  type Interval = (Double, Double)

  def center(i: Interval): Double = i._1
  def percent(i: Interval): Double = i._2
  def makeCenterPercent(center: Double, percent: Double): Interval = (center, percent)
}
