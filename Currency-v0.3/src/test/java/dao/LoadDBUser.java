package dao;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.currency.CurrencyDaoImpl;
import dao.user.UserDao;
import dao.user.UserDaoImpl;
import model.user.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "beans-test.xml")
public class LoadDBUser {

	@Autowired
	UserDao dao;
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Test
	public void testCreateTableRole() {

		String sql = "create table role (name VARCHAR(50) not null)";
		jdbcTemplate.execute(sql);

	}
	
	@Test
	public void testCreateTableUser() {

		String sql = "create table user ("
				+ "username VARCHAR(50) primary key not null , "
				+ "password VARCHAR(50), "
				+ "role VARCHAR(50), "
				+ "foreign key (role) references role(name)"
				+ ")";
		jdbcTemplate.execute(sql);

	}
	
	
	
	
	
	
	
	
	
	
	

}
