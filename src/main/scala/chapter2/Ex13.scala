package chapter2

/**
  * Created by jiangzhe on 1/20/17.
  */
trait Ex13 extends Ex12 {

  def mulInterval(a: Interval, b: Interval): Interval =
    makeCenterPercent(center(a) * center(b), percent(a) + percent(b) + percent(a) * percent(b))

}
