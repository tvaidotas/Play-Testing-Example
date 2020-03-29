package controllers

import Services.MongoService
import authentication.AuthenticationAction
import models.LoginDetails
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}

class HomeControllerTest extends PlaySpec with Results with MockitoSugar {

  implicit val ec: ExecutionContextExecutor = ExecutionContext.global

  "Example Page#index" should {
    "should be valid" in {
      val authAction = mock[AuthenticationAction]
      val homeController = new HomeController(Helpers.stubControllerComponents(), authAction)


      val result: Future[Result] = homeController.index().apply(FakeRequest().withHeaders("username" -> "password"))
      contentType(result) mustBe Some("text/plain")
      contentAsString(result) must be("Hello world")
    }
  }

  "Example Page#index with template" should {
    "should be valid" in {
      val authAction = mock[AuthenticationAction]
      val controller = new HomeController(Helpers.stubControllerComponents(), authAction)
      val result: Future[Result] = controller.indexWithView().apply(FakeRequest())
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include("Hello world")
    }
  }

}
