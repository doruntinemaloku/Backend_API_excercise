// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package io.backend.api.controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final io.backend.api.controllers.ReverseBackendAPI_Controller BackendAPI_Controller = new io.backend.api.controllers.ReverseBackendAPI_Controller(RoutesPrefix.byNamePrefix());
  public static final io.backend.api.controllers.ReverseDashboard_Contoller Dashboard_Contoller = new io.backend.api.controllers.ReverseDashboard_Contoller(RoutesPrefix.byNamePrefix());
  public static final io.backend.api.controllers.ReverseContent_Controller Content_Controller = new io.backend.api.controllers.ReverseContent_Controller(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final io.backend.api.controllers.javascript.ReverseBackendAPI_Controller BackendAPI_Controller = new io.backend.api.controllers.javascript.ReverseBackendAPI_Controller(RoutesPrefix.byNamePrefix());
    public static final io.backend.api.controllers.javascript.ReverseDashboard_Contoller Dashboard_Contoller = new io.backend.api.controllers.javascript.ReverseDashboard_Contoller(RoutesPrefix.byNamePrefix());
    public static final io.backend.api.controllers.javascript.ReverseContent_Controller Content_Controller = new io.backend.api.controllers.javascript.ReverseContent_Controller(RoutesPrefix.byNamePrefix());
  }

}
