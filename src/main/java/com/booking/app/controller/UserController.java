package com.booking.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.app.model.User;
import com.booking.app.repository.UserRepository;
import com.booking.app.security.JwtGenerator;
import com.booking.app.service.SecurityService;
import com.booking.app.service.UserService;
import com.booking.app.service.impl.MailSender;
import com.booking.app.service.impl.RecaptchaService;
import com.booking.app.validator.UserValidator;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    private JwtGenerator jwtGenerator ;
    
    @Autowired 
    RecaptchaService captchaService;
    
    @Autowired
	private MailSender mailSender;
    
    @Autowired
    private UserRepository userRepository;
    
    public UserController() {
    	this.jwtGenerator = new JwtGenerator();
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,
    		@RequestParam(name="g-recaptcha-response") String recaptchaResponse, Model model, HttpServletRequest request) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        
        String ip = request.getRemoteAddr();
        String captchaVerifyMessage = 
            captchaService.verifyRecaptcha(ip, recaptchaResponse);
       
        if ( captchaVerifyMessage != null) {
          Map<String, Object> response = new HashMap<>();
          response.put("message", captchaVerifyMessage);
//          return ResponseEntity.badRequest()
//            .body(response);
          return "registration";
        }
        
        userForm.setActive(false);
        userForm.setToken(UUID.randomUUID().toString());

        userService.save(userForm);
        
        String appUrl = request.getScheme() + "://" + request.getServerName();
		if(request.getServerName().equals("localhost"))
			appUrl+=":1312"; 
		String message = "To confirm your e-mail address, please click the link below:\n" + appUrl + "/confirm?token=" + userForm.getToken();
		mailSender.sendMail(userForm.getEmail(), message, "Account Verification");

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @CrossOrigin
    @RequestMapping(value="/login", produces="application/json", method=RequestMethod.POST)
    public String createAuthToken(@RequestBody final User jwtUser) {    	
    	if(securityService.login(jwtUser.getUsername(), jwtUser.getPassword()) != null) {
    		return jwtGenerator.generate(jwtUser);	
    	}
    	
    	return "-1";
    }
    
    @RequestMapping(value="/dobijUsera", method = RequestMethod.GET)
    public Authentication asd() {
    	return SecurityContextHolder.getContext().getAuthentication();
    }
    
    @CrossOrigin
    @RequestMapping(value="/logoutasd", method = RequestMethod.GET)
    public boolean logout (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
            return true;
        }
        return false;
    }
    
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
    
    @RequestMapping(value="/confirm", method = RequestMethod.GET)
	public String showConfirmationPage(Model model, @RequestParam("token") String token) {
			
		User user = userRepository.findByToken(token);
			
		if (user == null) { // No token found in DB
			return "login";
		} else { // Token found
			
			user.setActive(true);
			userRepository.save(user);
			
//			UserDetails userDetails = userService.loadUser(user.getEmail());
//			Authentication auth = 
//					  new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//			SecurityContextHolder.getContext().setAuthentication(auth);
			model.addAttribute("message", "Account successfully verified.");
			return "login";
		}
		//return modelAndView;		
	}
}
