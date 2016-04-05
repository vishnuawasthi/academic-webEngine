/**
 * 
 *//*
package com.academic.application.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

*//**
 * @author Vishnu Awasthi
 *
 *//*
public class ApplicationInitializer implements WebApplicationInitializer {
	
	private static final String CONFIG_LOCATION = "com.academic.application.configuration";
	
	private static final String MAPPING_URL = "/";
	
	public void onStartup(ServletContext servletContext)throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
												context.register(WebApplicationConfiguration.class);
												context.setServletContext(servletContext);
												context.setConfigLocation(CONFIG_LOCATION);
												servletContext.addListener(new ContextLoaderListener(context));
												servletContext.addFilter("ConfigurableSiteMeshFilter", new SiteMeshFilterConfiguration());
			
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
												 dispatcher.setLoadOnStartup(1);
												 dispatcher.addMapping(MAPPING_URL);
												 
	}
	
}
*/