package models

class Types(val value: String) extends Enumeration with XmlSerializable {
  type Types = String

  val STRING = "STRING"
  val BOOLEAN = "BOOLEAN"
  val LONG = "LONG"

  override def toXml:xml.Elem =
    <type>{this.value}</type>
}
