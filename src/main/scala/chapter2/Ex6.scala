package chapter2

/**
  * Created by jiangzhe on 1/19/17.
  */
trait Ex6 {
  type T
  type F = T => T
  def zero: F => F = (f: F) => (x: T) => x
  def addOne(n: F => F) = (f: F) => (x: T) => f(n(f)(x))
  def one: F => F = (f: F) => (x: T) => f(x)
  def two: F => F = (f: F) => (x: T) => f(f(x))
  def plus(n: F => F) = (f: F) => (x: T) => n(f)(x)
}
