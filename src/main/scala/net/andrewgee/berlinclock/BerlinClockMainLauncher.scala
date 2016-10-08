package net.andrewgee.berlinclock

import java.io.PrintStream

object BerlinClockMainLauncher extends App {
  val launcher = new BerlinClockLauncher {
    override val out: PrintStream = System.out
  }

  launcher.main(args)
}
