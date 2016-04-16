package com.academic.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * http .csrf().disable()
		 * .authorizeRequests().antMatchers("/home").access("hasRole('USER')")
		 * .and()
		 * .formLogin().usernameParameter("username").passwordParameter("password"
		 * ).loginPage("/login") .failureUrl("/login?error") .and()
		 * .logout().logoutSuccessUrl("/login?logout") .and()
		 * .exceptionHandling().accessDeniedPage("/403");
		 */

		http.csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET, "/login").permitAll()
				.antMatchers(HttpMethod.GET, "/logout").permitAll()
				.antMatchers("/*")
				.authenticated()
				.and()
				.formLogin()
				.usernameParameter("username")
				.passwordParameter("password")
				.loginPage("/login")
			//	.loginProcessingUrl("")
				.successHandler(successHandler)
				.failureUrl("/login?error")
				.and()
				.logout()
				.logoutSuccessUrl("/login?logout")
				.and().exceptionHandling()
				.accessDeniedPage("/403");

	}
}
