package models

import scala.xml.Elem

class JsonParameters(val name: String, val `type`: String, val description: String, val isList: Boolean, val roles: List[String])
    extends XmlSerializable {
  override def toXml: Elem =
    <jsonParameters>
      <name>{name}</name>
      <type>{`type`}</type>
      <description>{name}</description>
      <isList>{isList}</isList>
      <roles>{roles.map(role =>
        <role>{role}</role>)}
      </roles>
    </jsonParameters>
}
