package controllers

import Services.MongoService
import authentication.AuthenticationAction
import models.LoginDetails
import org.scalatest.{Matchers, WordSpec}
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import play.api.libs.json.Json
import play.api.libs.ws.WSClient
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
      val result: Future[Result] = homeController.index().apply(FakeRequest().withCookies(Cookie("username", "password")))
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


class ExampleIntegrationTest extends WordSpec with Matchers with GuiceOneServerPerSuite  {

  def externalServices: Seq[String] = Seq("a-microservice")

  "This integration test" should {
    "start a-microservice via smserver" in {

      val wsClient = app.injector.instanceOf[WSClient]
      val response = wsClient.url(resource("/example/hello-world")).get.futureValue
      response.status shouldBe 200

    }
  }
}