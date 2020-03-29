package authentication

import com.google.inject.Inject
import models.LoginDetails
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class AuthenticatedRequest[A](val username: String, request: Request[A]) extends WrappedRequest[A](request)

class AuthenticationAction @Inject()(val parser: BodyParsers.Default)(implicit val executionContext: ExecutionContext)
  extends ActionBuilder[AuthenticatedRequest, AnyContent] {

  override def invokeBlock[A](request: Request[A], block: AuthenticatedRequest[A] => Future[Result]): Future[Result] = {
    request.cookies.get("username")
      .flatMap(username => LoginDetails.getUsername(username.value))
      .map(user => block(new AuthenticatedRequest(user.username, request)))
      .getOrElse(Future.successful(Results.Redirect("/login")))
  }

}
