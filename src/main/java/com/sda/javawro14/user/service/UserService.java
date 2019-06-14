package com.sda.javawro14.user.service;

import com.sda.javawro14.user.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.*;

@Service
@PropertySource("classpath:values.properties")
public class UserService {

    private List<User> users = new ArrayList<>();

    @Value("${userService.description}")
    private String serviceName;

    @PostConstruct
    void init() {
        users.add(new User("Janusz", new Date()));
        users.add(new User("Danuta", new Date()));
        users.add(new User("Mirek", new Date()));
    }

    public String saveUser(String name) {
        User user = new User(name, new Date());
        users.add(user);
        return user.getId();
    }

    public String saveUser(User user){

        if(!validateUser(user)){
            throw new IllegalArgumentException("Invalid user");
        }

        this.users.add(user);
        return user.getId();
    }

    public User getUserById(String id) {
        return users.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Use id not found!!!"));
    }

    private boolean validateUser(User user){
        String name = user.getName();
        if(name.length()<1 || name.length()>100){
            return false;
        }

        Date dateOfBirth = user.getDateOfBirth();
        Date minDateOfBrirth =
                new GregorianCalendar(1900, Calendar.JANUARY, 1).getTime();

        if(dateOfBirth.before(minDateOfBrirth)){
            return false;
        }

        return true;
    }

    public List<User> getAllUsers() {
        return users;
    }

}
