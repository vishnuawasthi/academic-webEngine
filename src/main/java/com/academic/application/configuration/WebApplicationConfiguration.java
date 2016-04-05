package com.academic.application.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableSpringDataWebSupport
@EnableWebMvc
@Configuration
@Import(value = { JPAConfiguration.class, EmailConfiguration.class, })
@PropertySource(value = { "classpath:application.properties"

})

@ComponentScan({ "com.academic.application.configuration", "com.academic.application.controller",
		"com.academic.application.service", "com.academic.application.utils", })
public class WebApplicationConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(new RequestInterceptor());
		
		//registry.addInterceptor(new SiteMeshFilterConfiguration());

	}
	
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
		registry.addResourceHandler("/resources/script/**").addResourceLocations("/resources/script/");
		registry.addResourceHandler("/resources/images/**").addResourceLocations("/resources/images/");
		registry.addResourceHandler("layout/scripts/**").addResourceLocations("layout/scripts/");
		
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/*@Bean
	public ResourceBundleViewResolver getResourceBundleViewResolver() {
		ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
		viewResolver.setBasename("views");
		viewResolver.setOrder(1);
		return viewResolver;
	}*/

	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setContentType("text/html");
		viewResolver.setOrder(2);
		return viewResolver;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getMultipartResolver() {
		CommonsMultipartResolver viewResolver = new CommonsMultipartResolver();
		viewResolver.setMaxUploadSize(90000000);
		return viewResolver;
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasenames("classpath:messages");
		resource.setDefaultEncoding("UTF-8");
		return resource;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.addAll(getMessageConverters());
	}

	private List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new MappingJackson2HttpMessageConverter());
		return converters;
	}

	// Velocity Support
	/*@Bean
	public VelocityLayoutViewResolver velocityViewResolver() {
		VelocityLayoutViewResolver viewResolver = new VelocityLayoutViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/velocity/");
		// URL Key Default is layout
		viewResolver.setLayoutUrl("/WEB-INF/views/layout/layout.vm");
		viewResolver.setSuffix(".vm");
		viewResolver.setOrder(3);
		return viewResolver;
	}
*/
	// This bean is need in order to get the response of velocity template on
	// browser
	/*@Bean
	public VelocityConfigurer velocityConfig() {
		VelocityConfigurer velocityConfig = new VelocityConfigurer();
		velocityConfig.setResourceLoaderPath("/");
		// velocityConfig.setVelocityEngine( velocityEngine());
		velocityConfig.setPreferFileSystemAccess(true);
		return velocityConfig;
	}

	@Bean
	public VelocityEngineFactoryBean velocityEngineFactoryBean() {
		VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
		Properties velocityProperties = new Properties();
		velocityProperties.setProperty("resource.loader", "class");
		velocityProperties.setProperty("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityEngine.setVelocityProperties(velocityProperties);
		return velocityEngine;
	}*/

}
