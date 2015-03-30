/**
 * 
 */
package com.doj.big.subex.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
@RequestMapping(value = BigConstant.GUESTLOGINPAGE)
public class GuestLoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView guestLogin(ModelMap model){
		return new ModelAndView(BigConstant.GUESTLOGIN);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String handleGuestLogin(ModelMap model,
			@RequestParam String username,
			@RequestParam String password,
			RedirectAttributes redirect,
			HttpSession session){
		
		if("shanker".equals(password) && "shanker@gmail.com".equals(username)){
			session.setAttribute("username", username);
			return "redirect:"+BigConstant.INDEXPAGE;
		}
		return "redirect:"+BigConstant.GUESTLOGINPAGE;
	}
}
