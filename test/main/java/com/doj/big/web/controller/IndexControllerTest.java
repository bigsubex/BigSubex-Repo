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
import com.doj.big.subex.web.controller.IndexController;
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
public class IndexControllerTest {
	
	@Autowired
	IndexController indexController;
	
	@Autowired
    private WebApplicationContext context;
	
    
	@Test
	public void testHomePage() throws Exception {
 		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.ROOTPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.HOME));

	}
	
	@Test
	public void testIndexPage() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.INDEXPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.INDEX));

	}
	
	@Test
	public void testSignInPage() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.USERSIGNINPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.USERSIGNIN));

	}
	
	@Test
	public void testCompanyRegistrationPage() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.USERCOMPANYPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.USERCOMPANY));

	}
	
	@Test
	public void testEmployeeEditPage() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.EMPLOYEESEDITPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.EMPLOYEESEDIT));

	}

	@Test
	public void testEmployees() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.EMPLOYEESPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.EMPLOYEES));

	}
	
	@Test
	public void testAdminPage() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.ADMINPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.ADMIN));

	}
	
	@Test
	public void testOldProduct() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.PRODUCTOLDPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.PRODUCTOLD));

	}
	
	@Test
	public void testNewProduct() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.PRODUCTNEWPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.PRODUCTNEW));

	}

	@Test
	public void testSupplier() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.SUPPLIERSHOWPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.SUPPLIERSHOW));

	}
	
	@Test
	public void testForgotPassword() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.FORGOTPASSWORDPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.FORGOTPASSWORD));

	}
}
