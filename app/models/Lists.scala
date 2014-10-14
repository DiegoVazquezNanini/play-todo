package models

import play.api.libs.json._

case class Board (
  id: Int,
  name: String,
  description: String,
  items: List[Item]
)
object Board {

  implicit val ListFormat = Json.format[Board]
}

case class Item(
  title: String,
  description: String
//  state: Int
)
object Item {

  implicit val ListFormat = Json.format[Item]
}
