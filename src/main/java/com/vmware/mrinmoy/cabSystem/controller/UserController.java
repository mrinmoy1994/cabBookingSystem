package com.vmware.mrinmoy.cabSystem.controller;

import com.vmware.mrinmoy.cabSystem.model.CabDetails;
import com.vmware.mrinmoy.cabSystem.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public interface UserController {
    public User createUser(@RequestBody User user);
    @GetMapping(path = "/{userId}")
    public User getUser(@RequestParam("userId") String id);
    @GetMapping(path = "/getDrivers")
    public List<User> getDrivers(@RequestBody User user);
    @GetMapping(path = "/bookCab")
    public CabDetails bookCab(@RequestParam("userId") String userId, @RequestParam("cabId") String cabId);
}
