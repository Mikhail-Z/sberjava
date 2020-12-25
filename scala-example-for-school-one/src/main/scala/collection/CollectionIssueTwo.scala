package collection

object CollectionIssueTwo {

  /**
   * Создать функцию, принимающую два числа,
   * которая выполняет сложение пары числе
   * из положительного диапазона, сумма которых равна
   * количеству элементов диапазона
   * в результате в консоль нужно вывести - (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
   * Используется конструкция for-yield
   * */

  def main(args: Array[String]): Unit = {
    foo(0, 10) foreach {
      case (i, j) =>
        println(s"($i, $j) ")
    }
  }

  def foo(a: Int, b: Int): IndexedSeq[(Int, Int)] = {
    for (i <- a until b;
         j <- i until b if i + j == a + b)
      yield (i, j)
  }
}
