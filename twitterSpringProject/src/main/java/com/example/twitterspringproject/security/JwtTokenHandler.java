package com.example.twitterspringproject.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenHandler {
    @Value(value="${jwt.token.secret}")
    private String secretKey;

    @Value(value="${jwt.token.expired}")
    private long jwtTokenLifeTime;

    public String generateToken(Authentication authentication){
        Date now = new Date();
        Date expiredAt = new Date(now.getTime()+this.jwtTokenLifeTime);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return Jwts
                .builder()
                .setIssuedAt(now)
                .setExpiration(expiredAt)
                .setSubject(userDetails.getUsername()) //payload
                .signWith(SignatureAlgorithm.HS512, this.secretKey)
                .compact(); //формируем строку jwt
    }

    public String getUsernameFromToken(String token){
        return Jwts
                .parser()
                .setSigningKey(this.secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(this.secretKey).parse(token);
            return true;
        }
        catch(ExpiredJwtException ex){
            System.out.println("Token expired");
        }
        catch(MalformedJwtException ex){
            System.out.println("Token invalid");
        }
        catch(SignatureException ex){
            System.out.println("Token signature incorrect");
        }
        catch(IllegalArgumentException ex){
            System.out.println("Token must contain claims");
        }
        return false;
    }
}

