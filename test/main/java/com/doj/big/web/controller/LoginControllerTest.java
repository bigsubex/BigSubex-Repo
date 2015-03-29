/**
 * 
 */
package com.doj.big.web.controller;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.doj.big.subex.domain.Account;
import com.doj.big.subex.service.exception.AuthenticationException;
import com.doj.big.subex.web.config.WebMvcContextConfiguration;
import com.doj.big.subex.web.controller.LoginController;
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
public class LoginControllerTest {
	
	@Autowired 
	LoginController loginController;
	
	@Test
	public void testUserLoginPage() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.USERLOGINPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.USERLOGIN));

	}
	
	@Test
	public void testGuestLoginPage() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.GUESTLOGINPAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.GUESTLOGIN));

	}
	
	@SuppressWarnings("deprecation")
	@Test
    public void testHandleLogin() throws AuthenticationException {

        MockHttpSession mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute(LoginController.REQUESTED_URL, "/indexc");

        String view = this.loginController.handleUserLogin(null, "shanker@gmail.com", "shanker", false, null, mockHttpSession);

        Account account = (Account) mockHttpSession.getAttribute(LoginController.ACCOUNT_ATTRIBUTE);

        assertNotNull(account);
        assertEquals("shanker@gmail.com", account.getEmail());
        assertEquals("shanker", account.getPassword());
        assertNull(mockHttpSession.getAttribute(LoginController.REQUESTED_URL));
        assertEquals("redirect:/indexc", view);

        // Test the different view selection choices
        mockHttpSession = new MockHttpSession();
        view = this.loginController.handleUserLogin(null, "shanker@gmail.com", "shanker", false, null, mockHttpSession);
        assertEquals("redirect:/indexc", view);

        mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute(LoginController.REQUESTED_URL, "abclogindef");
        view = this.loginController.handleUserLogin(null, "shanker@gmail.com", "shanker", false, null, mockHttpSession);
        assertEquals("redirect:/indexc", view);
    }
}
