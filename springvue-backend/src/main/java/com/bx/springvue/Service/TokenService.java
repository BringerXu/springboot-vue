package com.bx.springvue.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class TokenService {
    private static final long EXPIRE_DATE=30*60*1000;
    Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
    private static String key = "vFg8z&L0t*y6rhQnWBWyMIRQCfWnS9wCa6yZcvMLpJphD$5AIdkPCnVmsAIO7ED0HgUoERR7iPxlrG!LMqd@C07FkleE4VpsMcG";

    public String genToken(String name) {
        String token="";
        token= JWT.create()
                .withIssuer(name)
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(key));// 以 key 作为 token 的密钥
        return token;
    }

    public static boolean verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(key);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}