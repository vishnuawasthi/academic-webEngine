package com.academic.application.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
		if (!StringUtils.isEmpty(username)) {
			User user = userRepository.findUserByUsername(username);
			if (!StringUtils.isEmpty(user))
				return new UserDetailsImpl(user);
			log.info("loadUserByUsername() - end");
		}
		log.info("loadUserByUsername() - end  : record  is null");
		return null;
	}

}
