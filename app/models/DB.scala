package models

import sorm._

object DB extends Instance(entities = Set(Entity[List]()), url = "jdbc:h2:mem:list")