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
@RequestMapping(value = BigConstant.USERCOMPANYPAGE)
public class CompanyRegistrationController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView companyRegistration(ModelMap model){
		return new ModelAndView(BigConstant.USERCOMPANY);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView handleCompanyRegistration(ModelMap model){
		return new ModelAndView(BigConstant.USERCOMPANY);
	}
}
