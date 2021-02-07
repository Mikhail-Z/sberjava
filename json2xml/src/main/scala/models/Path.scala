package models
import scala.xml.Elem

class Path(val code: String, val value: String) extends XmlSerializable {
  override def toXml: Elem =
    <path>
      <code>{code}</code>
      <value>{value}</value>
    </path>
}
