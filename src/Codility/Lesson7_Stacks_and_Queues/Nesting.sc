//A string S consisting of N characters is called
//properly nested if:
//
//S is empty;
//S has the form "(U)" where U is a properly nested string;
//S has the form "VW" where V and W are properly nested strings.
//
//For example, string "(()(())())" is properly nested but string "())" isn't.
import scala.annotation.tailrec
import scala.collection.mutable

def solution(S: String): Int = {
  @tailrec
  def helper(S: List[Char], opened: Int): Boolean = S match {
    case Nil if opened == 0 => true
    case Nil if opened > 0 => false
    case '(' :: tail => helper(tail, opened + 1)
    case ')' :: tail if opened > 0 => helper(tail, opened - 1)
    case ')' :: tail if opened == 0 => false
  }
  if (helper(S.toList, 0)) 1 else 0
}

solution("(()(())())")
solution("())")
//
//that, given a string S consisting of N characters, returns 1 if string S
//is properly nested and 0 otherwise.
//
//For example, given S = "(()(())())", the function should return 1 and
//given S = "())", the function should return 0, as explained above.
//
// expected worst-case time complexity is O(N)

def mySolution(s: String): Int = {
  val chars: List[Char] = s.toList
  val stack: mutable.Stack[Char] = new mutable.Stack
  chars.foreach {
    case s@('(') => stack.push(s)
    case ')' => if (stack.nonEmpty) stack.pop else return 0
    case _ =>
  }

  if (stack.isEmpty) 1 else 0
}

mySolution("(()(())())")
mySolution("())")
mySolution("")