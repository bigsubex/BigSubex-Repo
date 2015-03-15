package com.doj.big.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.doj.big.subex.web.config.BigSubexWebMvcContextConfig;
import com.doj.big.subex.web.controller.IndexController;
import com.doj.big.subex.web.utils.BigConstant;

/**
 * @author Dinesh.Rajput
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BigSubexWebMvcContextConfig.class })
@WebAppConfiguration
public class IndexControllerTest {
	
	@Autowired
	IndexController indexController;
	
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

}
