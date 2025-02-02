package com.bank.customer.authentication;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Component
public class JWTUtility {
	
	
	
	private static final String secretKey = "QWERdajdniuhdeouhdndijniejnadiTYUIOP0987654321ASDFGHJKLPOMNBVCXZDFGRTSQWERTYCNDJUTGDKLOY";
	
	private final long expiration = 86400000L; // 24 hours
	
	public String generateToken(String email) {
		
		return Jwts.builder().setSubject(email).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}
	
	public Claims extractClaims(String token) {
		return Jwts.parser().setSigningKey(secretKey)
				.parseClaimsJwt(token).getBody();
	}
	
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }
}
