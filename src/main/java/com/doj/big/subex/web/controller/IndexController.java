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
		return new ModelAndView(BigConstant.INDEX);
	}
	
	@RequestMapping(value = BigConstant.INDEXPAGE, method = RequestMethod.GET)
	public ModelAndView index(ModelMap model){
		return new ModelAndView(BigConstant.INDEX);
	}
	
	@RequestMapping(value = BigConstant.EMPLOYEESPAGE, method = RequestMethod.GET)
	public ModelAndView employees(ModelMap model){
		return new ModelAndView(BigConstant.EMPLOYEES);
	}
	
	@RequestMapping(value = BigConstant.ADMINPAGE, method = RequestMethod.GET)
	public ModelAndView admin(ModelMap model){
		return new ModelAndView(BigConstant.ADMIN);
	}
	
	@RequestMapping(value = BigConstant.PRODUCTOLDPAGE, method = RequestMethod.GET)
	public ModelAndView oldProduct(ModelMap model){
		return new ModelAndView(BigConstant.PRODUCTOLD);
	}

	@RequestMapping(value = BigConstant.PRODUCTNEWPAGE, method = RequestMethod.GET)
	public ModelAndView newProduct(ModelMap model){
		return new ModelAndView(BigConstant.PRODUCTNEW);
	}
	
	@RequestMapping(value = BigConstant.SUPPLIERSHOWPAGE, method = RequestMethod.GET)
	public ModelAndView supplierShow(ModelMap model){
		return new ModelAndView(BigConstant.SUPPLIERSHOW);
	}
	
	@RequestMapping(value = BigConstant.FORGOTPASSWORDPAGE, method = RequestMethod.GET)
	public ModelAndView forgotPassword(ModelMap model){
		return new ModelAndView(BigConstant.FORGOTPASSWORD);
	}
	
	@RequestMapping(value = BigConstant.ERRORPAGE, method = RequestMethod.GET)
	public String error(ModelMap model){
		return BigConstant.ERROR404;
	}
}
 