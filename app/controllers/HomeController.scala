package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index: Action[AnyContent] = Action {
    Ok("Hello world")
  }

  def indexWithView: Action[AnyContent] = Action {
    Ok(views.html.index("Hello world"))
  }

}
