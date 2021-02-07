package models

trait XmlSerializable {
  def toXml:xml.Elem
}
