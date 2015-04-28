package com.doj.big.subex.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.doj.big.subex.domain.Account;
import com.doj.big.subex.service.exception.AuthenticationException;
import com.doj.big.subex.web.controller.UserLoginController;

/**
 * {@code HandlerInterceptor} to apply security to controllers.
 * 
 * @author Dinesh Rajput
 */
public class SecurityHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Account account = (Account) WebUtils.getSessionAttribute(request, UserLoginController.EMPLOYEE_ATTRIBUTE);
        if (account == null) {

            //Retrieve and store the original URL.
            String url = request.getRequestURL().toString();
            WebUtils.setSessionAttribute(request, UserLoginController.REQUESTED_URL, url);
            throw new AuthenticationException("Authentication required.", "authentication.required");
        }
        return true;
    }

}
