package com.bx.springvue.Controller;

import com.alibaba.fastjson.JSONArray;
import com.bx.springvue.Service.TokenService;
import com.bx.springvue.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@ResponseBody
//@Controller == @RestController
@CrossOrigin
@RestController
public class User {
    Logger logger = LoggerFactory.getLogger(User.class);
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @GetMapping(value="")
    public JSONArray index(){
        return userService.findAll();
    }

    @PostMapping(value="/login")
    public ResponseEntity<String> login(String name, String password, HttpServletRequest request){
        HttpHeaders headers = new HttpHeaders();
        if(userService.getUserpswbyname(name).equals(password)){
            HttpSession session = request.getSession(true);
            String t = tokenService.genToken(name);
            session.setAttribute("token", t);
            logger.info("token:  " + t);
            headers.add("token", t);
            return ResponseEntity.status(200).headers(headers).body("");
        }else {
            return ResponseEntity.status(403).headers(headers).body("");
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
