package com.uabc.database.example.examplejpa.components;


import com.uabc.database.example.examplejpa.entity.User;
import com.uabc.database.example.examplejpa.model.UserModel;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component("userConverter")
public class UserConverter {

    public User convertToUserModel2User(UserModel userModel){
        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());
        user.setEnabled(userModel.isEnabled());
        user.setUserRoles(userModel.getUserRoles());
        return user;
    }

    public UserModel convertUser2UserModel(User user){
        UserModel userModel = new UserModel();
        userModel.setUsername(user.getUsername());
        userModel.setPassword(user.getPassword());
        userModel.setEnabled(user.isEnabled());
        userModel.setUserRoles(user.getUserRoles());
        return userModel;
    }
}

