package scalafortheimpatient.chapter04

/**
  * Map and Tuple.
  *
  * @author Wei Xing
  */

/**
  *
  */
object Section01 {
  def main(args: Array[String]) {
    // "Alice" -> 10 gen tuple, and Map apply tuple array.
    val v1 = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) // return immutable HashMap

    // mutable map
    val v2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3)
    val v3 = scala.collection.mutable.HashMap[String, Int]()

    val v4 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))
  }
}

/**
  * Get value in the map.
  */
object Section02 {
  def main(args: Array[String]) {
    val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

    //
    val bobScore = scores("Bob") // similar to scores.get("Bob") in Java

    //
    val v1 = if (scores.contains("Bob")) scores("Bob") else 0
    val v2 = scores.getOrElse("Bob", 0)
  }
}

/**
  *
  */
object Section03 {
  def main(args: Array[String]) {
    val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

    scores("Bob") = 10 // update value
    scores("Fred") = 7 // add a new tuple
    println(scores)

    scores +=("Bob" -> 10, "Fred" -> 7)
    scores -= "Alice"
    println(scores)

    val newScores = scores +("Bob" -> 10, "Fred" -> 7)
    print(newScores)
  }
}

object Section04 {
  def main(args: Array[String]) {
    val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    for ((name, score) <- scores) {
      println(name, score)
    }

    for (score <- scores.values) {
      println(score)
    }
  }
}

object Exercise01 {
  def main(args: Array[String]) {
    val prices = Map("A" -> 10, "B" -> 100, "C" -> 1000)
    println(prices.map(f => (f._1, f._2 * 0.9)).toMap)
  }
}

object Exercise02 {
  def main(args: Array[String]) {
    val line = "Hello World"
    val count = scala.collection.mutable.HashMap[Char, Int]()
    line.foreach(f => { count(f) = count.getOrElse(f, 0) + 1})
    println(count)
  }
}

object Exercise03 {
  def main(args: Array[String]) {
    val line = "Hello World"
    line.foldLeft(Map[Char, Int]())((count, c) => count + (c, count.getOrElse(c, 0) + 1))
  }
}