

/**
 * @author Slishu
 */
class Anagram(text:String) {
  def matches(sequence:Seq[String]) :Seq[String] = {
    
    def createSeqFromString(s:String) = {
      s.toLowerCase().toSeq groupBy { identity } 
    }
    
    val testSeqFromText = createSeqFromString(text)
    
    sequence.toStream.filter { x => x.toLowerCase() != text.toLowerCase() && createSeqFromString(x) == testSeqFromText}.toSeq
  }
}