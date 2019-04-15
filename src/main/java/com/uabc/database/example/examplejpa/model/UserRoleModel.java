package com.uabc.database.example.examplejpa.model;

import com.uabc.database.example.examplejpa.entity.User;
import lombok.Data;

@Data
public class UserRoleModel {
    private int userRoleId;
    private String user;
    private String role;

    public UserRoleModel(){

    }

    /*public UserRoleModel(int userRoleId, User user, String role){
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }*/

    /*@Override
    public String toString() {
        return "UserRoleModel{" +
                "userRoleId=" + userRoleId +
                ", user='" + user + '\'' +
                ", role='" + role + '\'' +
                '}';
    }*/
}
