/**
 * 
 */
package com.doj.big.subex.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
@RequestMapping(value = BigConstant.USERSIGNINPAGE)
public class UserRegistrationController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView userRegistration(ModelMap model){
		return new ModelAndView(BigConstant.USERSIGNIN);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView handleUserRegistration(ModelMap model){
		return new ModelAndView(BigConstant.USERSIGNIN);
	}
}
