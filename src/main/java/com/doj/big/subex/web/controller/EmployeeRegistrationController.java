/**
 * 
 */
package com.doj.big.subex.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doj.big.subex.domain.Employee;
import com.doj.big.subex.validator.EmployeeValidator;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class EmployeeRegistrationController {
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        binder.setValidator(new EmployeeValidator());
    }
	
	@RequestMapping(value = BigConstant.EMPLOYEE_REGISTRATION_PAGE, method = RequestMethod.GET)
	public ModelAndView employeeRegistration(ModelMap model){
		return new ModelAndView(BigConstant.EMPLOYEE_REGISTRATION);
	}
	
	@RequestMapping(value = BigConstant.EMPLOYEE_REGISTRATION_PAGE, method = RequestMethod.POST)
	public ModelAndView handleEmployeeRegistration(@Valid @ModelAttribute Employee employee, BindingResult result){
		if (result.hasErrors()) {
			return new ModelAndView(BigConstant.EMPLOYEE_REGISTRATION);
		}
		return new ModelAndView(BigConstant.EMPLOYEES);
	}
	
	@RequestMapping(value = BigConstant.EMPLOYEES_PAGE, method = RequestMethod.GET)
	public ModelAndView employees(ModelMap model){
		return new ModelAndView(BigConstant.EMPLOYEES);
	}
}
