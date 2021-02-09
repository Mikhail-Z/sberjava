import java.io.{File, FileReader}

import models.JsonFileClass
import org.json4s._
import org.json4s.jackson._


object JsonToXmlConverter {
  implicit val formats = DefaultFormats

  def main(args: Array[String]): Unit = {
    val jsonFileClass = readJsonFile("test.json")
    saveToXml(jsonFileClass, "test.xml")
  }

  def readJsonFile(fileName: String): JsonFileClass = {
    val source = scala.io.Source.fromFile(fileName)
    val json = try source.mkString finally source.close()
    JsonMethods.parse(json).extract[JsonFileClass]
  }

  def saveToXml(jsonFileClass: JsonFileClass, filePath: String): Unit = {
    scala.xml.XML.save(filePath, jsonFileClass.toXml)
  }
}
