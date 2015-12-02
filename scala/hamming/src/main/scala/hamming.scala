import scala._

/**
 * @author Slishu
 */
object Hamming {
  
  @throws(classOf[IllegalArgumentException])
  def compute(lineA:String, lineB:String) : Int = {
    
    if (lineA.length != lineB.length) {
      throw new IllegalArgumentException
    }
    lineA.zip(lineB).count(letter => letter._1 != letter._2)
  }
}
