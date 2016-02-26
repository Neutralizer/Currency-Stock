package dao.stock;

import java.util.Collection;

import model.stock.Stock;

public interface StockDao {

	Collection<Stock> findAll();
	
	Collection<Stock> fingAllLike(String key);

	Stock findById(int id);

	void insert(Stock stock);

	void update(Stock stock);

	void delete(int id);
}
