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

import com.doj.big.subex.web.config.BigSubexWebMvcContextConfig;
import com.doj.big.subex.web.controller.IndexController;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
	@ContextConfiguration(classes = { BigSubexWebMvcContextConfig.class }),
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
	public void testUserLoginPage() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.USERLOGINPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.USERLOGIN));

	}
	
	@Test
	public void testGuestLoginPage() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.GUESTLOGINPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.GUESTLOGIN));

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

}
