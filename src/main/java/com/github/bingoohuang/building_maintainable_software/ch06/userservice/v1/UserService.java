package com.github.bingoohuang.building_maintainable_software.ch06.userservice.v1;


import com.github.bingoohuang.building_maintainable_software.ch06.userservice.User;
import com.github.bingoohuang.building_maintainable_software.ch06.userservice.UserInfo;

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
}
