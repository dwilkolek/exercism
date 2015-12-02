

/**
 * @author Slishu
 */
class PhoneNumber(n:String) {
  
  val filteredNumber = n.filter { _.isDigit }

  val firstLetterCheck = filteredNumber.take(1) == "1"
  
  val longerNumber = firstLetterCheck && filteredNumber.length == 11
  val shorterNumber = filteredNumber.length == 10
  
  val correctNumber = if (longerNumber || shorterNumber) filteredNumber.substring(filteredNumber.length-10, filteredNumber.length) else "0000000000";
  
  def number():String = {
    correctNumber
  }
  
  def areaCode():String = {
    correctNumber.take(3);
  }
  
  private def usersNumber():String = {
    correctNumber.takeRight(7)
  }
  
  override def toString():String = {
    "(" + areaCode + ") " + usersNumber.take(3) + "-"+ usersNumber.takeRight(4)
  }
}