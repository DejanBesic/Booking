package com.booking.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.app.DTOs.JwtAuthenticationResponse;
import com.booking.app.DTOs.LoginRequest;
import com.booking.app.DTOs.RegistrationResponse;
import com.booking.app.DTOs.SignUpRequest;
import com.booking.app.model.Role;
import com.booking.app.model.User;
import com.booking.app.repository.UserRepository;
import com.booking.app.security.JwtTokenProvider;
import com.booking.app.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    	Authentication authentication = null;
    	
    	try {
    		authentication = autoLogin(loginRequest.getUsernameOrEmail(), loginRequest.getPassword());
    	}catch(Exception e){
    		e.printStackTrace();
    		return new ResponseEntity<>("Wrong username or password", HttpStatus.BAD_REQUEST);
    	}
    	
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        
        return new ResponseEntity<>(new JwtAuthenticationResponse(jwt), HttpStatus.OK);
    }
    
    @GetMapping("/GetUser")
    public ResponseEntity<?> getUser() {
    	return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication());
    }
    
    @GetMapping("/signout")
    public boolean logout (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
            return true;
        }
        return false;
    }
    

    @PostMapping("/signup")
    public ResponseEntity<RegistrationResponse> registerUser(@RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new RegistrationResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
        	return new ResponseEntity<>(new RegistrationResponse(false, "Email address is already in use!"), HttpStatus.BAD_REQUEST);
        }

        
        Role role = roleService.findByName("REGULAR");
        
        // Creating user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getPassword(), role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //Save in base
        User result = userRepository.save(user);
        
        if(result == null) {
        	return new ResponseEntity<>(new RegistrationResponse(false, "Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new RegistrationResponse(true, "Successfuly registrated."), HttpStatus.OK);
    }
    
    
    
    private Authentication autoLogin(String username, String password) {
    	return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );
    }
}
