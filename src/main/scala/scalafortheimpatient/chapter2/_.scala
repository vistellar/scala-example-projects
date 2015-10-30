package scalafortheimpatient.chapter2

/**
 * @author Wei Xing
 */

object Section01 {
  def main(args: Array[String]) {
    // Similar to "1 == 1 ? 1 : -1" in Java/C++.
    val v1 = if (1 == 1) 1 else -1

    // If the type after if and else are not same, use the common super type.
    // In this example, return Any.
    val v2 = if (1 == 1) 1 else "1"

    // If not exist else expr and if expr is not true, return Unit.
    val v3 = if (1 == 1) 1
    val v4 = if (1 == 1) 1 else () // () is Unit, like void.
  }
}

/**
 * Statement terminal.
 */
object Section02 {
  def main(args: Array[String]) {

  }
}

/**
 * Block Expression
 */
object Section03 {
  def main(args: Array[String]): Unit = {
    // {} is a set of expressions, which result is a expression, too.
    // The value of {} is the value of the last expression in it.
    // It is useful when a value's initial need two or more steps.
    val v1 = {
      val dx = 1 - 2
      val dy = 3 - 4
      Math.sqrt(dx * dx + dy * dy)
    }

    // Assign expression return Unit value.
    val v2 = { var i = 1; i += 1}
    // So, assign can not be go on
    var x = 1
    var y = x = 1 // y is Unit or ()
  }
}

/**
 * I/O
 */
object Section04 {
  def main(args: Array[String]) {
    // print println
    print(1)
    println(2)

    // Format print, C Style.
    printf("Hello, %s!\n", "World")

    // readLine readInt readDouble readByte readShort readLong readFloat readBoolean readChar
    // new method: scala.io.StdIn
    // val name = StdIn.readLine("Your name: ")
  }
}

/**
 * Loop Syntax
 */
object Section05 {
  def main(args: Array[String]) {
    // while and do like Java/C++
    var v1 = 1
    while (v1 > 0) {
      v1 -= 1
    }
    do {
      v1 += 1
    } while (v1 != 0)

    // for like Java's foreach
    for (i <- 1 to 10) {}

    // to, until
    (0 to 9)
    (0 until 10)

    // There is no break or continue statement in scala.
    // 1. Boolean value to control;
    // 2. Inner function, to return;
    // 3. Breaks
  }
}