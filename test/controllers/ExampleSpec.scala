package controllers

import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import org.scalatestplus.play.{HtmlUnitFactory, OneBrowserPerSuite, PlaySpec}
import play.api.Application
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.mvc.DefaultActionBuilder

class ExampleSpec extends PlaySpec with GuiceOneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {

//  // Override app if you need an Application with other than
//  // default parameters.
//  override def fakeApplication(): Application = {
//    import play.api.http.MimeTypes._
//    import play.api.mvc.Results._
//
//    GuiceApplicationBuilder()
//      .appRoutes(app => {
//        case ("GET", "/indexWithView") =>
//          app.injector.instanceOf(classOf[DefaultActionBuilder]) {
//            Ok("""
//                 |<html>
//                 | <head>
//                 |   <title>Test Page</title>
//                 |   <body>
//                 |     <input type='button' name='b' value='Click Me' onclick='document.title="scalatest"' />
//                 |   </body>
//                 | </head>
//                 |</html>
//            """.stripMargin).as(HTML)
//          }
//      })
//      .build()
//  }
//
//  "The OneBrowserPerTest trait" must {
//    "provide a web driver" in {
//      go to s"http://localhost:$port/indexWithView"
//      pageTitle mustBe "Welcome to Play"
//      //click.on(find(name("b")).value)
//      //eventually { pageTitle mustBe "scala" }
//    }
//  }
}
