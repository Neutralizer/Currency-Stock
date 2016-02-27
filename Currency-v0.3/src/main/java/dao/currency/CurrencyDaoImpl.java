package dao.currency;

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

import model.currency.Currency;

@Repository
public class CurrencyDaoImpl implements CurrencyDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}



	public Currency findById(int id) {
		String sql = "select * from currency where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id },
					new CurrencyMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public Collection<Currency> findAll() {
		String sql = "select * from currency";
		try {
		return this.jdbcTemplate.query(sql, new CurrencyMapper());
		} catch (EmptyResultDataAccessException e) {
			return new ArrayList<Currency>();
		}
	}
	
	public Collection<Currency> findAllLike(String key) {
		String sql = "select * from currency where name like ?";
		try {
			return this.jdbcTemplate.query(sql, new Object[] { key + "%" },
					new CurrencyMapper());
			} catch (EmptyResultDataAccessException e) {
				return new ArrayList<Currency>();
			}
	}

	public void insert(Currency currency) {
		String sql = "insert into currency (name, buy, sell) values (?,?,?)";
		jdbcTemplate.update(sql, currency.getName(), currency.getBuy(),
				currency.getSell());

	}

	public void update(Currency currency) {
		String sql = "update currency set name = ?, buy = ?, sell = ? where id = ?";
		jdbcTemplate.update(sql, currency.getName(), currency.getBuy(),
				currency.getSell(), currency.getId());
	}

	public void delete(int id) {
		String sql = "delete from currency where id = ?";
		jdbcTemplate.update(sql, id);
	}

	private static final class CurrencyMapper implements RowMapper<Currency> {

		public Currency mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Currency currency = new Currency.Builder()
					.id(resultSet.getInt("id"))
					.name(resultSet.getString("name"))
					.buy(resultSet.getString("buy"))
					.sell(resultSet.getString("sell"))
					.build();
					
					
//			currency.setId(resultSet.getInt("id"));
//			currency.setName(resultSet.getString("name"));
//			currency.setBuy((float) resultSet.getDouble("buy"));
//			currency.setSell((float) resultSet.getDouble("sell"));
			return currency;
		}

	}



}
