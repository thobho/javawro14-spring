package com.sda.javawro14.user.service;

import com.sda.javawro14.user.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    void init() {
        users.add(new User("Janusz", new Date()));
        users.add(new User("Danuta", new Date()));
        users.add(new User("Mirek", new Date()));
    }

    public long saveUser(String name) {
        User user = new User(name, new Date());
        users.add(user);
        return user.getId();
    }

    public User getUserById(long id) {
        return users.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Use id not found!!!"));
    }

    public List<User> getAllUsers() {
        return users;
    }

}
