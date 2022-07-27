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
  
  }


}
