

/**
 * @author Slishu
 */
class Sublist {
  def sublist(a: List[Any], b: List[Any]): String = {
    var result:String = Sublist.Unequal

    val isSublist = b.containsSlice(a)
    val isSuperList = a.containsSlice(b)
    
    if (isSublist && isSuperList) {
      result = Sublist.Equal
    } else if (isSublist){
      result = Sublist.Sublist
    } else if (isSuperList) {
      result = Sublist.Superlist
    }
   
    result
  }

}

object Sublist {
  val Sublist = "Sublist"
  val Equal = "Equal"
  val Superlist = "Superlist"
  val Unequal = "Unequal"
  
  var c:Int = 0;
}