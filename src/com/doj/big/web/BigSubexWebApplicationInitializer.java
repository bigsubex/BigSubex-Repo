package com.doj.big.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.doj.big.web.config.BigSubexMvcConfig;

/**
 * {@link WebApplicationInitializer} that will be called by Spring's {@code SpringServletContainerInitializer} as part
 * of the JEE {@code ServletContainerInitializer} pattern. This class will be called on application startup and will
 * configure our JEE and Spring configuration.
 * <p/>
 * 
 * It will first initializes our {@code AnnotationConfigWebApplicationContext} with the common {@link Configuration}
 * classes: {@code InfrastructureContextConfiguration} and {@code TestDataContextConfiguration} using a typical JEE
 * {@code ContextLoaderListener}.
 * <p/>
 * 
 * Next it creates a {@link DispatcherServlet}, being a normal JEE Servlet which will create on its turn a child
 * {@code AnnotationConfigWebApplicationContext} configured with the Spring MVC {@code Configuration} classes
 * {@code WebMvcContextConfiguration} and {@code WebflowContextConfiguration}. This Servlet will be registered using
 * JEE's programmtical API support.
 * <p/>
 * @author Dinesh.Rajput
 *
 */
public class BigSubexWebApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		registerDispatcherServlet(servletContext);
	}

	private void registerDispatcherServlet(ServletContext servletContext) {
		WebApplicationContext dispatcherContext = createContext(BigSubexMvcConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}
	
	 /**
     * Factory method to create {@link AnnotationConfigWebApplicationContext} instances. 
     * @param annotatedClasses
     * @return
     */
    private WebApplicationContext createContext(final Class<?>... annotatedClasses) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(annotatedClasses);
        return context;
    }
}
