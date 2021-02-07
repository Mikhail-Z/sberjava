package models

import scala.xml.Elem

class JsonFileClass(version: String, parameters: List[JsonParameters]) extends XmlSerializable {
  override def toXml: Elem =
    <jsonFileClass>
      <version>{version}</version>
      <parameters>
        {parameters.map(par => par.toXml)}
      </parameters>
    </jsonFileClass>
}
