package chapter1

/**
 * Created by TOSHIBA on 2015/5/26.
 */
object Ex6 {
  // lack of switch-like control structure, using pattern matching instead
  def newIf(predicate: Boolean, thenClause: => Int, elseClause: => Int) = {
    predicate match {
      case true => thenClause
      case false => elseClause
    }
  }
}
