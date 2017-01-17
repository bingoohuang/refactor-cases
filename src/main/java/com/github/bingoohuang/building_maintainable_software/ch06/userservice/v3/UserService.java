package com.github.bingoohuang.building_maintainable_software.ch06.userservice.v3;

import com.github.bingoohuang.building_maintainable_software.ch06.userservice.NotificationType;
import com.github.bingoohuang.building_maintainable_software.ch06.userservice.User;
import com.github.bingoohuang.building_maintainable_software.ch06.userservice.UserInfo;

import java.util.ArrayList;
import java.util.List;


public class UserService {
    public User loadUser(String userId) {
        // ...
        return new User();
    }

    public boolean doesUserExist(String userId) {
        // ...
        return true;
    }

    public User changeUserInfo(UserInfo userInfo) {
        // ...
        return new User();
    }

    public List<NotificationType> getNotificationTypes(User user) {
        // ...
        return new ArrayList<NotificationType>();
    }

    public void registerForNotifications(User user, NotificationType type) {
        // ...
    }

    public void unregisterForNotifications(User user, NotificationType type) {
        // ...
    }

    public List<User> searchUsers(UserInfo userInfo) {
        // ...
        return new ArrayList<User>();
    }

    public void blockUser(User user) {
        // ... 
    }

    public List<User> getAllBlockedUsers() {
        // ...
        return new ArrayList<User>();
    }
}