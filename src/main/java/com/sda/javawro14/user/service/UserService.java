package com.sda.javawro14.user.service;

import com.sda.javawro14.user.model.UserDTO;
import com.sda.javawro14.user.model.UserDocument;
import com.sda.javawro14.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

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

    public List<UserDTO> getAllUsers() {
        List<UserDocument> allUserDocuments = userRepository.findAll();
//        UserDocument userDocument = new UserDocument();
//        UserDTO map = modelMapper.map(userDocument, UserDTO.class);
        return allUserDocuments.stream()
                .map(userDocument -> modelMapper.map(userDocument, UserDTO.class))
                .collect(Collectors.toList());
    }

    public String saveUser(UserDTO userDTO) {
        UserDocument userToSave = modelMapper.map(userDTO, UserDocument.class);
        UserDocument insertedUser = userRepository.insert(userToSave);
        return insertedUser.getId();
    }

    public UserDTO getUserById(String id) {
        Optional<UserDocument> foundUserOption = userRepository.findById(id);

        if(foundUserOption.isPresent()){
            return modelMapper.map(foundUserOption.get(), UserDTO.class);
        }

        throw new IllegalArgumentException("User with id not found");
    }


    public List<UserDTO> findByQueryString(String queryString){
        return userRepository
                .findByNameLikeOrderByNameAsc(queryString)
                .stream()
                .map(userDocument -> modelMapper.map(userDocument, UserDTO.class))
                .collect(Collectors.toList());
    }

    public String saveUser(String userName) {
        return "";
    }

}
