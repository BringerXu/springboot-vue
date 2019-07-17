package com.bx.springvue.Service;

import com.alibaba.fastjson.JSONArray;

public interface UserService {
    JSONArray findAll();
    boolean addUser(String name, String password);
    boolean deleteUserbyname(String name);
    String getUserpswbyname(String name);
    void updateToken(String name, String token);
}
