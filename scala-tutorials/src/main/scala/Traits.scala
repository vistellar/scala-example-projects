/**
  * @author Wei Xing
  */

trait Similar {
  def isSimilar(o: Any): Boolean
  def isNotSimilar(o: Any): Boolean = !isSimilar(0)
}

class Point(val x: Int, val y: Int) extends Similar {
  override def isSimilar(o: Any): Boolean =
    o.isInstanceOf[Point] && o.asInstanceOf[Point].x == x
}

object Traits {
  def main(args: Array[String]) {
    val p1 = new Point(1, 2)
    val p2 = new Point(1, 3)
    val p3 = new Point(2, 1)

    assert(p1.isSimilar(p2))
    assert(!p1.isSimilar(p3))
    assert(!p1.isSimilar(3))
  }
}
