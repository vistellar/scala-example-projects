package scalafortheimpatient.chapter12

/**
 * @author Wei Xing
 */

object Exercise06 {
  def largeAt(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.map(fun).zipWithIndex.max._2 + 1
  }

  def main(args: Array[String]) {
    println(largeAt(x => 10 * x - x * x, (1 to 10)))
  }
}