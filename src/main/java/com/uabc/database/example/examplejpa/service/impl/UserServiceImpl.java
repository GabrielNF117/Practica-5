package com.uabc.database.example.examplejpa.service.impl;

import com.uabc.database.example.examplejpa.components.UserConverter;
import com.uabc.database.example.examplejpa.entity.User;
import com.uabc.database.example.examplejpa.model.UserModel;
import com.uabc.database.example.examplejpa.repository.UserRepository;
import com.uabc.database.example.examplejpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userConverter")
    private UserConverter userConverter;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserModel addUser(UserModel userModel) {
        //Aquí nos pide una entidad, por lo tanto tenemos que transformar el userModel a entidad
        userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        User temp=userConverter.convertToUserModel2User(userModel);
        User user = userRepository.save(temp);
        return userConverter.convertUser2UserModel(user);
    }

    @Override
    public List<UserModel> listAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserModel> usersModel = new ArrayList<>();
        for(User user : users){
            usersModel.add(userConverter.convertUser2UserModel(user));

        }
        return usersModel;
    }

    @Override
    public User findUserByUser(String username) {
        return userRepository.findByUsername(username);
    }

    public UserModel findUserByIdModel(String username){
        return userConverter.convertUser2UserModel(findUserByUser(username));
    }

    @Override
    public void removeUser(String username) {
        User user  = findUserByUser(username);
        if(user != null){
            userRepository.delete(findUserByUser(username));
        }
    }
}
