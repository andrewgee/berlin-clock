package net.andrewgee.berlinclock

import java.io.PrintStream

import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, FlatSpec}

class BerlinClockLauncherSpec extends FlatSpec with MockitoSugar with BeforeAndAfter {
  val testBerlinClockLauncher = new BerlinClockLauncher {
    override val out: PrintStream = spy(System.out)
  }

  before {
    reset(testBerlinClockLauncher.out)
  }

  "Main launcher" should "print usage for no arguments" in {
    intercept[RuntimeException] {
      testBerlinClockLauncher.main(Array.empty)
    }
    verify(testBerlinClockLauncher.out).println("Usage: BerlinClockLauncher <hour> <minute> <second>")
  }

  it should "print usage for 2 arguments" in {
    intercept[RuntimeException] {
      testBerlinClockLauncher.main(Array("0","0"))
    }
    verify(testBerlinClockLauncher.out).println("Usage: BerlinClockLauncher <hour> <minute> <second>")
  }

  it should "print usage for 4 arguments" in {
    intercept[RuntimeException] {
      testBerlinClockLauncher.main(Array("0","0","0","0"))
    }
    verify(testBerlinClockLauncher.out).println("Usage: BerlinClockLauncher <hour> <minute> <second>")
  }

  it should "print usage for non-numeric arguments" in {
    intercept[RuntimeException] {
      testBerlinClockLauncher.main(Array("a","0","0"))
    }
    verify(testBerlinClockLauncher.out).println("Usage: BerlinClockLauncher <hour> <minute> <second>")
  }

  it should "print error and usage for hours out of bounds" in {
    intercept[RuntimeException] {
      testBerlinClockLauncher.main(Array("-1", "0", "0"))
    }
    verify(testBerlinClockLauncher.out).print("<hour> must be between 0 and 23")
    verify(testBerlinClockLauncher.out).println("Usage: BerlinClockLauncher <hour> <minute> <second>")
  }

  it should "print error and usage for minutes out of bounds" in {
    intercept[RuntimeException] {
      testBerlinClockLauncher.main(Array("0", "-1", "0"))
    }
    verify(testBerlinClockLauncher.out).print("<minute> must be between 0 and 59")
    verify(testBerlinClockLauncher.out).println("Usage: BerlinClockLauncher <hour> <minute> <second>")
  }

  it should "print error and usage for seconds out of bounds" in {
    intercept[RuntimeException] {
      testBerlinClockLauncher.main(Array("0", "0", "-1"))
    }
    verify(testBerlinClockLauncher.out).print("<second> must be between 0 and 59")
    verify(testBerlinClockLauncher.out).println("Usage: BerlinClockLauncher <hour> <minute> <second>")
  }

  it should "not return exception for valid arguments" in {
    testBerlinClockLauncher.main(Array("0","0","0"))
  }

  it should "print expected clock" in {
    testBerlinClockLauncher.main(Array("09","27","10"))
    verify(testBerlinClockLauncher.out).println("" +
      "     #\n" +
      " R  #  #  #\n" +
      " R  R  R  R\n" +
      "YYRYY######\n" +
      " Y  Y  #  #"
    )
  }
}
