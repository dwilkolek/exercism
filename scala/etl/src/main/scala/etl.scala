
import scala.collection.mutable;

object ETL {
  def transform(values : Map[Int, Seq[String]]) = {
    val result = mutable.HashMap[String, Int]()
    
    values.foreach( f => {
      val score = f._1;
      f._2.foreach { word => result.put(word.toLowerCase, score) }
    })
    
    result
  }
}