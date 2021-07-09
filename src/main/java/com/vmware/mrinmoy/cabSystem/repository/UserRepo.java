package com.vmware.mrinmoy.cabSystem.repository;

import com.vmware.mrinmoy.cabSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
