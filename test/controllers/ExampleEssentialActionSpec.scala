package controllers

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import akka.stream.Materializer
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.mvc.DefaultActionBuilder
import play.api.test.FakeRequest
import play.mvc.BodyParser.Json
import play.mvc.EssentialAction

class ExampleEssentialActionSpec extends PlaySpec with GuiceOneAppPerSuite {

  implicit lazy val materializer: Materializer = app.materializer
  implicit lazy val Action                     = app.injector.instanceOf(classOf[DefaultActionBuilder])

//  "An essential action" should {
//    "can parse a JSON body" in {
//      val action: EssentialAction = Action { request =>
//        val value = (request.body.asJson.get \ "field").as[String]
//        Ok(value)
//      }
//
//      val request = FakeRequest("POST", "/").withJsonBody(Json.parse("""{ "field": "value" }"""))
//
//      val result = call(action, request)
//
//      status(result) mustEqual OK
//      contentAsString(result) mustEqual "value"
//    }
//  }
}
