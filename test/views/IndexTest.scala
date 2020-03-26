package views

import org.scalatestplus.play._
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.Future

class IndexTest extends PlaySpec with Results {

  "render index template" in new App {
    val html = views.html.index("Hello world")
    contentAsString(html) must include ("Hello world")
  }

}
