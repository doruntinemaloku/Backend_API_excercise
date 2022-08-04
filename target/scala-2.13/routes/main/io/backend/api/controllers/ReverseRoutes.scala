// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:11
package io.backend.api.controllers {

  // @LINE:11
  class ReverseBackendAPI_Controller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def authenticate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/authenticate/")
    }
  
    // @LINE:12
    def verify(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/verify/")
    }
  
  }

  // @LINE:14
  class ReverseDashboard_Contoller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/dashboard/")
    }
  
    // @LINE:15
    def read(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/dashboard/")
    }
  
    // @LINE:16
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:17
    def delete(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:20
  class ReverseUser_Controller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/user/")
    }
  
    // @LINE:21
    def read(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/user/")
    }
  
    // @LINE:22
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:23
    def delete(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:25
  class ReverseContent_Controller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def create(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/")
    }
  
    // @LINE:26
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/")
    }
  
    // @LINE:27
    def update(id:String, contentId:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("contentId", contentId)))
    }
  
    // @LINE:28
    def delete(id:String, contentId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/content/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("contentId", contentId)))
    }
  
  }


}
