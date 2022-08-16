// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:10
package io.backend.api.controllers.javascript {

  // @LINE:10
  class ReverseAuthenticateController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def authenticate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.AuthenticateController.authenticate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/authenticate/"})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseUser_Controller(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.User_Controller.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/"})
        }
      """
    )
  
    // @LINE:19
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.User_Controller.read",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/"})
        }
      """
    )
  
    // @LINE:20
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.User_Controller.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:21
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.User_Controller.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:28
  class ReverseChatRoomController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def chat: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.ChatRoomController.chat",
      """
        function(roomId0,token1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/chat/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("roomId", roomId0)) + _qS([(token1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("token", token1))])})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseDashboard_Contoller(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Dashboard_Contoller.read",
      """
        function(skip0,limit1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + _qS([(skip0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("skip", skip0)), (limit1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("limit", limit1))])})
        }
      """
    )
  
    // @LINE:15
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Dashboard_Contoller.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:16
    def hierarchy: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Dashboard_Contoller.hierarchy",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/hierarchy"})
        }
      """
    )
  
    // @LINE:14
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Dashboard_Contoller.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:12
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Dashboard_Contoller.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/"})
        }
      """
    )
  
  }

  // @LINE:23
  class ReverseContent_Controller(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Content_Controller.create",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/content/"})
        }
      """
    )
  
    // @LINE:24
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Content_Controller.read",
      """
        function(skip0,limit1,id2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id2)) + "/content/" + _qS([(skip0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("skip", skip0)), (limit1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("limit", limit1))])})
        }
      """
    )
  
    // @LINE:25
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "io.backend.api.controllers.Content_Controller.update",
      """
        function(id0,contentId1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/dashboard/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/content/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("contentId", contentId1))})
        }
      """
    )
  
    // @LINE:26
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
