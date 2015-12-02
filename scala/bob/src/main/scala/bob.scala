

/**
 * @author Slishu
 */
class Bob {
  def hey(talking:String) : String = {
   
    val msg = talking.trim   
    var answer:String = "Whatever.";
    
    def question():Boolean = {
      msg.takeRight(1) == "?" && (msg.toUpperCase != msg || msg.exists { _.isDigit } )
    }  
    def shout():Boolean = {
      msg.toUpperCase == msg && msg.exists { _.isLetter }
    }
    
    
    if (msg.isEmpty()){
      answer = "Fine. Be that way!";
    } else if (question()) {
      answer = "Sure.";
    } else if (shout()){
      answer = "Whoa, chill out!";
    }
    
    answer
  }
}