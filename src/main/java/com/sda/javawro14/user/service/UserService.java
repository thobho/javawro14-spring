package com.sda.javawro14.user.service;

import com.sda.javawro14.user.model.User;
import com.sda.javawro14.user.model.UserEntity;
import com.sda.javawro14.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:values.properties")
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Value("${userService.description}")
    private String serviceName;

    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }

    public String saveUser(String name) {

        UserEntity savedUser = userRepository.save(new UserEntity(name, "dummyPassword", new Date()));

        return savedUser.getId();
    }

    public String saveUser(User user){

        if(!validateUser(user)){
            throw new IllegalArgumentException("Invalid user");
        }

        UserEntity userEntity = modelMapper.map(user, UserEntity.class);

        return userRepository.save(userEntity).getId();
    }

    public User getUserById(String id) {
        UserEntity foundUser = userRepository.getById(id);
        User userToReturn = modelMapper.map(foundUser, User.class);
        return userToReturn;
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
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
                .map(userEntity -> modelMapper.map(userEntity, User.class))
                .collect(Collectors.toList());
    }

}
