package com.example.spring_security_token.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private final String SECRET_KEY = "08F5C5E8F1E0DBF96012A980802753EDC0244A9E9E497A42B509FF0A8B9A902443A9A7E7030430297AF919960925F69D18D428FD47275EE4BEF33D2CBD72EF7CA64B6F377B508F6CD118C5B471B442D9A33C393C75480399F3CD60D15BFF51B53CC0766CB3F9FF661B2A3365C947969504D007ADA6671FB89B979AAF716676FB";
    public String generateToken(String username){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,username);
    }


    private String createToken(Map<String, Object> claims, String username) {
       return Jwts.builder()
               .setClaims(claims)
               .setSubject(username)
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date (System.currentTimeMillis()+30*60*1000))
               .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

    }


    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }



}
