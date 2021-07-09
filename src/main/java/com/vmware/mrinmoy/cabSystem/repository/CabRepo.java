package com.vmware.mrinmoy.cabSystem.repository;

import com.vmware.mrinmoy.cabSystem.model.CabDetails;
import com.vmware.mrinmoy.cabSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CabRepo extends JpaRepository<CabDetails, String> {
    List<CabDetails> finallAllByDriverId(List<String> driverId);
}
