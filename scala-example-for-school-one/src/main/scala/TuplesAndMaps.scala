
/**
 * Примеры создания и работы с Tuple
 * */

object TuplesAndMaps extends App {

  val myTuple = new Tuple2(2, "hello, Scala")
  val myTuple2 = Tuple2(2, "hello, Scala")
  val myTuple3 = (2, "hello, Scala")

  println(myTuple._1)
  println(myTuple.copy(_2 = "hello, Ivanov"))
  println(myTuple.swap)

  val myMap: Map[String, Int] = Map()
  val myPhonebook = Map(("Ivanov", 111), ("Petrov", 222))
  val myPhonebook2 = Map(("Ivanov", 111), "Petrov" -> 222)

  println(myPhonebook)
  println(myPhonebook)

  println(myPhonebook.contains("Ivanov"))
  println(myPhonebook.apply("Ivanov"))
  println(myPhonebook("Ivanov"))

  //  println(phonebook("Ted")) // throws an exception

  val phonebook3 = Map(("Ivanov", 111), "Petrov" -> 222).withDefaultValue(-1)
  val newPairing = "Sidorov" -> 678
  val newPhonebook = myPhonebook + newPairing

  println(newPhonebook)
  println(myPhonebook.map(pair => pair._1.toLowerCase -> pair._2)) // returns: Map(Ivanov -> 111, Petrov -> 222)
  println(myPhonebook.filterKeys(x => x.startsWith("I")))
  println(myPhonebook.filterKeys(_.startsWith("I")))
  println(myPhonebook.mapValues(number => number * 10))
  println(myPhonebook.mapValues(number => "0845-" + number )) // returns: Map(Ivanov -> 0845-111, Petrov -> 0845-222)
  println(myPhonebook.toList) // returns: List((Ivanov,555), (Petrov,666))
  println(List(("Daniel", 111)).toMap) // returns: Map(Daniel -> 555)

  val names = List("Petrov", "Ivanov", "Angela", "Sidorov", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

}