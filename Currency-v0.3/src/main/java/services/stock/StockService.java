package services.stock;

import java.util.Collection;

import model.stock.Stock;

public interface StockService {
	
	Collection<Stock> getAll();
	
	Collection<Stock> getAllLike(String key);
	
	Stock getById(int id);
	
	void add(Stock stock);

	void update(Stock stock);

	void delete(int id);

}
