package com.doj.big.subex.web;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.doj.big.subex.config.InfrastructureContextConfiguration;
import com.doj.big.subex.config.TestDataContextConfiguration;
import com.doj.big.subex.web.config.WebMvcContextConfiguration;

/**
 * {@link WebApplicationInitializer} that will be called by Spring's {@code SpringServletContainerInitializer} as part
 * of the JEE {@code ServletContainerInitializer} pattern. This class will be called on application startup and will
 * configure our JEE and Spring configuration.
 * <p/>
 * 
 * It will first initializes our {@code AnnotationConfigWebApplicationContext} with the common {@link Configuration}
 * classes: {@code BigSubexApplicationContextConfiguration} and {@code TestDataContextConfiguration} using a typical JEE
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
	
	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		registerListener(servletContext);
		registerDispatcherServlet(servletContext);
		registerOpenEntityManagerInViewFilter(servletContext);
	}

	private void registerDispatcherServlet(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext dispatcherContext = createContext(WebMvcContextConfiguration.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}
	
	private void registerListener(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext rootContext;
        rootContext = createContext(InfrastructureContextConfiguration.class,
				TestDataContextConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

    }
	 /**
     * Factory method to create {@link AnnotationConfigWebApplicationContext} instances. 
     * @param annotatedClasses
     * @return
     */
    private AnnotationConfigWebApplicationContext createContext(final Class<?>... annotatedClasses) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(annotatedClasses);
        return context;
    }
    
    private void registerOpenEntityManagerInViewFilter(ServletContext servletContext) {
		FilterRegistration.Dynamic registration = servletContext.addFilter("openEntityManagerInView",
				new OpenEntityManagerInViewFilter());
		registration.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true,
				DISPATCHER_SERVLET_NAME);
	}
}
