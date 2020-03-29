package controllers

import Services.MongoService
import akka.actor.ActorRefFactory
import akka.stream.{ActorMaterializer, Materializer}
import models.User
import org.scalatestplus.play._
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}
import org.mockito.Mockito._
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import reactivemongo.api.commands.WriteResult
import reactivemongo.bson.BSONObjectID

class UserControllerTest extends PlaySpec with Results with MockitoSugar with GuiceOneAppPerSuite {

  implicit lazy val materializer: Materializer = app.materializer
  implicit val ec: ExecutionContextExecutor = ExecutionContext.global
//  implicit val materializer: ActorMaterializer = ActorMaterializer()
//  implicit val actorRefFactory: ActorRefFactory = ActorRefFactory()

  "Example Page#users" should {
    "should be valid" in {
      val mongoService = mock[MongoService]
      val controller = new UserController(Helpers.stubControllerComponents(), mongoService)
      val userList = Future {
        List[User](
          User(21, "Tom", "Johnes")
        )
      }
      when(mongoService.findAllUsers()).thenReturn(userList)
      val result: Future[Result] = controller.getAllUsers().apply(FakeRequest())
      contentType(result) mustBe Some("text/plain")
      userList.map{
        value => contentAsString(result) must be("Users: " + value.toString())
      }
    }
  }

  "Example Page#users" should {
    "should be valid for inserting a user" in {
      val mongoService = mock[MongoService]
      val mockedWriteResult = mock[WriteResult]
      val controller = new UserController(Helpers.stubControllerComponents(), mongoService)
      val result = controller.createUserFromJson().apply(FakeRequest())
      contentType(result) mustBe Some("text/plain")
//      userList.map{
//        value => contentAsString(result) must be("Users: " + value.toString())
//      }
    }
  }



}
