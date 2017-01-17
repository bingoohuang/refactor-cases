package com.github.bingoohuang.building_maintainable_software.ch06.userservice.splitted;

import com.github.bingoohuang.building_maintainable_software.ch06.userservice.NotificationType;
import com.github.bingoohuang.building_maintainable_software.ch06.userservice.User;

import java.util.ArrayList;
import java.util.List;


public class UserNotificationService {
    public List<NotificationType> getNotificationTypes(User user) {
        // ...
        return new ArrayList<NotificationType>();
    }

    public void register(User user, NotificationType type) {
        // ...  
    }

    public void unregister(User user, NotificationType type) {
        // ...  
    }
}