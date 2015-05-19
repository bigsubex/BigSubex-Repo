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
public class ProductDocumentController {
	
	@RequestMapping(value = BigConstant.PRODUCT_SEARCH_PAGE, method = RequestMethod.GET)
	public ModelAndView oldProduct(ModelMap model){
		return new ModelAndView(BigConstant.PRODUCT_SEARCH);
	}

	@RequestMapping(value = BigConstant.PRODUCT_PROTOKOL_PAGE, method = RequestMethod.GET)
	public ModelAndView newProduct(ModelMap model){
		return new ModelAndView(BigConstant.PRODUCT_PAGE);
	}
}
