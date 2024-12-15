package com.product.entity.authentication;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Collections;

public class JWTFilter extends OncePerRequestFilter {
	
	private static final String secretKey = "QWERdajdniuhdeouhdndijniejnadiTYUIOP0987654321ASDFGHJKLPOMNBVCXZDFGRTSQWERTYCNDJUTGDKLOY";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = request.getHeader("Authorization");
		
		if (token != null && token.startsWith("Bearer "))
		{
			token = token.substring(7);
			try {
				Claims claims = Jwts.parser().setSigningKey(secretKey)
						.parseClaimsJwt(token).getBody();
				
				String username = claims.getSubject();
				
				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null)
				{
					JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken
							(username, token, Collections.emptyList());
				}
			} catch(Exception e)
			{
				
			}
		}
		
		
	}

}
