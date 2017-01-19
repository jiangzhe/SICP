package chapter2

/**
  * Created by jiangzhe on 1/19/17.
  */
trait Ex3 extends Ex2 {
  type Rect

  def distance(p1: Point, p2: Point): Double = Math.sqrt(
    Math.pow(xPoint(p1) - xPoint(p2), 2) + Math.pow(yPoint(p1) - yPoint(p2), 2))

  def rectLineLength1(r: Rect): Double

  def rectLineLength2(r: Rect): Double

  def rectPerimeter(r: Rect): Double = 2 * (rectLineLength1(r) + rectLineLength2(r))

  def rectArea(r: Rect): Double = rectLineLength1(r) * rectLineLength2(r)
}

object Ex3_1 extends Ex3 {
  type Rect = (Point, Point, Point)

  def rectLineLength1(r: Rect): Double = distance(r._1, r._2)
  def rectLineLength2(r: Rect): Double = distance(r._2, r._3)
}

object Ex3_2 extends Ex3 {
  type Angle = Double
  // a start point, angle(anti-clockwise), and two lengths
  type Rect = (Point, Angle, Double, Double)
  def rectLineLength1(r: Rect): Double = r._3
  def rectLineLength2(r: Rect): Double = r._4
}

