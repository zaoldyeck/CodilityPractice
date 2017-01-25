def solution(year: Int): List[Boolean] = {
  var leapYear = false
  var huluculu = false
  var bulukulu = false

  if (year % 15 == 0) {
    huluculu = true
  }

  if (year % 4 == 0) {
    if (year % 100 == 0) {
      if (year % 400 == 0) {
        leapYear = true
      }
    } else {
      leapYear = true
    }
  }

  if (leapYear && year % 55 == 0) {
    bulukulu = true
  }
  List(leapYear, huluculu, bulukulu)
}

solution(2000) //1,0,0
solution(3600) //1,1,0
solution(4515) //0,1,0
solution(2001) //0,0,0