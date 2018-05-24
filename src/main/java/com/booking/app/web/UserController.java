package com.booking.app.web;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.app.model.User;
import com.booking.app.repository.UserRepository;
import com.booking.app.service.MailSender;
import com.booking.app.service.RecaptchaService;
import com.booking.app.service.SecurityService;
import com.booking.app.service.UserService;
import com.booking.app.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired 
    RecaptchaService captchaService;
    
    @Autowired
	private MailSender mailSender;
    
    @Autowired
    private UserRepository userRepository;

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

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
