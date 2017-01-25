//A small frog wants to get to the other side of the road.
//The frog is currently located at position X and wants
//to get to a position greater than or equal to Y. The
//small frog always jumps a fixed distance, D.
//
//Count the minimal number of jumps that the small frog
//must perform to reach its target.
//
def solution(X: Int, Y: Int, D: Int): Int = {
  if ((Y - X) % D == 0) (Y - X) / D
  else (Y - X) / D + 1
}

//For example, given:
//X = 10
//Y = 85
//D = 30
solution(10, 85, 30)
//the function should return 3,
//because the frog will be positioned as follows:
//
//  after the first jump, at position 10 + 30 = 40
//after the second jump, at position 10 + 30 + 30 = 70
//after the third jump, at position 10 + 30 + 30 + 30 = 100
//
//Assume that:
//
//  X, Y and D are integers within the range [1..1,000,000,000];
//X ≤ Y.
//
//  Complexity:
//
//  expected worst-case time complexity is O(1);
//expected worst-case space complexity is O(1).
//

def mySolution(x: Int, y: Int, d: Int): Int = {
  val distance = y - x
  val foot = distance / d
  if (distance % d > 0) foot + 1 else foot
}
mySolution(10, 85, 30)