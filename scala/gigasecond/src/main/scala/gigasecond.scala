


import java.util.GregorianCalendar
import java.util.concurrent.TimeUnit
import java.util.Calendar


case class Gigasecond(calendar:GregorianCalendar) {
  
  val GIGASECOND = Math.pow(10,9).toInt;
  
  def date(): GregorianCalendar = {
    calendar.add(Calendar.SECOND, GIGASECOND);
    calendar
  }
  
}