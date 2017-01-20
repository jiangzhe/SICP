package chapter2

import scala.collection.mutable

/**
  * Created by jiangzhe on 1/20/17.
  *
  * the plan is to build a package with 2 phases: arithmetic building and evaluating
  * So we can always try to simplify the expression before evaluation
  *
  * Maybe a algebra rewriting system? More difficult than expected.
  */
trait Ex16 {
  sealed trait Expr {
    def literals: Map[Literal, Int]
    def simplify: Expr
  }
  case class Constant(value: Double) extends Expr {
    val literals: Map[Literal, Int] = Map()
    val simplify: Expr = this
  }
  case class Literal(center: Double, percent: Double) extends Expr {
    val literals: Map[Literal, Int] = Map(this -> 1)
    val simplify: Expr = this
  }
  trait BinaryExpr extends Expr {
    def left: Expr
    def right: Expr
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

    // TODO
    def simplify: Expr = {
      val commonKeys = left.literals.keySet.intersect(right.literals.keySet)
      if (commonKeys.isEmpty) this
      else ???
    }

    private def div(expr: Expr, lit: Literal): Expr = expr match {
      case Constant(_) => Divides(expr, lit)
      case Literal(_, _) => if (expr == lit) Constant(1.0) else Divides(expr, lit)
      case Plus(left, right) => Plus(div(left, lit), div(right, lit))
      case Minus(left, right) => Minus(div(left, lit), div(right, lit))
      case Times(left, right) =>
        if (left == lit) right
        else if (right == lit) left
        else Times(div(left, lit), div(right, lit))
      case Divides(left, right) =>
        if (left == lit) Divides(Constant(1.0), right)
        else Divides(div(left, lit), div(right, lit))
    }
  }

  case class Plus(left: Expr, right: Expr) extends BinaryExpr
  case class Minus(left: Expr, right: Expr) extends BinaryExpr
  case class Times(left: Expr, right: Expr) extends BinaryExpr
  case class Divides(left: Expr, right: Expr) extends BinaryExpr


}
