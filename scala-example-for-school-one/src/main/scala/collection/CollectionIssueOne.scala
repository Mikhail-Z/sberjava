package collection

import scala.math.random
import scala.util.Random

/**
 * Заполнить массив заданной длины произвольными положительными числами.
 * Провести анализ списка и найти все числа, которые делятся на два, делятся на три и делятся и на два, и на три.
 * При срабатывании условия выводить соответствующую запись в консоль.
 * Фильтрацию сделать двумя способами:
 * 1) паттерн-матчинг
 * 2) filter
 * */

object CollectionIssueOne {
  val sequenceSize = 10
  val rand: Random = new Random()

  def main(args: Array[String]): Unit = {
    val filledArray: Array[Int] = generateRandomSequence(sequenceSize)
    printMultipleOfTwoOrThreeV1(filledArray)
    println()
    printMultipleOfTwoOrThreeV2(filledArray)
  }

  def generateRandomSequence(n: Int): Array[Int] = Range.apply(0, n).map(_ => rand.nextInt(Int.MaxValue)).toArray

  def printMultipleOfTwoOrThreeV1(numbers: Array[Int]): Unit = {
    numbers.foreach(x => {
      multiplicityTwoOrThreeСondition(x) match {
        case true => println(x.toString)
        case _ =>
      }
    })
  }

  def multiplicityTwoOrThreeСondition(x: Int): Boolean = x % 2 == 0 | x % 3 == 0

  def printMultipleOfTwoOrThreeV2(numbers: Array[Int]): Unit =
    numbers
      .filter(x => multiplicityTwoOrThreeСondition(x))
      .foreach(x => println(x.toString))
}
