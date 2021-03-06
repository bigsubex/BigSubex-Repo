/**
 * 
 */
package com.doj.big.subex.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doj.big.subex.domain.Product;
import com.doj.big.subex.service.ProductDetailService;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class ProductDetailController {
	
	//@Autowired
	ProductDetailService productDetailService;
	
	@RequestMapping(value = BigConstant.PRODUCT_DETAIL_PAGE, method = RequestMethod.GET)
	public ModelAndView product(ModelMap model){
		return new ModelAndView(BigConstant.PRODUCT_DETAIL);
	}
	
	@RequestMapping(value = BigConstant.PRODUCT_DETAIL_PAGE+"/{productId}")
	public String details(@PathVariable("productId") long productId, Model model) {
		Product product = this.productDetailService.findProduct(productId);
		model.addAttribute(product);
		return BigConstant.PRODUCT_DETAIL;
	}
}
