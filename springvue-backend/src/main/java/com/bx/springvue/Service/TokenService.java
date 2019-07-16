package com.bx.springvue.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenService {
    public String getToken(String name, String password) {
        String token="";
        token= JWT.create()
                .withClaim("name", name)
                .withClaim("generatetime",System.currentTimeMillis())
                .withClaim("exptime",1000*1*60*60)
                .sign(Algorithm.HMAC256(password));// 以 password 作为 token 的密钥
        return token;
    }
}
