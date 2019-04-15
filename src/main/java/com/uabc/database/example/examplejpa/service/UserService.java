package com.uabc.database.example.examplejpa.service;

import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.entity.User;
import com.uabc.database.example.examplejpa.model.LogModel;
import com.uabc.database.example.examplejpa.model.UserModel;

import java.util.List;

public interface UserService {
    public abstract UserModel addUser(UserModel userModel);

    public abstract List<UserModel> listAllUsers();

    public abstract User findUserByUser(String username);

    public abstract void removeUser(String username);

    public abstract UserModel findUserByIdModel(String username);
}
