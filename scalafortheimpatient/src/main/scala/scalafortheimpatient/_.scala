package scalafortheimpatient

/**
 * @author Wei Xing
 */
class Fraction(val x: Int, val y: Int) extends Ordered[Fraction] {
  def *(o: Fraction): Fraction = {
    Fraction(x * o.x, y * o.y)
  }

  override def compare(o: Fraction): Int = x / y - o.x / o.y
}

object Fraction {
  def apply(x: Int, y: Int): Fraction = new Fraction(x, y)
}