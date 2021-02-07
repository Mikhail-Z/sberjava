package models

import scala.xml.Elem

class Bundle(val paths: List[Path], val values: List[String]) extends XmlSerializable {

  override def toXml: Elem =
    <bundle>
      <paths>
        {paths.map(path => path.toXml)}
      </paths>
      <values>
        {values.map(value => <value>{value}</value>)}
      </values>
    </bundle>
}
