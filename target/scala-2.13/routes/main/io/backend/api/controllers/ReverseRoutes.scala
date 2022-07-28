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
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("id", id)))))
    }
  
    // @LINE:17
    def delete(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/dashboard/" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("id", id)))))
    }
  
  }


}
