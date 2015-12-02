import annotation.tailrec
case class PrimeFactors() {

  def primeFactors(number: Long): List[Long] = getListOfFactors(number)

  @tailrec
  private def getListOfFactors(number: Long, list: List[Long] = List(), factor: Long = 2): List[Long] = {
    if (number < 2){
      list 
    }else if (number == factor) {
      list ::: List(factor)
    } else if (number % factor == 0) {
      getListOfFactors(number / factor, list ::: List(factor),  factor)
    } else {
      getListOfFactors(number, list, factor + 1)
    }
  }


}