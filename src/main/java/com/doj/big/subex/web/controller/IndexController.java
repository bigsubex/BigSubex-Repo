package com.doj.big.subex.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping(BigConstant.INDEXPAGE)
	public ModelAndView index(ModelMap model){
		return new ModelAndView(BigConstant.INDEX);
	}
	
	@RequestMapping(BigConstant.USERLOGINPAGE)
	public ModelAndView userLogin(ModelMap model){
		return new ModelAndView(BigConstant.USERLOGIN);
	}
	
	@RequestMapping(BigConstant.GUESTLOGINPAGE)
	public ModelAndView guestLogin(ModelMap model){
		return new ModelAndView(BigConstant.GUESTLOGIN);
	}
}
 