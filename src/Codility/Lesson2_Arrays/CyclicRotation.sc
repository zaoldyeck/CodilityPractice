//A zero-indexed array A consisting of N integers is given.
//Rotation of the array means that each element is shifted
//right by one index, and the last element of the array is
//also moved to the first place.
//
//For example, the rotation of array
// A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7].
//The goal is to rotate array A K times;
//that is, each element of A will be shifted to the
// right by K indexes.
//
//  Write a function:
//
import scala.annotation.tailrec

def solution(A: Array[Int], K: Int): Array[Int] = {
  @tailrec
  def cycle(A: List[Int], K: Int): List[Int] = A match {
    case Nil => A
    case head :: Nil => A
    case _ if K == 0 => A
    case init :+ last => cycle(last :: init, K - 1)
  }
  cycle(A.toList, K).toArray
}
//
//that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.
//
//  For example, given array A = [3, 8, 9, 7, 6] and
// K = 3, the function should return [9, 7, 6, 3, 8].
solution(Array(3, 8, 9, 7, 6), 3).foreach(println)
//Assume that:
//
//  N and K are integers within the range [0..100];
//each element of array A is an integer within the range [−1,000..1,000].
//
//In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

def mySolution(a: Array[Int], k: Int): Array[Int] = {
  def stepRotation(a: List[Int], k: Int): List[Int] = {
    def oneStepRotation(a: List[Int]): List[Int] = {
      a.take(a.size - 1).+:(a.last)
    }
    if (k == 0) a else stepRotation(oneStepRotation(a), k - 1)
  }
  if (a.isEmpty) a
  else stepRotation(a.toList, k).toArray
}

mySolution(Array(3, 8, 9, 7, 6), 3).foreach(println)