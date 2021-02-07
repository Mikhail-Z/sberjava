name := "json2xml"

version := "0.1"

scalaVersion := "2.13.4"

val json4sNative = "org.json4s" %% "json4s-native" % "3.6.10"
val json4sJackson = "org.json4s" %% "json4s-jackson" % "3.6.10"
val xmlLib = "org.scala-lang.modules" %% "scala-xml" % "1.3.0"

// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.12.1"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.12.1"


libraryDependencies ++= Seq(
  /*"com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.1.3",*/
  json4sNative,
  json4sJackson,
  xmlLib,
)