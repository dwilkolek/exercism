
case class Squares() {
  def squareOfSums(count:Int):Int = {
    var result = 0
    for (a <- 1 to count) {
      result += a;
    }
    result*result
  }
  
  def sumOfSquares(count:Int):Int = {
    var result = 0
    for (a <- 1 to count) {
      result += a*a;
    }
    result
  }
  
  def difference(count:Int):Int = {
    squareOfSums(count) - sumOfSquares(count)
  }
}