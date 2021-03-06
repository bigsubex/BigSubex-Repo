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
import com.doj.big.subex.web.controller.UserLoginController;
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
public class UserLoginControllerTest {
	
	@Autowired 
	UserLoginController userLoginController;
	
	@Test
	public void testUserLoginPage() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userLoginController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.USER_LOGIN_PAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.USER_LOGIN));

	}
	
	/*@Before
    public void setup() throws AuthenticationException {
        User account = new UserBuilder()
        {
            {
            	credentials("john", "secret");
            }
        }.build(true);

        Mockito.when(this.accountService.login("john", "secret")).thenReturn(account);
    }*/
	 
	@SuppressWarnings("deprecation")
	@Test
    public void testHandleLogin() throws AuthenticationException {

        MockHttpSession mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute(UserLoginController.REQUESTED_URL, "/indexc");

        String view = this.userLoginController.handleUserLogin(null, "dinesh", "rajput", null, mockHttpSession);

        Account account = (Account) mockHttpSession.getAttribute(UserLoginController.EMPLOYEE_ATTRIBUTE);

        assertNotNull(account);
        assertEquals("dinesh", account.getUsername());
        assertEquals("rajput", account.getPassword());
        assertNull(mockHttpSession.getAttribute(UserLoginController.REQUESTED_URL));
        assertEquals("redirect:/indexc", view);

        // Test the different view selection choices
        mockHttpSession = new MockHttpSession();
        view = this.userLoginController.handleUserLogin(null, "dinesh", "rajput", null, mockHttpSession);
        assertEquals("redirect:/indexc", view);

        mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute(UserLoginController.REQUESTED_URL, "/indexc");
        view = this.userLoginController.handleUserLogin(null, "dinesh", "rajput", null, mockHttpSession);
        assertEquals("redirect:/indexc", view);
    }
	
	@Test
	public void testForgotPassword() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userLoginController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.FORGOT_PASSWORD_PAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.FORGOT_PASSWORD));

	}
	
	@Test
	public void testChangePassword() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userLoginController).build();
		mockMvc.perform(MockMvcRequestBuilders.get(BigConstant.CHANGE_PASSWORD_PAGE)).andExpect(MockMvcResultMatchers.view().name(BigConstant.CHANGE_PASSWORD));

	}
	
}
