/**
 * 
 */
package com.doj.big.subex.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doj.big.subex.domain.Account;
import com.doj.big.subex.service.LoginService;
import com.doj.big.subex.service.exception.AuthenticationException;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class GuestLoginController {
	
	public static final String EMPLOYEE_ATTRIBUTE = "employee";
	public static final String REQUESTED_URL = "REQUESTED_URL";
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = BigConstant.GUEST_LOGIN_PAGE, method = RequestMethod.GET)
	public ModelAndView guestLogin(ModelMap model){
		return new ModelAndView(BigConstant.GUESTLOGIN);
	}
	
	@RequestMapping(value = BigConstant.GUEST_LOGIN_PAGE, method = RequestMethod.POST)
	public String handleGuestLogin(BindingResult result, ModelMap model,
			@RequestParam String email,
			@RequestParam String password,
			RedirectAttributes redirect,
			HttpSession session) throws AuthenticationException{
		Account account = this.loginService.login(email, password);
		session.setAttribute(EMPLOYEE_ATTRIBUTE, account);
		return "redirect:"+BigConstant.USER_SIGNIN_PAGE;
	}
}
