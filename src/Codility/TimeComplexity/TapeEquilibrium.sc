//TODO: one more time
//A[0] = 3
//A[1] = 1
//A[2] = 2
//A[3] = 4
//A[4] = 3
//
//We can split this tape in four places:
//
//P = 1, difference = |3 − 10| = 7
//P = 2, difference = |4 − 9| = 5
//P = 3, difference = |6 − 7| = 1
//P = 4, difference = |10 − 3| = 7
//
//Write a function:
//
def solution(A: Array[Int]): Int = {
  if (A.length == 1) -1
  else {
    //parts:
    val first = A.head
    val second = A.sum - first
    val diff = Math.abs(first - second)
    val middle = A.tail.init

    val (minDifference, _, _) = middle.foldLeft((diff, first, second)) { case ((acc, f, s), el) =>
      val newResult = Math.abs(f - s) min acc
      (newResult, f + el, s - el)
    }
    minDifference
  }
}
solution(Array(3, 1, 2, 4, 3))
solution(Array(3))
solution(Array(3, 1))
solution(Array(-1000, 1000))
solution(Array(-10, -20, -30, -40, 100))
//that, given a non-empty zero-indexed array A of N integers, returns the minimal difference
// that can be achieved.
//
//For example, given:
//A[0] = 3
//A[1] = 1
//A[2] = 2
//A[3] = 4
//A[4] = 3
//
//the function should return 1, as explained above.
//
//  Assume that:
//
//N is an integer within the range [2..100,000];
//each element of array A is an integer within the range
//[−1,000..1,000].
//
//Complexity:
//
//  expected worst-case time complexity is O(N);

def mySolution(a: Array[Int]): Int = {
  val sum: Int = a.sum
  var lastValue = a.head
  var absMin = Integer.MAX_VALUE
  a.tail.foreach { aa =>
    val secondValue: Int = sum - lastValue
    val currentAbsMin = Math.abs(lastValue - secondValue)
    absMin = Math.min(absMin, currentAbsMin)
    lastValue = lastValue + aa
  }
  absMin
}
mySolution(Array(3, 1, 2, 4, 3))
mySolution(Array(3, 1))
mySolution(Array(-1000, 1000))
mySolution(Array(-10, -20, -30, -40, 100))