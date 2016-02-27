package dao;

import java.io.File;
import java.io.IOException;

import javax.sql.DataSource;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.currency.CurrencyDaoImpl;
import model.currency.Currency;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "beans-test.xml")
public class LoadDB {

	@Autowired
	CurrencyDaoImpl dao;
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public static void createFile() throws IOException {
		File file = new File("E:\\testdb.db");

		file.createNewFile();
		
		
	}
	
	public void createTableCurrency() {

		String sql = "create table currency (id INTEGER primary key not null, name VARCHAR(50), buy REAL, sell REAL)";
		jdbcTemplate.execute(sql);

	}
	
//	@Test
//	public void createDB() throws IOException {
//		createFile();
//	}

//	@Ignore
	@Test
	public void test() throws IOException {
		
		Currency curr = new Currency.Builder()
				.name("dollar")
				.buy("2.2")
				.sell("3.3")
				.build();
//		curr.setName("Dordoba");
//		curr.setBuy(22.1f);
//		curr.setSell(54.2f);
		
//		createFile();

		//dao.createTable();
		dao.insert(curr);
//		dao.delete(3);
//		Currency curr1 = new Currency();
//		curr1 = dao.findById(1);
//		assertNull(curr1);
		
//		assertEquals(42.1, 42.1, curr1.getBuy());
		
		
	}
	
	
	
	
	
	
	
	
	

}
