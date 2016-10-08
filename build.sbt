name := "berlin-clock"

version := "1.0"

scalaVersion := "2.11.8"

mainClass in (Compile, run) := Some("BerlinClockMainLauncher")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"
libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19"
