package chapter2

import scala.collection.mutable

/**
  * Created by jiangzhe on 1/20/17.
  *
  * the plan is to build a package with 2 phases: arithmetic building and evaluating
  * So we can always try to simplify the expression before evaluation
  *
  * Maybe a algebra rewriting system? More difficult than expected.
  *
  * to keep it simple, only consider positive numbers, and intervals are treated
  * as same instance if they have same center and same percent
  *
  * API as below
  *
  * class Run extends Ex16 {
  *   val expr = (const(2) / lit(10, 5)) / (const(3) / lit(10, 5)) * lit(10, 5)
  *
  *   def display(): Unit = println(evaluate(expr))
  * }
  *
  */
trait Ex16 {
  sealed trait Expr { self =>
    def literals: Map[Literal, Int]
    def simplify: Expr
    def plus(that: Expr): Expr = Plus(self, that)
    def minus(that: Expr): Expr = Minus(self, that)
    def times(that: Expr): Expr = Times(self, that)
    def divides(that: Expr): Expr = Divides(self, that)

    def + (that: Expr): Expr = plus(that)
    def - (that: Expr): Expr = minus(that)
    def * (that: Expr): Expr = times(that)
    def / (that: Expr): Expr = divides(that)
  }
  case class Constant(value: Double) extends Expr {
    val literals: Map[Literal, Int] = Map()
    val simplify: Expr = this

    override def toString: String = value.toString
  }
  case class Literal(center: Double, percent: Double) extends Expr {
    val literals: Map[Literal, Int] = Map(this -> 1)
    val simplify: Expr = this

    override def toString: String = s"($center ± $percent%)"
  }
  sealed trait BinaryExpr extends Expr {
    def left: Expr
    def right: Expr
    def rebuild(left: Expr, right: Expr): Expr
    val literals: Map[Literal, Int] = {
      val map = mutable.Map[Literal, Int]().withDefaultValue(0)
      left.literals.foreach({
        case (lit, n) => map.put(lit, map(lit) + n)
      })
      right.literals.foreach({
        case (lit, n) => map.put(lit, map(lit) + n)
      })
      map.toMap
    }

    def simplify: Expr = {
      val leftSimplified = left.simplify
      val rightSimplified = right.simplify
      rebuild(leftSimplified, rightSimplified) match {
        case init: BinaryExpr =>
          val commonKeys = init.left.literals.keySet.intersect(init.right.literals.keySet)
          if (commonKeys.isEmpty) init
          else {
            commonKeys.foldLeft(init: Expr)((acc, lit) => acc match {
              case acc: BinaryExpr =>
                // first try divide
                val leftDivided = div(acc.left, lit)
                val rightDivided = div(acc.right, lit)
                // if left expression and right expression still both have the lit after division,
                // that means the division does not take effect to make interval tighter
                if (leftDivided.literals.contains(lit) && rightDivided.literals.contains(lit)) {
                  val leftMultiplied = mul(acc.left, lit)
                  val rightMultiplied = mul(acc.right, lit)
                  if (leftMultiplied.literals.contains(lit) && rightMultiplied.literals.contains(lit)) acc
                  else rebuild(leftMultiplied, rightMultiplied)
                }
                else rebuild(leftDivided, rightDivided)
              case _ =>
                acc
            })
          }
        case other => other
      }
    }

    private def div(expr: Expr, lit: Literal): Expr = expr match {
      case Constant(_) => Divides(expr, lit)
      case Literal(_, _) => if (expr == lit) Constant(1.0) else Divides(expr, lit)
      case Plus(left, right) => Plus(div(left, lit), div(right, lit))
      case Minus(left, right) => Minus(div(left, lit), div(right, lit))
      case Times(left, right) =>
        if (left == lit) right
        else if (right == lit) left
        else Times(div(left, lit), right)
      case Divides(left, right) => Divides(div(left, lit), right)
    }

    private def mul(expr: Expr, lit: Literal): Expr = expr match {
      case Constant(v) => if (v == 1.0) lit else Times(expr, lit)
      case Literal(_, _) => Times(expr, lit)
      case Plus(left, right) => Plus(mul(left, lit), mul(right, lit))
      case Minus(left, right) => Minus(mul(left, lit), mul(right, lit))
      case Times(left, right) => Times(mul(left, lit), right)
      case Divides(left, right) => if (right == lit) left else Divides(Times(left, lit), right)
    }
  }

  case class Plus(left: Expr, right: Expr) extends BinaryExpr {
    def rebuild(left: Expr, right: Expr): Expr =
      if (left == Constant(0.0)) right
      else if (right == Constant(0.0)) left else Plus(left, right)

    override def toString: String = s"($left + $right)"
  }
  case class Minus(left: Expr, right: Expr) extends BinaryExpr {
    def rebuild(left: Expr, right: Expr): Expr =
      if (right == Constant(0.0)) left else Minus(left, right)

    override def toString: String = s"($left - $right)"
  }
  case class Times(left: Expr, right: Expr) extends BinaryExpr {
    def rebuild(left: Expr, right: Expr): Expr =
      if (left == Constant(0.0) || right == Constant(0.0)) Constant(0.0)
      else if (left == Constant(1.0)) right
      else if (right == Constant(1.0)) left
      else Times(left, right)

    override def toString: String = s"($left * $right)"
  }
  case class Divides(left: Expr, right: Expr) extends BinaryExpr {
    def rebuild(left: Expr, right: Expr): Expr =
      if (left == Constant(0.0)) Constant(0.0)
      else if (right == Constant(0.0)) throw new ArithmeticException("/ by zero")
      else if (right == Constant(1.0)) left
      else Divides(left, right)

    override def toString: String = s"($left / $right)"
  }

  def const(value: Double): Expr = Constant(value)

  def lit(center: Double, percent: Double): Literal = Literal(center, percent)

  def evaluate(expr: Expr): Literal = evaluateRaw(expr.simplify)

  def evaluateRaw(expr: Expr): Literal = expr match {
    case Constant(value) => Literal(value, 0)
    case Literal(center, percent) => Literal(center, percent)
    case Plus(left, right) =>
      val leftLit = evaluateRaw(left)
      val rightLit = evaluateRaw(right)
      Literal(leftLit.center + rightLit.center,
        (leftLit.center * leftLit.percent + rightLit.center * rightLit.percent) / (leftLit.center + rightLit.center))
    case Minus(left, right) =>
      val leftLit = evaluateRaw(left)
      val rightLit = evaluateRaw(right)
      Literal(leftLit.center - rightLit.center,
        (leftLit.center * leftLit.percent + rightLit.center * rightLit.percent) / (leftLit.center - rightLit.center))
    case Times(left, right) =>
      val leftLit = evaluateRaw(left)
      val rightLit = evaluateRaw(right)
      Literal(
        leftLit.center * rightLit.center + leftLit.center * rightLit.center * leftLit.percent * rightLit.percent,
        (leftLit.percent + rightLit.percent) / (1 + leftLit.percent * rightLit.percent)
      )
    case Divides(left, right) =>
      val leftLit = evaluateRaw(left)
      val rightLit = evaluateRaw(right)
      val newCenter = leftLit.center * (1 + leftLit.percent * rightLit.percent) / (rightLit.center * (1 - rightLit.percent * rightLit.percent))
      val newPercent = (leftLit.percent + rightLit.percent) / (1 + leftLit.percent * rightLit.percent)
      Literal(newCenter, newPercent)
  }
}
