package Services

import javax.inject.Inject
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}
import reactivemongo.play.json._
import collection._
import models.User
import play.api.libs.json.Json
import reactivemongo.api.Cursor
import play.modules.reactivemongo.{ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.api.commands.WriteResult
import helpers.JsonFormats._

class MongoService @Inject()(
                              val reactiveMongoApi: ReactiveMongoApi
                            ) extends ReactiveMongoComponents {

  implicit val ec: ExecutionContextExecutor = ExecutionContext.global

  def collection: Future[JSONCollection] = reactiveMongoApi.database.map(_.collection[JSONCollection]("users"))

  def createUser(user: User): Future[WriteResult] = {
    collection.flatMap(_.insert.one(user))
  }

  def findAllUsers(): Future[List[User]] = {
    collection.map {
      _.find(Json.obj())
        .sort(Json.obj("created" -> -1))
        .cursor[User]()
    }.flatMap(
      _.collect[List](
        -1,
        Cursor.FailOnError[List[User]]()
      )
    )
  }

}