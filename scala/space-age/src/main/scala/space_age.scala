
case class SpaceAge(time: Long) {
  def seconds: Long = { time };
  
  private def onExactEarth(): Double = {
    time / (SpaceAge.EARTH_YEAR / 1.0)
  }
  
  def onEarth(): Double = {
    SpaceAge.round(onExactEarth)
  }

  def onMercury(): Double = {
    doOtherPlanet(SpaceAge.MERCURY)
  }
  def onVenus(): Double = {
    doOtherPlanet(SpaceAge.VENUS)
  }
  def onMars(): Double = {
    doOtherPlanet(SpaceAge.MARS)
  }
  def onJupiter(): Double = {
    doOtherPlanet(SpaceAge.JUPITER)
  }
  def onSaturn(): Double = {
    doOtherPlanet(SpaceAge.SATURN)
  }
  def onUranus(): Double = {
    doOtherPlanet(SpaceAge.URANUS)
  }
  def onNeptune(): Double = {
    doOtherPlanet(SpaceAge.NEPTUNE)
  }

  def doOtherPlanet(mod: Double): Double = {
    SpaceAge.round(onExactEarth() / (mod / 1.0))
  }
}

object SpaceAge {
  val EARTH_YEAR = 31557600
  val MERCURY = 0.2408467
  val VENUS = 0.61519726
  val MARS = 1.8808158
  val JUPITER = 11.862615
  val SATURN = 29.447498
  val URANUS = 84.016846
  val NEPTUNE = 164.79132

  def round(value: Double): Double = {
    Math.round(value * 100) / 100.0
  }

}
