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
public class IndexController {
	
	@RequestMapping(BigConstant.ROOTPAGE)
	public ModelAndView home(ModelMap model){
		model.put("message", "Welcome to BigSubex Project!!!");
		return new ModelAndView(BigConstant.HOME);
	}
	
	@RequestMapping(value = BigConstant.INDEXPAGE, method = RequestMethod.GET)
	public ModelAndView index(ModelMap model){
		return new ModelAndView(BigConstant.INDEX);
	}
	
	@RequestMapping(value = BigConstant.USERLOGINPAGE, method = RequestMethod.GET)
	public ModelAndView userLogin(ModelMap model){
		return new ModelAndView(BigConstant.USERLOGIN);
	}
	
	@RequestMapping(value = BigConstant.GUESTLOGINPAGE, method = RequestMethod.GET)
	public ModelAndView guestLogin(ModelMap model){
		return new ModelAndView(BigConstant.GUESTLOGIN);
	}
	
	@RequestMapping(value = BigConstant.USERSIGNINPAGE, method = RequestMethod.GET)
	public ModelAndView userRegister(ModelMap model){
		return new ModelAndView(BigConstant.USERSIGNIN);
	}
	
	@RequestMapping(value = BigConstant.USERCOMPANYPAGE, method = RequestMethod.GET)
	public ModelAndView companyRegister(ModelMap model){
		return new ModelAndView(BigConstant.USERCOMPANY);
	}
	
	@RequestMapping(value = BigConstant.EMPLOYEESEDITPAGE, method = RequestMethod.GET)
	public ModelAndView employeeRegister(ModelMap model){
		return new ModelAndView(BigConstant.EMPLOYEESEDIT);
	}
	
	@RequestMapping(value = BigConstant.EMPLOYEESPAGE, method = RequestMethod.GET)
	public ModelAndView employees(ModelMap model){
		return new ModelAndView(BigConstant.EMPLOYEES);
	}
	
	@RequestMapping(value = BigConstant.ERRORPAGE, method = RequestMethod.GET)
	public String error(ModelMap model){
		return BigConstant.ERROR404;
	}
}
 