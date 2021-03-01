package com.company.rdd.actions

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

import scala.Console.println

/**
 * Рассмотрите код. Объясните результат работы каждого использованного action.
 */
object ActionsExample extends App {
  val userWindows = System.getenv("HADOOP_HOME")
  println(userWindows)
  Logger.getLogger("org").setLevel(Level.ERROR)
  val conf = new SparkConf().setAppName("collect").setMaster("local[*]")
  val sc = new SparkContext(conf)

  val inputWords = List("spark", "hadoop", "spark", "hive", "pig", "cassandra", "hadoop")
  val wordRdd = sc.parallelize(inputWords)
  for (word <- wordRdd.cartesian(wordRdd)) println(word)
  //for (newWord <- wordRdd.cartesian(wordRdd)) println(newWord)

  println("-----------------")
  println("Collect example: ")
  val words = wordRdd.collect()
  for (word <- words) println(word)

  println("-----------------")
  println("Count: " + wordRdd.count())

  val wordCountByValue = wordRdd.countByValue()
  println("CountByValue:")

  for ((word, count) <- wordCountByValue) println(word + " : " + count)

  println("-----------------")
  println("Take:")
  val takeWords = wordRdd.take(3)
  for (word <- takeWords) println(word)

  println("-----------------")
  println("Reduce:")
  val inputIntegers = List(1, 2, 3, 4, 5)
  val integerRdd = sc.parallelize(inputIntegers)

  val product = integerRdd.reduce((x, y) => x * y)
  println("product is :" + product)

}
