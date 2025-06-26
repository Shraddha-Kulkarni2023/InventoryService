package com.example.InventoryService.Service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JwtValidator {

    //private final Key key = Keys.hmacShaKeyFor("my-very-secret-key-1234567890!".getBytes());
    private String key;

    @PostConstruct
    public void init() {

        this.key = "my-very-secret-key-1234567890!";


    }
    public boolean validateToken(String token) {

        try {

            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException ex) {

            return false;

        }

    }

    public String getUsername(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
