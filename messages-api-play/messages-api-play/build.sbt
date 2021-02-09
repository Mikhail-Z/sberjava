name := """messages-api-play"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.3"

libraryDependencies += "com.google.inject" % "guice" % "5.0.0-BETA-1"
libraryDependencies += openId

PlayKeys.devSettings := Seq("play.server.http.port" -> "5000")