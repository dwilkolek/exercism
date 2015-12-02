import java.util.GregorianCalendar
import java.util.Calendar

case class Meetup(month: Int, year: Int) {
  def teenth(day: Int): GregorianCalendar = {
    val cal = new GregorianCalendar()
    cal.set(year, month - 1, 13);
    val tenthDay = cal.get(Calendar.DAY_OF_WEEK)
    val diff = tenthDay - day;
    val diffNeeded = if (tenthDay > day) 7 - diff else diff;

    cal.set(Calendar.DAY_OF_MONTH, 13 + diffNeeded.abs)

    new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)) //comparing calendars is not working pretty well in scala
  }

  def first(day: Int): GregorianCalendar = {
    val cal = new GregorianCalendar();
    cal.set(year, month - 1, 1);
    val firstDay = cal.get(Calendar.DAY_OF_WEEK)
    val diff = firstDay - day;
    val diffNeeded = if (firstDay <= day) diff else 7 - firstDay + day

    cal.set(Calendar.DAY_OF_MONTH, 1 + diffNeeded.abs)

    new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
  }
  def second(day: Int): GregorianCalendar = {
    val d = first(day);
    d.add(Calendar.DATE, 7);
    d
  }
  def third(day: Int): GregorianCalendar = {
    val d = first(day)
    d.add(Calendar.DATE, 14);
    d
  }
  def fourth(day: Int): GregorianCalendar = {
    val d = first(day)
    d.add(Calendar.DATE, 21);
    d
  }

  def last(day: Int): GregorianCalendar = {
    val cal = first(day)
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

    val lastDay = cal.get(Calendar.DAY_OF_WEEK);
    println(lastDay > day, lastDay, day)
    if (lastDay < day) {
      val choosenDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH) - (7 - (day - lastDay))
      cal.set(Calendar.DAY_OF_MONTH, choosenDay)
    } else {
      val choosenDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH) - (lastDay - day)
      cal.set(Calendar.DAY_OF_MONTH, choosenDay)
    }

    new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
  }

}

object Meetup {
  val Mon = Calendar.MONDAY
  val Tue = Calendar.TUESDAY
  val Wed = Calendar.WEDNESDAY
  val Thu = Calendar.THURSDAY
  val Fri = Calendar.FRIDAY
  val Sat = Calendar.SATURDAY
  val Sun = Calendar.SUNDAY
}