def solution(a: Array[Int], b: Array[Int]): Int = {
  if (a.length < 2) return a.length
  var size = 1
  val aZipB: Array[(Int, Int)] = a zip b
  var lastEnd = b.head
  aZipB.tail.foreach {
    case (begin, end) if begin > lastEnd =>
      size += 1
      lastEnd = end
    case _ =>
  }
  size
}

solution(Array(1, 3, 7, 9, 9), Array(5, 6, 8, 9, 10)) // 3