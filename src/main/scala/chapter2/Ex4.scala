package chapter2

/**
  * Created by jiangzhe on 1/19/17.
  */
trait Ex4 {
  type T
  def cons(x: T, y: T): (T => T => T) => T = (m: T => T => T) => m(x)(y)

  def car(z: (T => T => T) => T): T = {
    val first: T => T => T = (x1: T) => (_: T) => x1
    z(first)
  }

  def cdr(z: (T => T => T) => T): T = {
    val second: T => T => T = (_: T) => (x2: T) => x2
    z(second)
  }
}
