package dao.stock;

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
import model.stock.Stock;

@Repository
public class StockDaoImpl implements StockDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Stock findById(int id) {
		String sql = "select * from stock where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id }, new StockMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Collection<Stock> findAll() {
		String sql = "select * from stock";
		try {
			return this.jdbcTemplate.query(sql, new StockMapper());
		} catch (EmptyResultDataAccessException e) {
			return new ArrayList<Stock>();
		}
	}

	public Collection<Stock> fingAllLike(String key) {
		String sql = "select * from stock where name like ?";
		try {
			return jdbcTemplate.query(sql, new Object[] { key + "%" }, new StockMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void insert(Stock stock) {
		String sql = "insert into stock (name, buy, sell) values (?,?,?)";
		jdbcTemplate.update(sql, stock.getName(), stock.getBuy(), stock.getSell());

	}

	public void update(Stock stock) {
		String sql = "update stock set name = ? , buy = ?, sell = ? where id = ?";
		jdbcTemplate.update(sql, stock.getName(), stock.getBuy(), stock.getSell(), stock.getId());

	}

	public void delete(int id) {
		String sql = "delete from stock where id = ?";
		jdbcTemplate.update(sql, id);

	}

	private static final class StockMapper implements RowMapper<Stock> {

		public Stock mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Stock stock = new Stock.Builder().id(resultSet.getInt("id")).name(resultSet.getString("name"))
					.buy(resultSet.getString("buy")).sell(resultSet.getString("sell")).build();

			// currency.setId(resultSet.getInt("id"));
			// currency.setName(resultSet.getString("name"));
			// currency.setBuy((float) resultSet.getDouble("buy"));
			// currency.setSell((float) resultSet.getDouble("sell"));
			return stock;
		}

	}

}
