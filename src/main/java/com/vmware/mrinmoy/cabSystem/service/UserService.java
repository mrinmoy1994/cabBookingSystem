package com.vmware.mrinmoy.cabSystem.service;

import com.vmware.mrinmoy.cabSystem.model.CabDetails;
import com.vmware.mrinmoy.cabSystem.model.User;
import com.vmware.mrinmoy.cabSystem.model.UserType;
import com.vmware.mrinmoy.cabSystem.repository.CabRepo;
import com.vmware.mrinmoy.cabSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CabRepo cabRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User getUser(String id) {
        return userRepo.getOne(id);
    }

    public List<User> getDrivers(User user) {
        List<User> userList = userRepo.findAll().stream().filter(user1 -> (user1.getType().compareTo(UserType.DRIVER) == 0))
                .collect(Collectors.toList());
        List<Double> disList = new ArrayList<>();
        userList.forEach(user1 -> {
            String[] loc = user1.getLocation().split(",");
            String[] loc1 = user.getLocation().split(",");
            double dis = Math.sqrt(Math.pow(((Integer.parseInt(loc[0])) - Integer.parseInt(loc1[0])) ,2)
                    + Math.pow ((Integer.parseInt(loc[0]) - Integer.parseInt(loc1[0])),2));
            disList.add(dis);
        });

        Collections.sort(disList);
        List<User> resultList = userList.stream().filter(user1 -> {
            String[] loc = user1.getLocation().split(",");
            String[] loc1 = user.getLocation().split(",");
            double dis = Math.sqrt(Math.pow(((Integer.parseInt(loc[0])) - Integer.parseInt(loc1[0])) ,2)
                    + Math.pow ((Integer.parseInt(loc[0]) - Integer.parseInt(loc1[0])),2));
            return (dis == disList.get(0));
        }).collect(Collectors.toList());

        return resultList;
    }

    public CabDetails bookCab(String userId, String cabId) throws Exception {
        CabDetails cabDetails = userRepo.findById(cabId).get().getCabDetails();
        if(!cabDetails.isFree())
            throw new Exception("Cab busy");
        cabDetails.setFree(false);
        cabDetails.setCustomerId(userId);
        return cabDetails;
    }
}
