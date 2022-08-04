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
  Assets_4: controllers.Assets,
  // @LINE:11
  BackendAPI_Controller_0: javax.inject.Provider[io.backend.api.controllers.BackendAPI_Controller],
  // @LINE:14
  Dashboard_Contoller_2: javax.inject.Provider[io.backend.api.controllers.Dashboard_Contoller],
  // @LINE:20
  User_Controller_1: javax.inject.Provider[io.backend.api.controllers.User_Controller],
  // @LINE:25
  Content_Controller_3: javax.inject.Provider[io.backend.api.controllers.Content_Controller],
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    Assets_4: controllers.Assets,
    // @LINE:11
    BackendAPI_Controller_0: javax.inject.Provider[io.backend.api.controllers.BackendAPI_Controller],
    // @LINE:14
    Dashboard_Contoller_2: javax.inject.Provider[io.backend.api.controllers.Dashboard_Contoller],
    // @LINE:20
    User_Controller_1: javax.inject.Provider[io.backend.api.controllers.User_Controller],
    // @LINE:25
    Content_Controller_3: javax.inject.Provider[io.backend.api.controllers.Content_Controller]
  ) = this(errorHandler, Assets_4, BackendAPI_Controller_0, Dashboard_Contoller_2, User_Controller_1, Content_Controller_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_4, BackendAPI_Controller_0, Dashboard_Contoller_2, User_Controller_1, Content_Controller_3, prefix)
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
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/dashboard/""" + "$" + """id<[^/]+>""", """@io.backend.api.controllers.Dashboard_Contoller@.update(request:Request, id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/dashboard/""" + "$" + """id<[^/]+>""", """@io.backend.api.controllers.Dashboard_Contoller@.delete(request:Request, id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/""", """@io.backend.api.controllers.User_Controller@.create(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/""", """@io.backend.api.controllers.User_Controller@.read(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/""" + "$" + """id<[^/]+>""", """@io.backend.api.controllers.User_Controller@.update(request:Request, id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/""" + "$" + """id<[^/]+>""", """@io.backend.api.controllers.User_Controller@.delete(request:Request, id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/dashboard/""" + "$" + """id<[^/]+>/content/""", """@io.backend.api.controllers.Content_Controller@.create(request:Request, id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/dashboard/""" + "$" + """id<[^/]+>/content/""", """@io.backend.api.controllers.Content_Controller@.read(request:Request, id:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/dashboard/""" + "$" + """id<[^/]+>/content/""" + "$" + """contentId<[^/]+>""", """@io.backend.api.controllers.Content_Controller@.update(request:Request, id:String, contentId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/dashboard/""" + "$" + """id<[^/]+>/content/""" + "$" + """contentId<[^/]+>""", """@io.backend.api.controllers.Content_Controller@.delete(request:Request, id:String, contentId:String)"""),
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
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
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
      BackendAPI_Controller_0.get.authenticate(fakeValue[play.mvc.Http.Request]),
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
      BackendAPI_Controller_0.get.verify(fakeValue[play.mvc.Http.Request]),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/dashboard/"), DynamicPart("id", """[^/]+""",true)))
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
      this.prefix + """api/dashboard/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val io_backend_api_controllers_Dashboard_Contoller_delete6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/dashboard/"), DynamicPart("id", """[^/]+""",true)))
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
      this.prefix + """api/dashboard/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val io_backend_api_controllers_User_Controller_create7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/")))
  )
  private[this] lazy val io_backend_api_controllers_User_Controller_create7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      User_Controller_1.get.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.User_Controller",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/user/""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val io_backend_api_controllers_User_Controller_read8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/")))
  )
  private[this] lazy val io_backend_api_controllers_User_Controller_read8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      User_Controller_1.get.read(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.User_Controller",
      "read",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """api/user/""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val io_backend_api_controllers_User_Controller_update9_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val io_backend_api_controllers_User_Controller_update9_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      User_Controller_1.get.update(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.User_Controller",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "PUT",
      this.prefix + """api/user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val io_backend_api_controllers_User_Controller_delete10_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val io_backend_api_controllers_User_Controller_delete10_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      User_Controller_1.get.delete(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.User_Controller",
      "delete",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "DELETE",
      this.prefix + """api/user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val io_backend_api_controllers_Content_Controller_create11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/dashboard/"), DynamicPart("id", """[^/]+""",true), StaticPart("/content/")))
  )
  private[this] lazy val io_backend_api_controllers_Content_Controller_create11_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      Content_Controller_3.get.create(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.Content_Controller",
      "create",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "POST",
      this.prefix + """api/dashboard/""" + "$" + """id<[^/]+>/content/""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val io_backend_api_controllers_Content_Controller_read12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/dashboard/"), DynamicPart("id", """[^/]+""",true), StaticPart("/content/")))
  )
  private[this] lazy val io_backend_api_controllers_Content_Controller_read12_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      Content_Controller_3.get.read(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.Content_Controller",
      "read",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """api/dashboard/""" + "$" + """id<[^/]+>/content/""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val io_backend_api_controllers_Content_Controller_update13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/dashboard/"), DynamicPart("id", """[^/]+""",true), StaticPart("/content/"), DynamicPart("contentId", """[^/]+""",true)))
  )
  private[this] lazy val io_backend_api_controllers_Content_Controller_update13_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      Content_Controller_3.get.update(fakeValue[play.mvc.Http.Request], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.Content_Controller",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[String], classOf[String]),
      "PUT",
      this.prefix + """api/dashboard/""" + "$" + """id<[^/]+>/content/""" + "$" + """contentId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val io_backend_api_controllers_Content_Controller_delete14_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/dashboard/"), DynamicPart("id", """[^/]+""",true), StaticPart("/content/"), DynamicPart("contentId", """[^/]+""",true)))
  )
  private[this] lazy val io_backend_api_controllers_Content_Controller_delete14_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      Content_Controller_3.get.delete(fakeValue[play.mvc.Http.Request], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "io.backend.api.controllers.Content_Controller",
      "delete",
      Seq(classOf[play.mvc.Http.Request], classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """api/dashboard/""" + "$" + """id<[^/]+>/content/""" + "$" + """contentId<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_Assets_versioned0_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:11
    case io_backend_api_controllers_BackendAPI_Controller_authenticate1_route(params@_) =>
      call { 
        io_backend_api_controllers_BackendAPI_Controller_authenticate1_invoker.call(
          req => BackendAPI_Controller_0.get.authenticate(req))
      }
  
    // @LINE:12
    case io_backend_api_controllers_BackendAPI_Controller_verify2_route(params@_) =>
      call { 
        io_backend_api_controllers_BackendAPI_Controller_verify2_invoker.call(
          req => BackendAPI_Controller_0.get.verify(req))
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
      call(params.fromPath[String]("id", None)) { (id) =>
        io_backend_api_controllers_Dashboard_Contoller_update5_invoker.call(
          req => Dashboard_Contoller_2.get.update(req, id))
      }
  
    // @LINE:17
    case io_backend_api_controllers_Dashboard_Contoller_delete6_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        io_backend_api_controllers_Dashboard_Contoller_delete6_invoker.call(
          req => Dashboard_Contoller_2.get.delete(req, id))
      }
  
    // @LINE:20
    case io_backend_api_controllers_User_Controller_create7_route(params@_) =>
      call { 
        io_backend_api_controllers_User_Controller_create7_invoker.call(
          req => User_Controller_1.get.create(req))
      }
  
    // @LINE:21
    case io_backend_api_controllers_User_Controller_read8_route(params@_) =>
      call { 
        io_backend_api_controllers_User_Controller_read8_invoker.call(
          req => User_Controller_1.get.read(req))
      }
  
    // @LINE:22
    case io_backend_api_controllers_User_Controller_update9_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        io_backend_api_controllers_User_Controller_update9_invoker.call(
          req => User_Controller_1.get.update(req, id))
      }
  
    // @LINE:23
    case io_backend_api_controllers_User_Controller_delete10_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        io_backend_api_controllers_User_Controller_delete10_invoker.call(
          req => User_Controller_1.get.delete(req, id))
      }
  
    // @LINE:25
    case io_backend_api_controllers_Content_Controller_create11_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        io_backend_api_controllers_Content_Controller_create11_invoker.call(
          req => Content_Controller_3.get.create(req, id))
      }
  
    // @LINE:26
    case io_backend_api_controllers_Content_Controller_read12_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        io_backend_api_controllers_Content_Controller_read12_invoker.call(
          req => Content_Controller_3.get.read(req, id))
      }
  
    // @LINE:27
    case io_backend_api_controllers_Content_Controller_update13_route(params@_) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("contentId", None)) { (id, contentId) =>
        io_backend_api_controllers_Content_Controller_update13_invoker.call(
          req => Content_Controller_3.get.update(req, id, contentId))
      }
  
    // @LINE:28
    case io_backend_api_controllers_Content_Controller_delete14_route(params@_) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("contentId", None)) { (id, contentId) =>
        io_backend_api_controllers_Content_Controller_delete14_invoker.call(
          req => Content_Controller_3.get.delete(req, id, contentId))
      }
  }
}
