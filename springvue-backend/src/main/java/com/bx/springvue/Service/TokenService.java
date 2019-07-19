package com.bx.springvue.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class TokenService {
    private static final long EXPIRE_DATE=30*60*1000;
//    private static String publicKey = "vFg8z&L0t*y6rhQnWBWyMIRQCfWnS9wCa6yZcvMLpJphD$5AIdkPCnVmsAIO7ED0HgUoERR7iPxlrG!LMqd@C07FkleE4VpsMcG";
    private static String key = "";

    public static void setKey(String k){
        key = k;
    }

    public static String getKey(){
        return key;
    }

    public String genToken(String name, String password) {
        String token="";
        setKey(password);
        token= JWT.create()
                .withIssuer(name)
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRE_DATE))
                .sign(Algorithm.HMAC256(key));
        return token;
    }

    public static boolean verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(getKey());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}