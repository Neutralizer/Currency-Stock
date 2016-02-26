package services.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import dao.user.UserDao;
import model.user.Role;
import model.user.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void create(User user) {
		userDao.persist(user);
	}

	public Collection<Role> getRoles() {
		return userDao.findRoles();
	}

	public boolean isExisting(User user) {
		return userDao.isExisting(user);
	}

}
