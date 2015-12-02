class Phrase(phrase:String) {
  def wordCount : Map[String,Int] = {
    def separator = " "
    def notWords = """[\W&&[^']]"""
    
    phrase
    .toLowerCase()
    .replaceAll(notWords,separator)
    .replaceAll("([ ]+)"," ")
    .split(separator)
    .toSeq
    .groupBy(identity)
    .mapValues(_.length)
  }
}