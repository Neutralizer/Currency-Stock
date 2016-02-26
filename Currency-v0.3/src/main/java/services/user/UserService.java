package services.user;

import java.util.Collection;

import model.user.Role;
import model.user.User;

public interface UserService {

	void create(User user);

	Collection<Role> getRoles();

	/**
	 * 
	 * @param user
	 * @return true when user already exists 
	 */
	boolean isExisting(User user);

}
