// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:10
package io.backend.api.controllers {

  // @LINE:19
  class ReverseUser_Controller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/user/")
    }
  
    // @LINE:20
    def read(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/user/")
    }
  
    // @LINE:21
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:22
    def delete(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:29
  class ReverseChatRoomController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def chat(roomId:String, token:String = ""): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/chat/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("roomId", roomId)) + play.core.routing.queryString(List(if(token == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("token", token)))))
    }
  
  }

  // @LINE:13
  class ReverseDashboard_Contoller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/dashboard/")
    }
  
    // @LINE:14
    def read(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/dashboard/")
    }
  
    // @LINE:15
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:16
    def delete(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:10
  class ReverseBackendAPI_Controller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def authenticate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/authenticate/")
    }
  
    // @LINE:11
    def verify(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/verify/")
    }
  
  }

  // @LINE:24
  class ReverseContent_Controller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def create(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/")
    }
  
    // @LINE:25
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/")
    }
  
    // @LINE:26
    def update(id:String, contentId:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("contentId", contentId)))
    }
  
    // @LINE:27
    def delete(id:String, contentId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("contentId", contentId)))
    }
  
  }


}
