package com.bx.springvue.Service;

import com.alibaba.fastjson.JSONArray;

public interface UserService {
    boolean addUser(String name, String password);
    boolean deleteUserbyname(String name);
    String getUserpswbyname(String name);
    JSONArray findpart(int pn, int ps);
    Integer getTotal();
}
