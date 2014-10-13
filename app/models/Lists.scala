package models

import play.api.libs.json._

case class List(
//  id: Int,
  name: String,
  description: String
)

case class Item(
  id: Int,
  title: String,
  description: String,
  state: Int
)

object List {
  
  implicit val ListFormat = Json.format[List]
}