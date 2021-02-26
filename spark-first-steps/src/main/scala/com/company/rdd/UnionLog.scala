package com.company.rdd

import com.company.sql.Log
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

/**
 *"in/log_19950701.tsv" файл содержит 10000 строк лога с одного из серверов за 1 июля 1995 года.
 * "in/log_19950801.tsv" файл содержит 10000 строк лога с одного из серверов за 1 августа 1995 года.
 *  Создайте Spark программу для генерации нового RDD, который содержит лог за оба эти дня.
 *  Возьмите выборку с параметром fraction: 0.1 из полученного RDD и сохраните в файл  "out/logs.tsv"
 *  Учтите, что в исходных файлах содержатся строки с заголовками.
 *  host	logname	time	method	url	response	bytes
 *  Удалите заголовки из результирующего файла.
 */
object UnionLog extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)

  val conf = new SparkConf()
    .setAppName("unionLog")
    .setMaster("local[4]")
    .set("spark.memory.fraction", "0.1")

  val sc = new SparkContext(conf)
  val session = SparkSession.builder()
    .appName("StackOverFlowSurvey")
    .master("local[*]")
    .getOrCreate()

  val dataFrameReader = session.read
  val logs1 = dataFrameReader
    .option("header", "true")
    .option("delimiter", "\t")
    .option("inferSchema", value = true)
    .csv("src/main/resource/in/log_19950701.tsv")
    .select("host", "logname", "time", "method", "url", "response", "bytes")
  val logs2 = dataFrameReader
    .option("header", "true")
    .option("delimiter", "\t")
    .option("inferSchema", value = true)
    .csv("src/main/resource/in/log_19950801.tsv")
    .select("host", "logname", "time", "method", "url", "response", "bytes")

  import session.implicits._
  val allTypedLogs = logs1.union(logs2).as[Log]
  allTypedLogs.toDF().repartition(1).write.option("header", "false").csv("out/log_819950701_1995001.tsv")
}
