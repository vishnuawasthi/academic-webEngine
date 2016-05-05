package com.academic.application.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.academic.application.entity.User;
import com.academic.application.entity.UserRole;

@Component
public class UserDetailsImpl extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

	public UserDetailsImpl() {
	}

	public UserDetailsImpl(User user) {
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setUserRole(user.getUserRole());
		this.setUserRole(user.getUserRole());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("getAuthorities()  -start");
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		UserRole userRoles = this.getUserRole();
		if (userRoles != null) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRoles.getRoleName());
			authorities.add(authority);
		}
		System.out.println("getAuthorities()  -end");
		return authorities;
	}
	
	@Override
	public UserRole getUserRole() {
		return super.getUserRole();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
