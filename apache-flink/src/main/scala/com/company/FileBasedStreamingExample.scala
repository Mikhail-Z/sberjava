package com.company

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment, createTypeInformation}
import org.apache.flink.util.Collector

case class WordWithCount(word: String, count: Long)

object FileBasedStreamingExample extends App {
  val env = StreamExecutionEnvironment.createLocalEnvironment(1)

  //TODO прочитайте DataStream из файла "word_count.txt"
  val text:DataStream[String] = env.readTextFile("src/main/resources/word_count.txt")

  // TODO реализуйте Words Count задачу - подсчитайте количество вхождений каждого слова в DataStream.
  //  Используйте case class WordWithCount
  import org.apache.flink.api.common.functions.FlatMapFunction

  val counts = text.flatMap(new InitFunction)
    .keyBy(value => value.word)
    .sum(1);

  //TODO раскомментируй меня
  class InitFunction extends FlatMapFunction[String, WordWithCount] {
    override def flatMap(line: String, collector: Collector[WordWithCount]): Unit = {
      val words: Array[String] = line.toLowerCase.split("\\W+").filter(word => !word.isEmpty)
      for (word <- words) {
        collector.collect(WordWithCount(word, 1))
      }
    }
  }
  counts.print().setParallelism(1)
  env.execute("File Stream WordCount")
}



