package services.user;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.user.UserDao;
import model.user.Role;
import model.user.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.getUser(username.toLowerCase());
		if (user == null) {
	            throw new UsernameNotFoundException("No user found with username: " + username);
	        }

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority("ROLE_" +user.getRole().toString()));
		

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

}
