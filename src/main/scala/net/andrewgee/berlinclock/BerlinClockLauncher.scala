package net.andrewgee.berlinclock

import java.io.PrintStream

trait BerlinClockLauncher {
  val out: PrintStream

  def main(args: Array[String]): Unit = {
    if (args.length != 3) {
      usage()
    }

    val clockString = for {
      hour <- toPositiveInt(args(0), 23, "hour")
      minute <- toPositiveInt(args(1), 59, "minute")
      second <- toPositiveInt(args(2), 59, "second")
    } yield {
      BerlinClock.clock(hour, minute, second)
    }

    clockString match {
      case Some(clockOutput) => out.println(clockOutput)
      case None => usage()
    }
  }


  private def usage(): Unit = {
    out.println("Usage: BerlinClockLauncher <hour> <minute> <second>")
    throw new RuntimeException("invalid input")
  }

  private def toPositiveInt(s: String, max: Int, name: String): Option[Int] = {
    try {
      val result = Some(s.toInt).filter(n => n <= max && n >= 0)

      if (result.isEmpty) {
        out.println(s"<$name> must be between 0 and $max")
      }

      result
    } catch {
      case e: Exception => None
    }
  }
}
