package dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.user.Role;
import model.user.User;

@Repository
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void persist(User user) {
		String sql = "insert into user (username, password, role) values (?,?,?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getRole());
	}

	public Collection<Role> findRoles() {
		String sql = "select * from role ";
		try {
			return this.jdbcTemplate.query(sql, new RoleMapper());
		} catch (EmptyResultDataAccessException e) {
			return new ArrayList<Role>();
		}
	}

	public boolean isExisting(User user) {
		String sql = "select * from user where username = ?";
		try {
		jdbcTemplate.queryForObject(sql, new Object[] { user.getUsername() }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return false;
		}

		return true;

	}

	private static final class RoleMapper implements RowMapper<Role> {

		public Role mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Role role = Role.valueOf(resultSet.getString("name").toUpperCase());

			return role;
		}

	}

	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setRole(Role.valueOf(resultSet.getString("role").toUpperCase()));
			return user;
		}

	}

}
