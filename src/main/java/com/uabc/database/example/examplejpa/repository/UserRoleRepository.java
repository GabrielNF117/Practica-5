package com.uabc.database.example.examplejpa.repository;

import com.uabc.database.example.examplejpa.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userRoleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Serializable> {
    public abstract UserRole findByUserRoleId(int id);
}