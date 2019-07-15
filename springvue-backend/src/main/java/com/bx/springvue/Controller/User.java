package com.bx.springvue.Controller;

import com.bx.springvue.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@ResponseBody
//@RestController == @RestController
@CrossOrigin
@RestController
public class User {
    @Autowired
    private UserService userService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String index(){
        return userService.findAll().toString();
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public boolean login(String name, String password){
        return userService.getUserpswbyname(name).equals(password);
    }

    @RequestMapping(value="/add",method=RequestMethod.POST)
    public boolean addUser(String name, String password){
        return userService.addUser(name, password);
    }

    @RequestMapping(value="/remove",method=RequestMethod.POST)
    public String removeUser(String name){
        userService.deleteUserbyname(name);
        return userService.findAll().toString();
    }

}
