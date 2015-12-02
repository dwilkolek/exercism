import scala.collection.mutable.LinkedHashMap
import annotation.tailrec

case class RomanNumeral(val number: Int) {
  lazy val value: String = v(0, number)

  @tailrec
  private def v(i: Int, rest: Int, romanNumber:String = ""): String = rest match {
      case 0 => romanNumber
      case _ => {
          val romanNumberIsSmallerThatRest = rest >= RomanNumeral.romanMap(i)._1
          
          val nextRest:Int = if (romanNumberIsSmallerThatRest) rest - RomanNumeral.romanMap(i)._1 else rest;
          val nextI:Int = if (nextRest >= RomanNumeral.romanMap(i)._1) i else i + 1;
          val nextRomanNumber = if (romanNumberIsSmallerThatRest) romanNumber + RomanNumeral.romanMap(i)._2 else romanNumber;
          
          v(nextI, nextRest, nextRomanNumber)
       }
  }

}
object RomanNumeral {
  val romanMap = List[Tuple2[Int, String]](
    1000 -> "M", 900 -> "CM", 500 -> "D", 400 -> "CD",
    100 -> "C", 90 -> "XC", 50 -> "L", 40 -> "XL",
    10 -> "X", 9 -> "IX", 5 -> "V", 4 -> "IV", 1 -> "I");
}

