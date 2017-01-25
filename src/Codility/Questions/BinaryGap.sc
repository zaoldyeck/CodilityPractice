// L1 - BinaryGap
def solution5(n: Int): Int = {
  val binaryString: String = n.toBinaryString
  val list: List[Char] = binaryString.toList.reverse // 反轉
  var countZero = 0
  var maxZeroLength = 0
  var hasFirstOne = false
  var exsitZero = false

  for (n <- list) {
    if (hasFirstOne) {
      if (n == '0') {
        countZero += 1
      } else if (n == '1') {
        if (countZero > maxZeroLength) maxZeroLength = countZero
        countZero = 0
      }
    }
    if (n == '1') hasFirstOne = true
  }
  maxZeroLength
}

solution5(1041) // 5