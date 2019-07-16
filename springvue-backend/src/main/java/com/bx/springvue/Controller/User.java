package com.bx.springvue.Controller;

import com.alibaba.fastjson.JSONArray;
import com.bx.springvue.Service.TokenService;
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

    @Autowired
    private TokenService tokenService;

    @GetMapping(value="")
    public JSONArray index(){
        return userService.findAll();
    }

    @PostMapping(value="/login")
    public String login(String name, String password){
        if(userService.getUserpswbyname(name).equals(password)){
            return tokenService.getToken(name, password);
        }else {
            return "Error";
        }
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
