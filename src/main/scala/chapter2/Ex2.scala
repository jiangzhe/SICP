package chapter2

/**
  * Created by jiangzhe on 1/19/17.
  */
trait Ex2 {
  type Point = (Double, Double)
  type Segment = (Point, Point)

  def xPoint(p: Point): Double = p._1
  def yPoint(p: Point): Double = p._2

  def startSegment(s: Segment): Point = s._1
  def endSegment(s: Segment): Point = s._2

  def makeSegment(start: Point, end: Point): Segment = (start, end)

  def midpointSegment(s: Segment): Point = {
    val start = startSegment(s)
    val end = endSegment(s)
    ((xPoint(start) + xPoint(end)) / 2, (yPoint(start) + yPoint(end)) / 2)
  }

  def printPoint(p: Point): Unit = println(p)
}

//case class Point(x: Int, y: Int)
//case class Segment(start: Point, end: Point)
