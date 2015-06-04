/**
 * 
 */
package com.doj.big.subex.web.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doj.big.subex.domain.User;
import com.doj.big.subex.validator.UserValidator;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class UserRegistrationController {
	
	@RequestMapping(value = BigConstant.USER_REGISTRATION_PAGE, method = RequestMethod.GET)
	public ModelAndView userRegistration( @ModelAttribute("user") User user, ModelMap model){
		return new ModelAndView(BigConstant.USER_REGISTRATION);
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        binder.setValidator(new UserValidator());
    }
	
   // @ModelAttribute
    public User register(Locale currentLocale) {
		User user = new User();
		user.setCountry(currentLocale.getCountry());
        return user;
    }
	
	@RequestMapping(value = BigConstant.USER_REGISTRATION_PAGE, method = RequestMethod.POST)
	public ModelAndView handleUserRegistration(@Valid @ModelAttribute("user") User user, BindingResult result){
		if (result.hasErrors()) {
			return new ModelAndView(BigConstant.USER_REGISTRATION);
        }
		return new ModelAndView(BigConstant.COMPANY_REGISTRATION);
	}
}
