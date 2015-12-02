object Grains {
  def square(square:Int):BigInt = {
     BigInt(2) pow (square-1)
  }
  lazy val total = {
    var result = BigInt(0)
    for (i <- 1 to 64) {
      result += square(i)
    }
    result
  }
}