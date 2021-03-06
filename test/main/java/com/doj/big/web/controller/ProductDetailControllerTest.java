/**
 * 
 */
package com.doj.big.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.doj.big.subex.web.config.WebMvcContextConfiguration;
import com.doj.big.subex.web.controller.ProductDetailController;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
	@ContextConfiguration(classes = { WebMvcContextConfiguration.class }),
	@ContextConfiguration(locations = "classpath:tiles-defs.xml")
})
public class ProductDetailControllerTest {
	
	@Autowired
	ProductDetailController productDetailController;
	
	@Autowired
    private WebApplicationContext context;
	
	@Test
	public void testNewProduct() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(productDetailController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.PRODUCT_DETAIL_PAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.PRODUCT_DETAIL));

	}
}
