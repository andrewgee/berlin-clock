package net.andrewgee.berlinclock

object BerlinClock {
  def clock(hours: Int, minutes: Int, seconds: Int): String = {
    "     " + secondLamp(seconds) + "\n" +
    " " + fiveHourRow(hours).mkString("  ") + "\n" +
    " " + hourRow(hours).mkString("  ") + "\n" +
    fiveMinuteRow(minutes).mkString("") + "\n" +
    " " + minuteRow(minutes).mkString("  ")
  }

  private[berlinclock] def secondLamp(seconds: Int): Lamp = if (seconds % Reference.secondPulse == 0) OffLamp else YellowLamp

  private[berlinclock] def fiveHourRow(hours: Int): List[Lamp] = {
    val lit = (hours % Reference.hoursInDay) / (Reference.fiveHourRowLength + 1)
    RedLamp * lit ::: OffLamp * (Reference.fiveHourRowLength - lit)
  }
  private[berlinclock] def fiveMinuteRow(minutes: Int): List[Lamp] = {
    def newLamp(light: Int): Lamp = {
      if (light % Reference.fiveMinuteRowRedLampOffset == 0) {
        RedLamp
      } else {
        YellowLamp
      }
    }

    val lit = (minutes % Reference.minutesInHour) / (Reference.minuteRowLength + 1)
    (1 to lit).map(newLamp).toList ::: OffLamp * (Reference.fiveMinuteRowLength - lit)
  }

  private[berlinclock] def hourRow(hours: Int): List[Lamp] = singleRow(hours % Reference.hoursInDay, RedLamp, Reference.hourRowLength)
  private[berlinclock] def minuteRow(minutes: Int): List[Lamp] = singleRow(minutes, YellowLamp, Reference.minuteRowLength)
  private[berlinclock] def singleRow(n: Int, light: Lamp, length: Int): List[Lamp] = {
    val lit = n % (length + 1)
    light * lit ::: OffLamp * (length - lit)
  }
}
