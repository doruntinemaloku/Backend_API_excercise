// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  Assets_0: controllers.Assets,
  // @LINE:11
  BackendAPI_Controller_1: javax.inject.Provider[io.backend.api.controllers.BackendAPI_Controller],
  // @LINE:14
  Dashboard_Contoller_2: javax.inject.Provider[io.backend.api.controllers.Dashboard_Contoller],
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    Assets_0: controllers.Assets,
    // @LINE:11
    BackendAPI_Controller_1: javax.inject.Provider[io.backend.api.controllers.BackendAPI_Controller],
    // @LINE:14
    Dashboard_Contoller_2: javax.inject.Provider[io.backend.api.controllers.Dashboard_Contoller]
  ) = this(errorHandler, Assets_0, BackendAPI_Controller_1, Dashboard_Contoller_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_0, BackendAPI_Controller_1, Dashboard_Contoller_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/authenticate/""", """@io.backend.api.controllers.BackendAPI_Controller@.authenticate(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/verify/""", """@io.backend.api.controllers.BackendAPI_Controller@.verify(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/dashboard/""", """@io.backend.api.controllers.Dashboard_Contoller@.create(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/dashboard/""", """@io.backend.api.controllers.Dashboard_Contoller@.read(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/dashboard/""", """@io.backend.api.controllers.Dashboard_Contoller@.update(request:Request, id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/dashboard/""", """@io.backend.api.controllers.Dashboard_Contoller@.delete(request:Request, id:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_Assets_versioned0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned0_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val io_backend_api_controllers_BackendAPI_Controller_authenticate1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/authenticate/")))
  )
  private[this] lazy val io_backend_api_controllers_BackendAPI_Controller_authenticate1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      BackendAPI_Controller_1.get.authenticate(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.BackendAPI_Controller",
      "authenticate",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/authenticate/""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val io_backend_api_controllers_BackendAPI_Controller_verify2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/verify/")))
  )
  private[this] lazy val io_backend_api_controllers_BackendAPI_Controller_verify2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      BackendAPI_Controller_1.get.verify(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.BackendAPI_Controller",
      "verify",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/verify/""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val io_backend_api_controllers_Dashboard_Contoller_create3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/dashboard/")))
  )
  private[this] lazy val io_backend_api_controllers_Dashboard_Contoller_create3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      Dashboard_Contoller_2.get.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.Dashboard_Contoller",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/dashboard/""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val io_backend_api_controllers_Dashboard_Contoller_read4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/dashboard/")))
  )
  private[this] lazy val io_backend_api_controllers_Dashboard_Contoller_read4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      Dashboard_Contoller_2.get.read(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.Dashboard_Contoller",
      "read",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """api/dashboard/""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val io_backend_api_controllers_Dashboard_Contoller_update5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/dashboard/")))
  )
  private[this] lazy val io_backend_api_controllers_Dashboard_Contoller_update5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      Dashboard_Contoller_2.get.update(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.Dashboard_Contoller",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "PUT",
      this.prefix + """api/dashboard/""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val io_backend_api_controllers_Dashboard_Contoller_delete6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/dashboard/")))
  )
  private[this] lazy val io_backend_api_controllers_Dashboard_Contoller_delete6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      Dashboard_Contoller_2.get.delete(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.Dashboard_Contoller",
      "delete",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "DELETE",
      this.prefix + """api/dashboard/""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_Assets_versioned0_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(Assets_0.versioned(path, file))
      }
  
    // @LINE:11
    case io_backend_api_controllers_BackendAPI_Controller_authenticate1_route(params@_) =>
      call { 
        io_backend_api_controllers_BackendAPI_Controller_authenticate1_invoker.call(
          req => BackendAPI_Controller_1.get.authenticate(req))
      }
  
    // @LINE:12
    case io_backend_api_controllers_BackendAPI_Controller_verify2_route(params@_) =>
      call { 
        io_backend_api_controllers_BackendAPI_Controller_verify2_invoker.call(
          req => BackendAPI_Controller_1.get.verify(req))
      }
  
    // @LINE:14
    case io_backend_api_controllers_Dashboard_Contoller_create3_route(params@_) =>
      call { 
        io_backend_api_controllers_Dashboard_Contoller_create3_invoker.call(
          req => Dashboard_Contoller_2.get.create(req))
      }
  
    // @LINE:15
    case io_backend_api_controllers_Dashboard_Contoller_read4_route(params@_) =>
      call { 
        io_backend_api_controllers_Dashboard_Contoller_read4_invoker.call(
          req => Dashboard_Contoller_2.get.read(req))
      }
  
    // @LINE:16
    case io_backend_api_controllers_Dashboard_Contoller_update5_route(params@_) =>
      call(params.fromQuery[String]("id", None)) { (id) =>
        io_backend_api_controllers_Dashboard_Contoller_update5_invoker.call(
          req => Dashboard_Contoller_2.get.update(req, id))
      }
  
    // @LINE:17
    case io_backend_api_controllers_Dashboard_Contoller_delete6_route(params@_) =>
      call(params.fromQuery[String]("id", None)) { (id) =>
        io_backend_api_controllers_Dashboard_Contoller_delete6_invoker.call(
          req => Dashboard_Contoller_2.get.delete(req, id))
      }
  }
}
