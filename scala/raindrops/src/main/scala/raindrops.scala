import annotation.tailrec

case class Raindrops() {
  def convert(number:Int) : String = {
    val primes = PrimeFactors().primeFactors(number).distinct
    
    
    val translation = getTranslation(primes)
    return if (translation isEmpty) number.toString else translation
  }
  
  def getTranslation(primes: List[Int], currentTranslation:String = "") : String = {
    primes.size match {
      case 0 => currentTranslation
      case _ => {
        val prime:Long = primes.take(1)(0);
        val leftPrimes = primes.drop(1);
        prime match {
          case 3 => getTranslation(leftPrimes, currentTranslation + "Pling")
          case 5 => getTranslation(leftPrimes, currentTranslation + "Plang")
          case 7 => getTranslation(leftPrimes, currentTranslation + "Plong")
          case _ => getTranslation(leftPrimes, currentTranslation)
        }
      }
    } 
  }
}

/* from prime-factors */
case class PrimeFactors() {

  def primeFactors(number: Long): List[Int] = getListOfFactors(number)

  @tailrec
  private def getListOfFactors(number: Long, list: List[Int] = List(), factor: Int = 2): List[Int] = {
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