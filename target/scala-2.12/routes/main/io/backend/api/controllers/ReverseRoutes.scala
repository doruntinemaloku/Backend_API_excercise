// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:10
package io.backend.api.controllers {

  // @LINE:10
  class ReverseAuthenticateController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def authenticate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/authenticate/")
    }
  
  }

  // @LINE:18
  class ReverseUser_Controller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/user/")
    }
  
    // @LINE:19
    def read(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/user/")
    }
  
    // @LINE:20
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:21
    def delete(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:28
  class ReverseChatRoomController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def chat(roomId:String, token:String = ""): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/chat/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("roomId", roomId)) + play.core.routing.queryString(List(if(token == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("token", token)))))
    }
  
  }

  // @LINE:12
  class ReverseDashboard_Contoller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def read(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/dashboard/")
    }
  
    // @LINE:15
    def delete(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:16
    def hierarchy(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/dashboard/hierarchy")
    }
  
    // @LINE:14
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:12
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/dashboard/")
    }
  
  }

  // @LINE:23
  class ReverseContent_Controller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def create(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/")
    }
  
    // @LINE:24
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/")
    }
  
    // @LINE:25
    def update(id:String, contentId:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("contentId", contentId)))
    }
  
    // @LINE:26
    def delete(id:String, contentId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("contentId", contentId)))
    }
  
  }


}
