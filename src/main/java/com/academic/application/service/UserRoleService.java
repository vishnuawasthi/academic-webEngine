package com.academic.application.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academic.application.dto.UserRoleDTO;
import com.academic.application.entity.UserRole;
import com.academic.application.form.UserRoleFom;
import com.academic.application.repository.UserRoleRepository;
import com.academic.application.utils.CollectionUtility;

public interface UserRoleService {

	public Long save (UserRoleFom userRoleForm);
	
	public void update (UserRoleFom userRoleForm);
	
	public void delete(Long id);
	
	public List< UserRoleDTO> getAll();
	
	public List< String> getAllRoleNames();
	
	@Service
	public class Impl implements UserRoleService{
		private static final Logger log = Logger.getLogger(Impl.class);

		@Autowired
		private UserRoleRepository userRoleRepository;
		
		@Override
		public Long save(UserRoleFom userRoleForm) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void update(UserRoleFom userRoleForm) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<UserRoleDTO> getAll() {
			log.info("getAll()- start");
			List<UserRoleDTO> dtos = new ArrayList<UserRoleDTO>(); 
			 Iterable<UserRole> dbContent = userRoleRepository.findAll();
			 for(UserRole role : CollectionUtility.emptyIfNull(dbContent)){
				 UserRoleDTO dto = new UserRoleDTO();
				 dto.setId(role.getId());
				 dto.setRoleName(role.getRoleName());
				 dto.setDescription(role.getDescription());
				 dtos.add(dto);
			 }
			 log.info("getAll()- end");
			return dtos;
		}

		@Override
		public List<String> getAllRoleNames() {
			log.info("getAllRoleNames()- start");
			List<String> roleNames = new ArrayList<String>(); 
			 Iterable<UserRole> dbContent = userRoleRepository.findAll();
			 for(UserRole role : CollectionUtility.emptyIfNull(dbContent)){
				 roleNames.add(role.getRoleName());
			 }
			 log.info("getAllRoleNames()- end");
			return roleNames;
		}
		
	}
	
	
}
