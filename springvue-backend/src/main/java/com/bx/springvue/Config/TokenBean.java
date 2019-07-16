package com.bx.springvue.Config;

import com.bx.springvue.Service.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenBean {
    @Bean
    public TokenService tokenService(){
        return new TokenService();
    }

}
