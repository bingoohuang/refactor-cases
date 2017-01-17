package com.github.bingoohuang.building_maintainable_software.ch06.userservice.v2;

import com.github.bingoohuang.building_maintainable_software.ch06.userservice.NotificationType;
import com.github.bingoohuang.building_maintainable_software.ch06.userservice.User;
import org.apache.http.HttpStatus;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/notification")
public class NotificationRestAPI {
    private final UserService userService = new UserService();

    // ...
    public Response toJson(@SuppressWarnings("unused") int status) {
        return Response.accepted().build();
    }

    @POST
    @Path("/register/{userId}/{type}")
    public Response register(@PathParam(value = "userId") String userId,
                             @PathParam(value = "type")
                                     String notificationType) {
        User user = userService.loadUser(userId);
        userService.registerForNotifications(user, NotificationType.fromString(notificationType));
        return toJson(HttpStatus.SC_OK);
    }

    @POST
    @Path("/unregister/{userId}/{type}")
    public Response unregister(@PathParam(value = "userId") String userId,
                               @PathParam(value = "type")
                                       String notificationType) {
        User user = userService.loadUser(userId);
        userService.unregisterForNotifications(user, NotificationType.fromString(notificationType));
        return toJson(HttpStatus.SC_OK);
    }
}