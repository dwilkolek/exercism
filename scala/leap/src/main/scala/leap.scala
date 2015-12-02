

case class Year(y:Int) {

  def isLeap:Boolean = {
    val divisableBy4 = y % 4 == 0
    val divisableBy100 = y % 100 == 0
    val divisableBy400 = y % 400 == 0
    
    divisableBy400 || divisableBy4 && !divisableBy100
 
  }
  
}
