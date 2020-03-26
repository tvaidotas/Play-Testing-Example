package models

import reactivemongo.bson.BSONObjectID

object User {
  def apply(age: Int,
            firstName: String,
            lastName: String,
           ) = new User(BSONObjectID.generate(), age, firstName, lastName)
}

case class User(
                 _id: BSONObjectID,
                 age: Int,
                 firstName: String,
                 lastName: String)
