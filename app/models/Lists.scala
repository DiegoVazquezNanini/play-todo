package models

import play.api.libs.json._

case class List(name: String, description: String)

object List {
  
  implicit val ListFormat = Json.format[List]
}