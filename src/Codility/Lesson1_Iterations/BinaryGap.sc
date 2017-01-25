//number 20 has binary representation 10100 and contains
//one binary gap of length 1. The number 15 has binary
//representation 1111 and has no binary gaps.
def solution(N: Int): Int = {
  val binary = N.toBinaryString
  var counting = false
  var counter = 0
  var maxCounter = 0
  for (n <- binary.reverse) {
    if (counting) {
      if (n == '0') counter += 1
      if (n == '1') {
        if (maxCounter < counter) maxCounter = counter
        counter = 0
      }
    }
    if (n == '1') counting = true
  }
  maxCounter
}

solution(1041)
solution(15)

//that, given a positive integer N, returns the length of its longest binary gap.
//The function should return 0 if N doesn't contain a binary gap.
//
//For example, given N = 1041 the function should return 5,
//because N has binary representation 10000010001 and so
//its longest binary gap is of length 5.
//expected worst-case time complexity is O(log(N));
//expected worst-case space complexity is O(1).

def mySolution(n: Int): Int = {
  val binaryString: String = n.toBinaryString
  var counter: Int = 0
  var maxCounter: Int = 0
  var isCounting: Boolean = false

  //10000010001
  for (n <- binaryString.reverse) {
    if (isCounting) {
      if (n == '0') counter += 1
      if (n == '1') {
        if (counter > maxCounter) maxCounter = counter
        counter = 0
      }
    }
    if (n == '1') isCounting = true
  }
  maxCounter
}

mySolution(1041)
mySolution(15)
/*
1. 先將數字變成二進位
2. 輪循數字
3. 先不計數，遇到第一個 1 開始計數
4. 其後遇到零增加計數
5. 如果又遇到 1 結束計數，與最大計數比較，如果比最大計數大，就取代
6. 需要的參數，是否在計數，計數，最大計數
*/