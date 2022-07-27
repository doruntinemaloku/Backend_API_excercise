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
  
  }


}
