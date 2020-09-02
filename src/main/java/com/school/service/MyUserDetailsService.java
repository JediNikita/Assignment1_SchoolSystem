package com.school.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.model.Permission;
import com.school.model.Role;
import com.school.model.User;
import com.school.repository.RoleRepository;
import com.school.repository.UserRepository;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * @Autowired private IUserService service;
	 * 
	 * 
	 * @Autowired private MessageSource messages;
	 */

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("user 404");
		}
		// return new UserDetailsImpl(user);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true,
				true, true, true, getAuthorities(user.getRole()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Role role) {

		return getGrantedAuthorities(getPermissions(role));
	}

	private List<String> getPermissions(Role role) {

		List<String> permissions = new ArrayList<>();
		List<Permission> collection = new ArrayList<>();
		
			collection=(List<Permission>) role.getPermissions();
		
		for (Permission item : collection) {
			permissions.add(item.getPermission());
		}
		return permissions;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> permissions) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : permissions) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		return authorities;
	}
	


}
