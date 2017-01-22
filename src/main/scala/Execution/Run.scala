package execution

import chapter1._
import chapter2.Ex16

/**
 * Created by TOSHIBA on 2015/5/26.
 */
object Run {
  def main(args: Array[String]): Unit = {
//    val ex10 = new Ex10 {}
//    println("A 1 3 = " + ex10.ackermann(1, 3))
//    println("A 1 10 = " + ex10.ackermann(1, 10))
//    println("A 2 4  = " + ex10.ackermann(2, 4))
//    println("A 3 3  = " + ex10.ackermann(3, 3))
//
//    val ex11 = new Ex11 {}
//    val n = 8
//    println(s"f($n)  = " + ex11.f(n))
//    println(s"f2($n) = " + ex11.f2(n))
//
//    val ex12 = new Ex12 {}
//    println(s"p($n) = " + ex12.p(n))
//
//    val ex16 = new Ex16 {}
//    for (i <- List(2,3,4,5,7)) {
//      println(s"fastExp($i, $i) = " + ex16.fastExp(i, i))
//    }

//    val ex19 = new Ex19 {}
//    for (i <- 1 to 20) {
//      println(s"fib($i) = " + ex19.fib(i))
//    }

//    println(s"fib(20) = ${ex19.fib(20)}" )

//    val prime = new Prime {}
//    for (i <- List(199, 1999, 19999)) {
//      println(s"smallestDivisor($i) = " + prime.smallestDivisor(i))
//    }
//    val ex27 = new Ex27 {}
//    for (i <- List(561, 1105, 1729, 2465, 2821, 6601)) {
//      println(s"Carmichael $i ${ex27.carmichael(i)}")
//    }

//    val highOrder = new HighOrder {}
//    println(highOrder.sum(highOrder.cube, 1, highOrder.inc, 10))
//
//    val cube = (x: Double) => x * x * x
//    println(highOrder.integral(cube, 0.0, 1.0, 0.001))
//
//    val ex29 = new Ex29 {}
//    println(ex29.simpson(cube, 0.0, 1.0, 1000))
//    val ex31 = new Ex31 {}
//    println(ex31.factorial(5))
//    println(ex31.simPi(2000))
//    val ex33 = new Ex33 {}
//    println(ex33.biPrimeProduct(8)) // 3 5 7
//    println(ex33.primeSumBetween(2,10)) // 2 3 5 7

//    val fixedPoint = new FixedPoint {}
//    println(fixedPoint.fixedPoint(Math.cos, 1.0))
//    println(fixedPoint.fixedPoint(x => Math.sin(x) + Math.cos(x), 1.0))
//    println(fixedPoint.fixedPoint(x => (x + 1 + 1 / x) / 2, 1.0))
//    val ex35 = new Ex35 {}
//    println("original fixedPoint")
//    println(ex35.fixedPoint(x => 1 + 1 / x, 1.0))
//    println("average fixedPoint")
//    println(ex35.averageFixedPoint(x => 1 + 1 / x, 1.0))

//    println("original fixedPoint")
//    println(ex35.fixedPoint(x => 3 / Math.log10(x), 10.0))
//    println("average fixedPoint")
//    println(ex35.averageFixedPoint(x => 3 / Math.log10(x), 10.0))

//    val ex37 = new Ex37 {}
//    println(ex37.contFrac(_ => 1.0, _ => 1.0, 30))
//    println(ex37.contFracIter(_ => 1.0, _ => 1.0, 30))
//    val ex38 = new Ex38 {}
//    println(ex38.calcE(30))
//    val ex39 = new Ex39 {}
//    println(ex39.tanCf(3.1416 / 3, 50))
//    val newton2 = new Newton2 {}
//    println(newton2.newtonMethod(x => x*x - 3, 0.0))
//    val ex40 = new Ex40 {}
//    println(ex40.solve(2,1,0))
//    val ex43 = new Ex43 {}
//    def square(x: Double): Double = x * x
//    println(ex43.repeat(square, 2)(5))
//    val ex45 = new Ex45 with Ex35
//    val newton2 = new Newton2 {}
//    def f = (x: Double) => 10.0 / x / x
//    println("average " + ex45.fixedPoint(ex45.averageDampK(f, 1), 2.0))
//    println("newton " + newton2.newtonMethod(f, 1.5))

    object ex16 extends Ex16 {
      def run(): Unit = {
        val expr1 = lit(10, 50) + const(10)
        println(s"$expr1 = ${evaluateRaw(expr1)}")
        println()

        val expr2 = lit(10, 50) - const(5)
        println(s"$expr2 = ${evaluateRaw(expr2)}")
        println()

        val expr3 = lit(10, 50) * const(2)
        println(s"$expr3 = ${evaluateRaw(expr3)}")
        println()

        val expr4 = lit(10, 50) / const(2)
        println(s"$expr4 = ${evaluateRaw(expr4)}")
        println()

        val expr5 = lit(10, 50) + const(50) - lit(10, 50)
        println(s"$expr5 = ${evaluateRaw(expr5)}")
        println(s"${expr5.simplify} = ${evaluateRaw(expr5.simplify)}")
        println()

        val expr6 = lit(10, 50) * lit(4, 50) / (lit(10, 50) + lit(4, 50))
        println(s"$expr6 = ${evaluateRaw(expr6)}")
        println(s"${expr6.simplify} = ${evaluateRaw(expr6.simplify)}")
        println()

        val expr7 = lit(10, 5) * lit(10, 5) / lit(10,5)
        println(s"$expr7 = ${evaluateRaw(expr7)}")
        println(s"${expr7.simplify} = ${evaluateRaw(expr7.simplify)}")
        println()

        val expr8 = (const(2) / lit(10, 5)) / (const(3) / lit(10, 5)) * lit(10, 5)
        println(s"$expr8 = ${evaluateRaw(expr8)}")
        println(s"${expr8.simplify} = ${evaluateRaw(expr8.simplify)}")
        println()
      }
    }

    ex16.run()


  }
}
