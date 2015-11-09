/**
  * @author Wei Xing
  */
object NestedFunctions {
  def main(args: Array[String]) {
    def filter(l: List[Int], threshold: Int): List[Int] = {
      def process(l: List[Int]): List[Int] = {
        if (l.isEmpty) l
        else if (l.head < threshold) l.head :: process(l.tail)
        else process(l.tail)
      }
      process(l)
    }

    println(filter((0 to 9).toList, 5))
  }
}
