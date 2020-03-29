package controllers

import authentication.AuthenticationAction
import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents, val authAction: AuthenticationAction) extends AbstractController(cc) {

  def index: Action[AnyContent] = authAction {
    Ok("Hello world")
  }

  def indexWithView: Action[AnyContent] = Action {
    Ok(views.html.index("Hello world"))
  }

}
