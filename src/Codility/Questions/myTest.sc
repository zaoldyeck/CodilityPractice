

class IntList(var value: Int, var next: IntList)

def solution4(l: IntList): Int = {
  var count = 0
  if (l.value != null) {
    count += 1
    solution4(l.next)
  }
  count
}