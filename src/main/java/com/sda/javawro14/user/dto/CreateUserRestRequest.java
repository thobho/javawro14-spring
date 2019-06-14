package com.sda.javawro14.user.dto;

public class CreateUserRestRequest {
    private String name;

    public CreateUserRestRequest(){}

    public CreateUserRestRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
