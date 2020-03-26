package controllers

import org.scalatestplus.play._
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._
import scala.concurrent.Future

class HomeControllerTest extends PlaySpec with Results {

  "Example Page#index" should {
    "should be valid" in {
      val controller = new HomeController(Helpers.stubControllerComponents())
      val result: Future[Result] = controller.index().apply(FakeRequest())
      contentType(result) mustBe Some("text/plain")
      contentAsString(result) must be("Hello world")
    }
  }

  "Example Page#index with template" should {
    "should be valid" in {
      val controller = new HomeController(Helpers.stubControllerComponents())
      val result: Future[Result] = controller.indexWithView().apply(FakeRequest())
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include("Hello world")
    }
  }

}
