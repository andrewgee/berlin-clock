package net.andrewgee.berlinclock

import org.scalatest.{FlatSpec, Matchers}

class BerlinClockSpec extends FlatSpec with Matchers {
  "berlinClockMinutesRow" should "return #### for 0 minutes" in {
    BerlinClock.minuteRow(0) shouldBe List(OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 1 minute" in {
    BerlinClock.minuteRow(1) shouldBe List(YellowLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 4 minutes" in {
    BerlinClock.minuteRow(4) shouldBe List(YellowLamp, YellowLamp, YellowLamp, YellowLamp)
  }

  it should "return for 5 minutes" in {
    BerlinClock.minuteRow(5) shouldBe List(OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 7 minutes" in {
    BerlinClock.minuteRow(7) shouldBe List(YellowLamp, YellowLamp, OffLamp, OffLamp)
  }

  it should "return for 60 minutes" in {
    BerlinClock.minuteRow(60) shouldBe List(OffLamp, OffLamp, OffLamp, OffLamp)
  }

  "Five minute row" should "return correctly for 0 minutes" in {
    BerlinClock.fiveMinuteRow(0) shouldBe
      List(OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 4 minutes" in {
    BerlinClock.fiveMinuteRow(4) shouldBe
      List(OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 5 minutes" in {
    BerlinClock.fiveMinuteRow(5) shouldBe
      List(YellowLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 9 minutes" in {
    BerlinClock.fiveMinuteRow(9) shouldBe
      List(YellowLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 10 minutes" in {
    BerlinClock.fiveMinuteRow(10) shouldBe
      List(YellowLamp, YellowLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 15 minutes" in {
    BerlinClock.fiveMinuteRow(15) shouldBe
      List(YellowLamp, YellowLamp, RedLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 20 minutes" in {
    BerlinClock.fiveMinuteRow(20) shouldBe
      List(YellowLamp, YellowLamp, RedLamp, YellowLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 45 minutes" in {
    BerlinClock.fiveMinuteRow(45) shouldBe
      List(YellowLamp, YellowLamp, RedLamp, YellowLamp, YellowLamp, RedLamp, YellowLamp, YellowLamp, RedLamp, OffLamp, OffLamp)
  }

  it should "return for 60 minutes" in {
    BerlinClock.fiveMinuteRow(60) shouldBe
      List(OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp, OffLamp)
  }

  "Hour row" should "return for 0 hours" in {
    BerlinClock.hourRow(0) shouldBe List(OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 1 hour" in {
    BerlinClock.hourRow(1) shouldBe List(RedLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 4 hour" in {
    BerlinClock.hourRow(4) shouldBe List(RedLamp, RedLamp, RedLamp, RedLamp)
  }

  it should "return for 5 hour" in {
    BerlinClock.hourRow(5) shouldBe List(OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 24 hour" in {
    BerlinClock.hourRow(24) shouldBe List(OffLamp, OffLamp, OffLamp, OffLamp)
  }

  "Five Hour row" should "return for 0 hours" in {
    BerlinClock.fiveHourRow(0) shouldBe List(OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 4 hours" in {
    BerlinClock.fiveHourRow(4) shouldBe List(OffLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 5 hours" in {
    BerlinClock.fiveHourRow(5) shouldBe List(RedLamp, OffLamp, OffLamp, OffLamp)
  }

  it should "return for 10 hours" in {
    BerlinClock.fiveHourRow(10) shouldBe List(RedLamp, RedLamp, OffLamp, OffLamp)
  }

  it should "return for 15 hours" in {
    BerlinClock.fiveHourRow(15) shouldBe List(RedLamp, RedLamp, RedLamp, OffLamp)
  }

  it should "return for 23 hours" in {
    BerlinClock.fiveHourRow(23) shouldBe List(RedLamp, RedLamp, RedLamp, RedLamp)
  }

  it should "return for 24 hours" in {
    BerlinClock.fiveHourRow(24) shouldBe List(OffLamp, OffLamp, OffLamp, OffLamp)
  }

  "Second lamp" should "return for 0 seconds" in {
    BerlinClock.secondLamp(0) shouldBe OffLamp
  }

  it should "return for 1 seconds" in {
    BerlinClock.secondLamp(1) shouldBe YellowLamp
  }

  it should "return for 2 seconds" in {
    BerlinClock.secondLamp(2) shouldBe OffLamp
  }

  it should "return for 3 seconds" in {
    BerlinClock.secondLamp(3) shouldBe YellowLamp
  }

}
