/**
 * 
 */
package com.doj.big.subex.web.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doj.big.subex.domain.Product;
import com.doj.big.subex.domain.ProductSearchCriteria;
import com.doj.big.subex.service.ProductSearchService;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class ProductSearchController {
	
	//@Autowired
	ProductSearchService productSearchService;
	
	@RequestMapping(value = BigConstant.PRODUCT_SEARCH_PAGE, method = RequestMethod.GET)
	public ModelAndView searchProduct(ModelMap model){
		return new ModelAndView(BigConstant.PRODUCT_SEARCH);
	}
	
	@RequestMapping(value = BigConstant.PRODUCT_SEARCH_PAGE, method = RequestMethod.POST)
	public Collection<Product> list(ProductSearchCriteria criteria ) {
		return this.productSearchService.findProducts(criteria);
	}
}
