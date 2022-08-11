// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package io.backend.api.controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final io.backend.api.controllers.ReverseAuthenticateController AuthenticateController = new io.backend.api.controllers.ReverseAuthenticateController(RoutesPrefix.byNamePrefix());
  public static final io.backend.api.controllers.ReverseUser_Controller User_Controller = new io.backend.api.controllers.ReverseUser_Controller(RoutesPrefix.byNamePrefix());
  public static final io.backend.api.controllers.ReverseChatRoomController ChatRoomController = new io.backend.api.controllers.ReverseChatRoomController(RoutesPrefix.byNamePrefix());
  public static final io.backend.api.controllers.ReverseDashboard_Contoller Dashboard_Contoller = new io.backend.api.controllers.ReverseDashboard_Contoller(RoutesPrefix.byNamePrefix());
  public static final io.backend.api.controllers.ReverseContent_Controller Content_Controller = new io.backend.api.controllers.ReverseContent_Controller(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final io.backend.api.controllers.javascript.ReverseAuthenticateController AuthenticateController = new io.backend.api.controllers.javascript.ReverseAuthenticateController(RoutesPrefix.byNamePrefix());
    public static final io.backend.api.controllers.javascript.ReverseUser_Controller User_Controller = new io.backend.api.controllers.javascript.ReverseUser_Controller(RoutesPrefix.byNamePrefix());
    public static final io.backend.api.controllers.javascript.ReverseChatRoomController ChatRoomController = new io.backend.api.controllers.javascript.ReverseChatRoomController(RoutesPrefix.byNamePrefix());
    public static final io.backend.api.controllers.javascript.ReverseDashboard_Contoller Dashboard_Contoller = new io.backend.api.controllers.javascript.ReverseDashboard_Contoller(RoutesPrefix.byNamePrefix());
    public static final io.backend.api.controllers.javascript.ReverseContent_Controller Content_Controller = new io.backend.api.controllers.javascript.ReverseContent_Controller(RoutesPrefix.byNamePrefix());
  }

}
