package com.bx.springvue.Controller;

import com.alibaba.fastjson.JSONArray;
import com.bx.springvue.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@ResponseBody
//@Controller == @RestController
@CrossOrigin
@RestController
public class User {
    @Autowired
    private UserService userService;

    @GetMapping(value="")
    public JSONArray index(){
        return userService.findAll();
    }

    @PostMapping(value="/login")
    public boolean login(String name, String password){
        return userService.getUserpswbyname(name).equals(password);
    }

    @PostMapping(value="/add")
    public boolean addUser(String name, String password){
        return userService.addUser(name, password);
    }

    @PostMapping(value="/remove")
    public boolean removeUser(String name){
        return userService.deleteUserbyname(name);
    }

}
