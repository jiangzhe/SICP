package chapter2

/**
  * Created by jiangzhe on 1/20/17.
  *
  * the plan is to build a package with 2 phases: arithmetic building and evaluating
  * So we can always try to simplify the expression before evaluation
  */
trait Ex16 {
  sealed trait Expr
  case class Literal(center: Double, percent: Double) extends Expr
  case class Plus(left: Expr, right: Expr) extends Expr
  case class Minus(left: Expr, right: Expr) extends Expr
  case class Times(left: Expr, right: Expr) extends Expr
  case class Divides(left: Expr, right: Expr) extends Expr


}
