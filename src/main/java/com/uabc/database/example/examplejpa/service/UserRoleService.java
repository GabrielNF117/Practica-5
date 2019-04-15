package com.uabc.database.example.examplejpa.service;


import com.uabc.database.example.examplejpa.entity.User;
import com.uabc.database.example.examplejpa.entity.UserRole;
import com.uabc.database.example.examplejpa.model.UserModel;
import com.uabc.database.example.examplejpa.model.UserRoleModel;

import java.util.List;

public interface UserRoleService {

    public abstract UserRoleModel addUserRole(UserRoleModel userRoleModel);

    public abstract List<UserRoleModel> listAllUserRoles();

    public abstract UserRole findUserRoleById(int id);

    public abstract void removeUserRole(int id);

    public abstract UserRoleModel findUserRoleByIdModel(int id);

}
