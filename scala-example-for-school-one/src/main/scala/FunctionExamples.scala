/**
 * Пример использования map, flatten, flatMap
 * */


object FunctionExamples {

  def main(args: Array[String]): Unit = {

    println(Seq("apple", "banana", "orange"))
    println(Seq("apple", "banana", "orange").map(_.toUpperCase()))
    println(Seq("apple", "banana", "orange").flatMap(_.toUpperCase()))
    println(Seq("apple", "banana", "orange").map(_.toUpperCase()).flatten)

    val strings = Seq(("1", 1), ("2", 2), ("foo", 3), ("3", 4), ("bar", 5))
    println(strings.map(_._1))
    println(strings.flatMap(_._1))
    println(strings.flatMap(_._1).sum)

    val opt = Option(("2", 1))
//    opt.flatMap(toInt).flatMap(toStr)
  }

  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  def toStr(s: Int): Some[String] = {
    Some(s.toString)
  }


}
