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
import com.doj.big.subex.web.controller.ProductDocumentController;
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
public class ProductDocumentControllerTest {
	
	@Autowired
	ProductDocumentController productDocumentController;
	
	@Autowired
    private WebApplicationContext context;
	
	@Test
	public void testOldProduct() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(productDocumentController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.PRODUCTOLDPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.PRODUCTOLD));

	}
	
	@Test
	public void testNewProduct() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(productDocumentController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.PRODUCTNEWPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.PRODUCTNEW));

	}

	@Test
	public void testSupplier() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(productDocumentController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.SUPPLIERSHOWPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.SUPPLIERSHOW));

	}
}