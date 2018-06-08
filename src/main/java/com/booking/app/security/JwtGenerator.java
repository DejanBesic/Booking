package com.booking.app.security;

import org.springframework.stereotype.Component;

import com.booking.app.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public String generate(User jwtUser) {
		
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUsername());
		claims.put("userId", String.valueOf(jwtUser.getId()));
		claims.put("role", "REGULAR");
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "tajnica").compact();
	}

}
