package com.academic.application.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new  Class<?>[]  {WebApplicationConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };

	}
	
	@Override
    protected Filter[] getServletFilters() {
      return new Filter[] {new SiteMeshFilterConfiguration()};
    }
	
	

}
