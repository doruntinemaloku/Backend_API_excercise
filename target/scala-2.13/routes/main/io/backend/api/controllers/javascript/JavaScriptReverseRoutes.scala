// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:11
package io.backend.api.controllers.javascript {

  // @LINE:11
  class ReverseBackendAPI_Controller(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def authenticate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.BackendAPI_Controller.authenticate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/authenticate/"})
        }
      """
    )
  
    // @LINE:12
    def verify: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.BackendAPI_Controller.verify",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/verify/"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseDashboard_Contoller(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Dashboard_Contoller.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/"})
        }
      """
    )
  
    // @LINE:15
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Dashboard_Contoller.read",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/"})
        }
      """
    )
  
    // @LINE:16
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Dashboard_Contoller.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:17
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Dashboard_Contoller.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseContent_Controller(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Content_Controller.create",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/content/"})
        }
      """
    )
  
    // @LINE:21
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Content_Controller.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/content/"})
        }
      """
    )
  
    // @LINE:22
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Content_Controller.update",
      """
        function(id0,contentId1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/content/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("contentId", contentId1))})
        }
      """
    )
  
    // @LINE:23
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Content_Controller.delete",
      """
        function(id0,contentId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/content/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("contentId", contentId1))})
        }
      """
    )
  
  }


}
