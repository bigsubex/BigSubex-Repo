/**
 * 
 */
package com.doj.big.subex.web.controller;

import java.util.Locale;

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

import com.doj.big.subex.domain.Company;
import com.doj.big.subex.validator.CompanyValidator;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
@RequestMapping(value = BigConstant.USER_COMPANY_PAGE)
public class CompanyRegistrationController {
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        binder.setValidator(new CompanyValidator());
    }
	
    @ModelAttribute
    public Company register(Locale currentLocale) {
		Company company = new Company();
		company.setCountry(currentLocale.getCountry());
        return company;
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView companyRegistration(ModelMap model){
		return new ModelAndView(BigConstant.USERCOMPANY);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView handleCompanyRegistration(@Valid @ModelAttribute Company company, BindingResult result){
		if (result.hasErrors()) {
			return new ModelAndView(BigConstant.USERCOMPANY);
		}
		return new ModelAndView(BigConstant.EMPLOYEESEDIT);
	}
}
