
@throws(classOf[RuntimeException])
class DNA(dna: String = "") {
  
  val defaultDNA ="ACTG";
  
  validateDNAString(dna)
  
  def validateDNAString(dna:String) = {if (!dna.matches("([ACGT]+)") && !dna.isEmpty) { throw new RuntimeException }}
  def validateDNANucleotyde(dnaLetter:Char) = {
    if (!defaultDNA.contains(dnaLetter)){
      throw new RuntimeException
    }
  } 
  
  
  @throws(classOf[RuntimeException])
  def nucleotideCounts(): Map[Char, Int] = {
    validateDNAString(dna)
    (dna + defaultDNA).groupBy(identity).mapValues(_.length-1);
  }

  @throws(classOf[RuntimeException])
  def nucleotideCounts(letter: Char): Any = {
    if (!(letter == 'A' || letter == 'C' || letter == 'G' || letter == 'T')){
      throw new RuntimeException
    }
//    if (!dna.matches("([ACGT]+)") && !dna.isEmpty) {
//      throw new RuntimeException
//    }
    val result: Option[Int] = nucleotideCounts.get(letter);

    result.getOrElse(0)
  }

}