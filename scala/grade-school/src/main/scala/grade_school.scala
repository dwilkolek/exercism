
import scala.collection.mutable.SortedSet
import scala.collection.mutable.HashMap;
import scala.collection.mutable.LinkedHashMap

class School {
  
  val db:HashMap[Int,Seq[String]] = new HashMap
  
  
  
  def add(name:String, grade:Int) = {
    val students = db.getOrElse(grade, Seq()) :+ name
    db(grade) = students
  }
  
  def grade(grade:Int):Seq[String] = {
    db.getOrElse(grade, Seq())
  }
  
  private def sortKeys(grade:Int,names:Seq[String]) = {
    names.sorted;
  }
  
  def sorted() = {
    val result:LinkedHashMap[Int,Seq[String]]  = new LinkedHashMap
    val sortedGrades = db.toSeq.sortBy(_._1).toMap;
    sortedGrades.foreach((f) => { result.put(f._1,f._2.sorted) })
    result
  }
}