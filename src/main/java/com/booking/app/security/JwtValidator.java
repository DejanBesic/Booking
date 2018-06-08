package com.booking.app.security;

import org.springframework.stereotype.Component;

import com.booking.app.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String secret = "tajnica";

	public User validate(String token) {
		
		User jwtUser = null;
		try {
			Claims body = Jwts.parser()
							.setSigningKey(secret)
							.parseClaimsJws(token)
							.getBody();
		
	//		jwtUser = new JwtUser(body.getSubject(), Long.parseLong((String)body.get("userId")), (String) body.get("role"), (String) body.get("password") );
			jwtUser = new User();
			jwtUser.setUsername(body.getSubject());
			jwtUser.setId(Long.parseLong((String)body.get("userId")));
	//		jwtUser.setRole((String) body.get("role"));
	//		jwtUser.setUsername(body.getSubject());
	//		jwtUser.setId(Long.parseLong((String)body.get("userId")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jwtUser;
	}
}
