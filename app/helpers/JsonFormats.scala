package helpers

import models.User

object JsonFormats {

  import reactivemongo.play.json._
  import reactivemongo.play.json.collection.JSONCollection
  import play.api.libs.json._

  implicit val userFormat: OFormat[User] = Json.format[User]
}