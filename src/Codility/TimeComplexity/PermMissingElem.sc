//A zero-indexed array A consisting of N
//different integers is given. The array
// contains integers in the range [1..(N + 1)],
// which means that exactly one element is missing.
//
//Your goal is to find that missing element.

def solution(A: Array[Int]): Int = {
  if (A.isEmpty) 1
  else if (A.max != A.length + 1) A.length + 1
  else (1 to A.max).sum - A.sum
}

solution(Array(2, 3, 1, 5))
solution(Array(2, 3, 4, 5))
solution(Array())
//For example, given array A such that:
//A[0] = 2
//A[1] = 3
//A[2] = 1
//A[3] = 5
//
//the function should return 4, as it is the missing element.
//
//Assume that:
//
//  N is an integer within the range [0..100,000];
//the elements of A are all distinct;
//each element of array A is an integer within the range [1..(N + 1)].
//
//Complexity:
//
//  expected worst-case time complexity is O(N);
//expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
//
//Elements of input arrays can be modified.

def mySolution(a: Array[Int]): Int = {
  if (a.isEmpty) 1
  else if (a.max != a.length + 1) a.length
  else (1 to a.max).sum - a.sum
}

mySolution(Array(2, 3, 1, 5))
mySolution(Array(2, 3, 4, 5))
mySolution(Array())

def mySolution2(a: Array[Int]): Int = {
  def findMissing(list: List[Int], i: Int): Int = {
    if (list.isEmpty || list.head != i) i
    else findMissing(list.tail, i + 1)
  }
  if (a.isEmpty) 1 else findMissing(a.sorted.toList, 1)
}

mySolution2(Array(2, 3, 1, 5))
mySolution2(Array(2, 3, 4, 5))
mySolution2(Array())