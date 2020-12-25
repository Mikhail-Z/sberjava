import scala.collection.mutable.ListBuffer

object CollectionExampleBasics {

  def main(args: Array[String]): Unit = {

    val r = scala.util.Random
    val nums = for (i <- 1 to 5) yield r.nextInt(100)

    var numsTail = 1 :: (2 :: (3 :: (4 :: Nil)))

    var numsCloneBuffer = new ListBuffer[String]()
    numsCloneBuffer += "1"
    numsCloneBuffer += "2"
    numsCloneBuffer += "3"
    numsCloneBuffer += "4"
    val numsClone = numsCloneBuffer.toList

    println( "Head of nums : " + numsTail.head )
    println( "Tail of nums : " + numsTail.tail )
    println( "Check if nums is empty : " + numsTail.isEmpty )

    println("")

    println( "Head of fruits : " + numsClone.head )
    println( "Tail of fruits : " + numsClone.tail )
    println( "Check if fruits is empty : " + numsClone.isEmpty )

    println("")

    println(numsTail.filter(x => x < 3))
    println("")
    println("Nums" + nums)

  }

}
