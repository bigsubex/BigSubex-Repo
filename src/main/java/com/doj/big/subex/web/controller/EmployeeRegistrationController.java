/**
 * 
 */
package com.doj.big.subex.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doj.big.subex.domain.Employee;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
@RequestMapping(value = BigConstant.EMPLOYEEREGISTRATIONPAGE)
public class EmployeeRegistrationController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView employeeRegistration(ModelMap model){
		return new ModelAndView(BigConstant.EMPLOYEESEDIT);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView handleEmployeeRegistration(@Valid @ModelAttribute Employee employee, BindingResult result){
		if (result.hasErrors()) {
			return new ModelAndView(BigConstant.EMPLOYEESEDIT);
		}
		return new ModelAndView(BigConstant.EMPLOYEES);
	}
}
