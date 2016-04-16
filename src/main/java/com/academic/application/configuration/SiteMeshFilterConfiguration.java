package com.academic.application.configuration;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SiteMeshFilterConfiguration extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		System.out.println("applyCustomConfiguration() - start");
		builder.setMimeTypes("text/html");
		//builder.addDecoratorPath("/login", "/WEB-INF/decorators/master.jsp");
		
		builder.addDecoratorPath("/login", "/WEB-INF/decorators/beforeLoginMaster.jsp");
		
		
		builder.addDecoratorPath("/online-exam", "/WEB-INF/decorators/onlineTestMaster.jsp");
		
		builder.addDecoratorPath("/", "/WEB-INF/decorators/beforeLoginMaster.jsp");
		builder.addDecoratorPath("/register", "/WEB-INF/decorators/beforeLoginMaster.jsp");
		builder.addDecoratorPath("/time-table", "/WEB-INF/decorators/beforeLoginMaster.jsp");
		//contactus
		builder.addDecoratorPath("/contact-us", "/WEB-INF/decorators/beforeLoginMaster.jsp");
		
		builder.addDecoratorPath("/viewUserDetails", "/WEB-INF/decorators/beforeLoginMaster.jsp");
		builder.addDecoratorPath("/editUserDetail", "/WEB-INF/decorators/beforeLoginMaster.jsp");
		builder.addDecoratorPath("/updateUserDetail", "/WEB-INF/decorators/beforeLoginMaster.jsp");
		System.out.println("applyCustomConfiguration() - end");
	}

}
