package com.doj.big.subex.web.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * {@code WebRequestInterceptor} implementation to add common data (random books) to the model.
 * 
 * @author Dinesh Rajput
 */
public class CommonDataInterceptor implements WebRequestInterceptor {


    @Override
    public void preHandle(WebRequest request) throws Exception {
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        /*if (model != null) {
            model.addAttribute("randomBooks", this.bookstoreService.findRandomBooks());
        }*/

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
    }

}
