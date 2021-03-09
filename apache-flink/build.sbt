name := "apache-flink"

version := "0.1"

scalaVersion := "2.11.8"

lazy val flinkVersion = "1.8.0"

libraryDependencies ++= Seq(
  "org.apache.flink" %% "flink-scala" % flinkVersion,
  "org.apache.flink" %% "flink-clients" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion

)