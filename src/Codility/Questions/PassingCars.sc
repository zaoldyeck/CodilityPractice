def solution(a: Array[Int]): Int = {
  var pairs = 0
  var east = 0
  a.foreach {
    case 0 => east += 1
    case 1 =>
      pairs += east
      if (pairs > 1000000000) return -1
  }
  pairs
}
solution(Array(0, 1, 0, 1, 1)) // 5
solution(Array(0, 0, 0, 0, 0)) // 0
solution(Array(0, 0, 0, 0, 1)) // 4
solution(Array(1, 0, 0, 0, 0)) // 0
solution(Array(1, 1, 1, 1, 1)) // 0