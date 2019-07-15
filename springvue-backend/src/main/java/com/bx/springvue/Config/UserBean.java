package com.bx.springvue.Config;

import com.bx.springvue.Service.UserService;
import com.bx.springvue.Service.Implement.UserServiceImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBean {
    @Bean
    public UserService userService(){
        return new UserServiceImplement();
    }
}
