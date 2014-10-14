package models

import sorm._

object DB extends Instance(entities = Set(Entity[Board]()), url = "jdbc:h2:mem:lists")