package controllers

import Services.MongoService
import javax.inject.Inject
import models.User
import play.api.libs.json.JsValue
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import helpers.JsonFormats._
import javax.inject._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}

@Singleton
class UserController  @Inject()(cc: ControllerComponents, val mongoService: MongoService) extends AbstractController(cc) {

  implicit val ec: ExecutionContextExecutor = ExecutionContext.global

  def createUserFromJson(): Action[JsValue] = Action.async(parse.json) { request =>
    request.body.validate[User].map { user =>
      mongoService.createUser(user).map {
        _ => Ok("User inserted")
      }
    }.getOrElse(Future.successful(BadRequest("invalid json")))
  }

  def getAllUsers(): Action[AnyContent] = Action.async {
    mongoService.findAllUsers().map {
      userList => Ok("Users: " + userList.toString())
    }
  }

}
