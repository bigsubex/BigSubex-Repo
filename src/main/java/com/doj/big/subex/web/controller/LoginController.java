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

import com.doj.big.subex.domain.Account;
import com.doj.big.subex.service.exception.AuthenticationException;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
@RequestMapping(value = BigConstant.LOGINPAGE)
public class LoginController {
	
	public static final String ACCOUNT_ATTRIBUTE = "account";
	public static final String REQUESTED_URL = "REQUESTED_URL";
	
	@RequestMapping(value = BigConstant.USER, method = RequestMethod.GET)
	public ModelAndView userLogin(ModelMap model, HttpSession session){
		model.put("errorMessage", session.getAttribute("errorMessage"));
		session.removeAttribute("errorMessage"); 
		return new ModelAndView(BigConstant.USERLOGIN);
	}
	
	@RequestMapping(value = BigConstant.USER, method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model,
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam(required = false) boolean rememberMe,
			RedirectAttributes redirect,
			HttpSession session) throws AuthenticationException{
		
		 String url = (String) session.getAttribute(REQUESTED_URL);
	     session.removeAttribute(REQUESTED_URL); 
	     Account account = new Account(username, password);
	     session.setAttribute(ACCOUNT_ATTRIBUTE, account);
	     
		if("shanker".equals(password) && "shanker@gmail.com".equals(username)){
			session.setAttribute("username", username);
			session.removeAttribute("errorMessage"); 
			return "redirect:"+BigConstant.INDEXPAGE;
		}
		session.setAttribute("errorMessage", "Invalid Credential");
		return "redirect:"+BigConstant.USERLOGINPAGE;
	}
	
	@RequestMapping(value = BigConstant.GUEST, method = RequestMethod.GET)
	public ModelAndView guestLogin(ModelMap model){
		return new ModelAndView(BigConstant.GUESTLOGIN);
	}
	
	@RequestMapping(value = BigConstant.GUEST, method = RequestMethod.POST)
	public String handleGuestLogin(ModelMap model,
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam(required = false) boolean rememberMe,
			RedirectAttributes redirect,
			HttpSession session) throws AuthenticationException{
		
		if("shanker".equals(password) && "shanker@gmail.com".equals(username)){
			session.setAttribute("username", username);
			return "redirect:"+BigConstant.INDEXPAGE;
		}
		return "redirect:"+BigConstant.GUESTLOGINPAGE;
	}
}
