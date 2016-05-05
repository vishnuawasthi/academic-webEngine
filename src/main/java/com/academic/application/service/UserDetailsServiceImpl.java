package com.academic.application.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.academic.application.entity.User;
import com.academic.application.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger log = Logger.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername() - start");
		System.out.println("loadUserByUsername   :  username " + username);
		List<User> users = null;
		User user = null;
		try{
			 users = userRepository.findUserByUsername(username);
			 
			 System.out.println("users : "+users);
			 
			 if(!CollectionUtils.isEmpty(users)){
				 user = users.get(0);
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("*****************************************");
		
		System.out.println("user::::::::::::::::" + user.getUsername() + "   Password " + user.getPassword());
		System.out.println("(((((((((((((((((((((((((((((((((((((((((");
		return new UserDetailsImpl(user);
	}

}
