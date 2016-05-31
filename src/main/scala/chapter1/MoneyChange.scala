package chapter1

import scala.annotation.tailrec

/**
  * MoneyChange
  * --
  * Desc:
  * Changes:
  * 2016/5/20 - Created by z_jiang.
  * --
  */
object MoneyChange {
  def countWays(total: Int, coins: Array[Int]): Int = {
    val sorted = coins.sorted.reverse
    rec(total, sorted)
  }

  private def rec(total: Int, coins: Array[Int]): Int = {
    if (total == 0) 1
    else if (coins.isEmpty || total < coins.head) 0
    else {
      (0 until coins.length).map(i => {
        val nextTotal = total - coins(i)
        rec(nextTotal, coins.drop(i))
      }).sum
    }
  }

  def main(args: Array[String]): Unit = {
    println(countWays(4, Array(1,2)))
  }
}
