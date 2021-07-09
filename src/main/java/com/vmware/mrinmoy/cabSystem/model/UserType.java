package com.vmware.mrinmoy.cabSystem.model;

import ch.qos.logback.classic.util.LogbackMDCAdapter;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
    DRIVER("DRIVER"),
    CUSTOMER("CUSTOMER");

    private static final Map<String, UserType> map = new HashMap<>();

    private String value;

    UserType(String value){
        this.value = value;
    }
}
