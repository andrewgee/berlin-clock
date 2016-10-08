package net.andrewgee.berlinclock

sealed case class Lamp(colour: Char) {
  def *(n: Int): List[Lamp] = List.fill(n)(this)

  override def toString: String = colour.toString
}

object YellowLamp extends Lamp('Y')
object RedLamp extends Lamp('R')
object OffLamp extends Lamp('#')
