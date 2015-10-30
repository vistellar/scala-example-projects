package scalafortheimpatient.chapter21

import java.io.File

import scala.io.Source
import scalafortheimpatient.Fraction

/**
 * Implicit Convert
 *
 * Valid scopes:
 * 1. source or target object;
 * 2. current scope(define or import from another package).
 *
 * @author Wei Xing
 */


object FractionTest {
  implicit def int2Fraction(x: Int): Fraction = Fraction(x, 1)

  def main(args: Array[String]) {
    // The int 2 will be convert to Fraction implicitly.
    val result = 2 * Fraction(2, 3)
  }
}

class RichFile(val file: File) {
  def read = Source.fromFile(file.getPath).mkString
}

// Wrapper class in scala, and more easy.
object RichFile {
  implicit def file2RichFile(file: File) = new RichFile(file)

  def main(args: Array[String]) {
    new File("/path/to/file").read
  }
}

case class Delimiter(left: String, right: String)

object Delimiter {
  def quote(what: String)(implicit delimiter: Delimiter) = delimiter.left + what + delimiter.right

  implicit val quoteDelimiter = Delimiter("<", ">")

  def main(args: Array[String]) {
    println(quote("Hello World")(Delimiter("|", "|")))
    println(quote("Hello World"))
  }
}

object Section06 {
  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (order(a) < b) a else b

  def sma11er[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (a < b) a else b

  //
  // implicit def fraction2Ordered(f: Fraction): Ordered[Fraction] = new Ordered[Fraction] {
  //   override def compare(o: Fraction): Int = f.x / f.y - o.x / o.y
  // }
  def main(args: Array[String]) {
    println(smaller(1, 2))
    println(smaller(Fraction(1, 2), Fraction(3, 4)))
  }
}

object Section07 {

}

object Section08 {
  def firstLast[A, C](it: C)(implicit ev: C <:< Iterable[A]) = {
    (it.head, it.last) // equal to (ev(it).head, ev(it).last)
  }

  def main(args: Array[String]) {
    print(firstLast((1 to 10)))
  }
}

object Section10 {
  def main(args: Array[String]) {
  }
}

object Exercise01 {
  def main(args: Array[String]) {
  }
}

class IntFunctions(val i: Int) {
  def !() = (1 to i).reduceLeft(_ * _)
}

object Exercise03 {
  def main(args: Array[String]) {
    implicit def int2IntFunctions(i: Int) = new IntFunctions(i)
    println(5 !)
  }
}

object Exercise10 {
  def main(args: Array[String]) {
    // # scalac -Xprint:typer _.scala
    // Command above find two implicit canBuildFrom[String, T, C]
    // scala.this.Predef.StringCanBuildFrom
    println("abc".map(_.toUpper))
    println("abc".map(_.toUpper).getClass)
    // scala.this.Predef.fallbackStringCanBuildFrom(LowPriorityImplicits)
    println("abc".map(_.toInt))
    println("abc".map(_.toInt).getClass)
  }
}