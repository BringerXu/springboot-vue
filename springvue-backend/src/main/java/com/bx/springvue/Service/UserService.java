package com.bx.springvue.Service;

import com.bx.springvue.Entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();
    boolean addUser(String name, String password);
    void deleteUserbyname(String name);
    String getUserpswbyname(String name);
}
