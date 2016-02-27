package dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import dao.currency.CurrencyDaoImpl;
import model.currency.Currency;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "beans-test.xml")
@EnableTransactionManagement
@Rollback
public class TryCurrency {

	@Autowired
	CurrencyDaoImpl dao;
	
	@Test
	public void test(){
		
		Currency curr = new Currency.Builder()
				.name("dollar")
				.buy("2.2")
				.sell("3.3")
				.build();

		dao.insert(curr);


		Currency currency = dao.findById(1);
		
		assertNotNull(currency);
		
		assertEquals("dollar", currency.getName());

		Currency curr1 = new Currency.Builder()
				.id(currency.getId())
				.name("dollar")
				.buy("2.2")
				.sell("33.3")
				.build();

		dao.update(curr1);

		assertEquals(33.3, dao.findById(1).getSell(), 0.0001);
		
		Currency curr2 = new Currency.Builder()
				.name("frank")
				.buy("22.2")
				.sell("33.3")
				.build();

		dao.insert(curr2);

		Collection<Currency> coll = new ArrayList<Currency>();

		coll = dao.findAll();

		assertEquals("dollar", coll.iterator().next().getName());
//		assertEquals(2, coll.size());

		dao.delete(2);

//		assertEquals(1, dao.findAll().size());
		
		assertNull(dao.findById(2));

		
	}
	
	@Test
	public void testLike(){
		
		Collection<Currency> coll = new ArrayList<Currency>();
		
		coll = dao.findAllLike("do");
		
		assertEquals("dollar", coll.iterator().next().getName());
		
		
	}

//	@Test
//	public void testInsert() throws SQLException {
//
//		Currency curr = new Currency.Builder()
//				.name("dollar")
//				.buy(2.2f)
//				.sell(3.3f)
//				.build();
//
//		dao.insert(curr);
//
//		assertNotNull(dao.findById(1));
//
//	}
//
//	@Test
//	public void testFindById() {
//
//		Currency curr = new Currency.Builder()
//				.name("dollar")
//				.buy(2.2f)
//				.sell(3.3f)
//				.build();
//
//		dao.insert(curr);
//
//		assertEquals("dollar", dao.findById(1).getName());
//
//	}
//
//	@Test
//	public void testUpdate() {
//		
//		Currency curr = new Currency.Builder()
//				.name("dollar")
//				.buy(2.2f)
//				.sell(3.3f)
//				.build();
//
//		dao.insert(curr);
//
//		Currency currency = dao.findById(1);
//
//		Currency curr1 = new Currency.Builder()
//				.id(currency.getId())
//				.name("dollar")
//				.buy(2.2f)
//				.sell(33.3f)
//				.build();
//
//		dao.update(curr1);
//
//		assertEquals(33.3, dao.findById(1).getBuy(), 0.0001);
//	}
//
//	@Test
//	public void testFindAll() {
//		
//		Currency curr1 = new Currency.Builder()
//				.name("dollar")
//				.buy(2.2f)
//				.sell(3.3f)
//				.build();
//		
//		dao.insert(curr1);
//
//		Currency curr2 = new Currency.Builder()
//				.name("frank")
//				.buy(22.2f)
//				.sell(33.3f)
//				.build();
//
//		dao.insert(curr2);
//
//		Collection<Currency> coll = new ArrayList<Currency>();
//
//		coll = dao.findAll();
//
//		assertEquals("dollar", coll.iterator().next().getName());
//		assertEquals(2, coll.size());
//
//	}
//
//	@Test
//	public void testDelete() {
//		
//		Currency curr1 = new Currency.Builder()
//				.name("dollar")
//				.buy(2.2f)
//				.sell(3.3f)
//				.build();
//		
//		dao.insert(curr1);
//
//		Currency curr2 = new Currency.Builder()
//				.name("frank")
//				.buy(22.2f)
//				.sell(33.3f)
//				.build();
//
//		dao.insert(curr2);
//
//		dao.delete(2);
//
////		assertEquals(1, dao.findAll().size());
//		
//		assertNull(dao.findById(2));
//	}

}
