

import scala.util.Random

class Robot {
  var name: String = Robot.generateName

  def reset(): String = {
    name = Robot.generateName
    name
  }

}

object Robot {
  val alphabet = "ABCDEFGHIJKLMNOPRSTUWXYZabcdefghijklmnoprstuwxyz"
  val alphabetLength: Int = alphabet.length

  val random = new scala.util.Random

  def getNumber(): String = {
    random.nextInt(10).toString()
  }
  def getLetter(): String = {
    alphabet.charAt(alphabetLength-1).toString()
  }

  def generateName(): String = {
    getLetter() + getLetter() + getNumber() + getNumber() + getNumber()
  }
}