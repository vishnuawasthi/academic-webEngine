package com.academic.application.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.academic.application.dto.UserDTO;
import com.academic.application.entity.User;
import com.academic.application.entity.UserRole;
import com.academic.application.exception.ResourceNotFoundException;
import com.academic.application.form.RegistrationForm;
import com.academic.application.repository.UserRepository;
import com.academic.application.repository.UserRoleRepository;
import com.academic.application.utils.CollectionUtility;

/**
 * 
 * @author Vishnu Awasthi
 * @since RC 1.0
 *
 */
public interface UserService {

	public Long save(RegistrationForm registrationForm) throws ResourceNotFoundException;

	public void update(RegistrationForm registrationForm) throws ResourceNotFoundException;

	public void delete(Long id);

	public List<UserDTO> getAll();

	public UserDTO getOne(Long id);

	public UserDTO getByUsername(String username);

	public boolean updatePassword(Integer id, String password);

	public UserDTO getCurrentUser();

	@Service
	public class Impl implements UserService {

		private static final Logger log = Logger.getLogger(Impl.class);

		@Autowired
		private UserRepository userRepository;

		@Autowired
		private UserRoleRepository userRoleRepository;

		@Override
		public Long save(RegistrationForm registrationForm) throws ResourceNotFoundException {
			log.info("save() - start");
			UserRole role = userRoleRepository.findByRoleName(registrationForm.getRole());
			if (StringUtils.isEmpty(role)) {
				log.error("Something went wrong why saving entity");
				throw new ResourceNotFoundException("UserRole  entity not found with given roleName "
						+ registrationForm.getRole());
			}
			User entity = formToEntity(registrationForm);
			entity.setUserRole(role);
			userRepository.save(entity);
			log.info("save() - end");
			return entity.getId();
		}

		private User formToEntity(RegistrationForm registrationForm) {
			User entity = new User();
			entity.setId(registrationForm.getId());
			entity.setFirstName(registrationForm.getFirstName());
			entity.setLastName(registrationForm.getLastName());
			entity.setEmail(registrationForm.getEmail());
			entity.setMobile(registrationForm.getMobile());
			entity.setAddressLine1(registrationForm.getAddressLine1());
			entity.setAddressLine2(registrationForm.getAddressLine2());
			entity.setCity(registrationForm.getCity());
			entity.setState(registrationForm.getState());
			entity.setCountry(registrationForm.getCountry());
			entity.setPincode(registrationForm.getPincode());
			entity.setProfilePictureURL(registrationForm.getProfilePictureURL());
			entity.setUsername(registrationForm.getUsername());
			entity.setPassword(registrationForm.getPassword());
			return entity;
		}

		@Override
		public void update(RegistrationForm registrationForm) throws ResourceNotFoundException {
			log.info("update() - start");
			User entity = userRepository.findOne(registrationForm.getId());
			if (StringUtils.isEmpty(entity)) {
				log.error("User entity  not found with given id " + registrationForm.getId());
				throw new ResourceNotFoundException("User entity  not found with given id " + registrationForm.getId());
			}
			updateEntity(entity, registrationForm);
			userRepository.save(entity);
			log.info("update() - end");
		}

		private void updateEntity(User entity, RegistrationForm registrationForm) {
			if (!StringUtils.isEmpty(registrationForm.getFirstName()))
				entity.setFirstName(registrationForm.getFirstName());

			if (!StringUtils.isEmpty(registrationForm.getLastName()))
				entity.setLastName(registrationForm.getLastName());

			if (!StringUtils.isEmpty(registrationForm.getMobile()))
				entity.setMobile(registrationForm.getMobile());

			if (!StringUtils.isEmpty(registrationForm.getPassword()))
				entity.setPassword(registrationForm.getPassword());

			if (!StringUtils.isEmpty(registrationForm.getUsername()))
				entity.setUsername(registrationForm.getUsername());

			if (!StringUtils.isEmpty(registrationForm.getAddressLine1()))
				entity.setAddressLine1(registrationForm.getAddressLine1());

			if (!StringUtils.isEmpty(registrationForm.getAddressLine2()))
				entity.setAddressLine2(registrationForm.getAddressLine2());

			if (!StringUtils.isEmpty(registrationForm.getCity()))
				entity.setCity(registrationForm.getCity());

			if (!StringUtils.isEmpty(registrationForm.getState()))
				entity.setState(registrationForm.getState());

			if (!StringUtils.isEmpty(registrationForm.getCountry()))
				entity.setCountry(registrationForm.getCountry());

			if (!StringUtils.isEmpty(registrationForm.getPincode()))
				entity.setPincode(registrationForm.getPincode());

		}

		@Override
		public void delete(Long id) {
			log.info("delete() - start");
			userRepository.delete(id);
			log.info("delete() - end");
		}

		@Override
		public List<UserDTO> getAll() {
			log.info("getAll() - start");
			List<UserDTO> userDTOList = new ArrayList<UserDTO>();
			Iterable<User> dbContent = userRepository.findAll();
			for (User entity : CollectionUtility.emptyIfNull(dbContent)) {
				userDTOList.add(entityToDTO(entity));
			}
			log.info("getAll() - end");
			return userDTOList;
		}

		private UserDTO entityToDTO(User entity) {
			if (entity != null) {
				UserDTO dto = new UserDTO();
				dto.setId(entity.getId());
				dto.setFirstName(entity.getFirstName());
				dto.setLastName(entity.getLastName());
				dto.setMobile(entity.getMobile());
				dto.setAddressLine1(entity.getAddressLine1());
				dto.setAddressLine2(entity.getAddressLine2());
				dto.setEmail(entity.getEmail());
				dto.setCity(entity.getCity());
				dto.setState(entity.getState());
				dto.setCountry(entity.getCountry());
				dto.setPincode(entity.getPincode());
				dto.setProfilePictureURL(entity.getProfilePictureURL());
				dto.setUsername(entity.getUsername());
				dto.setPassword(entity.getPassword());
				dto.setRoleName(entity.getUserRole() != null ? entity.getUserRole().getRoleName() : null);
				// TODO - role setting is not done
				return dto;
			}
			return null;
		}

		@Override
		public UserDTO getOne(Long id) {
			log.info("getOne() - start");
			User entity = userRepository.findOne(id);
			log.info("getOne() - end");
			return entityToDTO(entity);
		}

		@Override
		public UserDTO getByUsername(String username) {
			log.info("getByUsername () -start");
			User entity = userRepository.findUserByUsername(username);
			log.info("getByUsername () -end");
			return entityToDTO(entity);
		}

		@Override
		public boolean updatePassword(Integer id, String password) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public UserDTO getCurrentUser() {
			log.info("getCurrentUser()  - start");
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (user != null) {
				log.info("getCurrentUser()  - end");
				return entityToDTO(user);
			}
			log.info("getCurrentUser()  - end: No record found");
			return null;
		}
	}
}
