package com.vmware.mrinmoy.cabSystem.controller;

import com.vmware.mrinmoy.cabSystem.model.CabDetails;
import com.vmware.mrinmoy.cabSystem.model.User;
import com.vmware.mrinmoy.cabSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;
    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public User getUser(String id) {
        return userService.getUser(id);
    }

    @Override
    public List<User> getDrivers(User user) {
        return userService.getDrivers(user);
    }

    @Override
    public CabDetails bookCab(String userId, String cabId) {
        return userService.bookCab(userId, cabId);
    }
}
