/**
 * 
 */
package com.doj.big.subex.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doj.big.subex.domain.Account;
import com.doj.big.subex.service.AccountService;
import com.doj.big.subex.service.exception.AuthenticationException;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class UserLoginController {
	
	public static final String ACCOUNT_ATTRIBUTE = "account";
	public static final String REQUESTED_URL = "REQUESTED_URL";
	
	 @Autowired
	 private AccountService accountService;
	 
	@RequestMapping(value = BigConstant.USERLOGINPAGE, method = RequestMethod.GET)
	public ModelAndView userLogin(ModelMap model, HttpSession session){
		return new ModelAndView(BigConstant.USERLOGIN);
	}
	
	@RequestMapping(value = BigConstant.USERLOGINPAGE, method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model,
			@RequestParam String username,
			@RequestParam String password,
			RedirectAttributes redirect,
			HttpSession session) throws AuthenticationException{ 
		
		 String url = (String) session.getAttribute(REQUESTED_URL);
	     session.removeAttribute(REQUESTED_URL); 
	     Account account = this.accountService.login(username, password);
	     session.setAttribute(ACCOUNT_ATTRIBUTE, account);
	     if(StringUtils.hasText(url) && !url.contains(BigConstant.USERLOGIN)){
	    	 return "redirect:"+url;
	     }else{
	    	 return "redirect:"+BigConstant.INDEXPAGE;
	     }
	}
	
	@RequestMapping(value = BigConstant.FORGOTPASSWORDPAGE, method = RequestMethod.GET)
	public ModelAndView forgotPassword(ModelMap model){
		return new ModelAndView(BigConstant.FORGOTPASSWORD);
	}
}
