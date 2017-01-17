package com.github.bingoohuang.building_maintainable_software.ch06.userservice.splitted;

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

    public List<User> searchUsers(UserInfo userInfo) {
        // ... 
        return new ArrayList<User>();
    }
}