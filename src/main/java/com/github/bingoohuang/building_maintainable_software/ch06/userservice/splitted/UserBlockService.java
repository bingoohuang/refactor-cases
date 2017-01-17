package com.github.bingoohuang.building_maintainable_software.ch06.userservice.splitted;

import com.github.bingoohuang.building_maintainable_software.ch06.userservice.User;

import java.util.ArrayList;
import java.util.List;


public class UserBlockService {
    public void blockUser(User user) {
        // ... 
    }

    public List<User> getAllBlockedUsers() {
        // ...
        return new ArrayList<User>();
    }
}