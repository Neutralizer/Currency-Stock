package dao.user;

import java.util.Collection;

import model.user.Role;
import model.user.User;

public interface UserDao {
	
	void persist(User user);
	
	Collection<Role> findRoles();
	
	boolean isExisting(User user);
	
	User getUser(String username);
	
}
