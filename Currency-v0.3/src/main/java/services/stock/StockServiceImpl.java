package services.stock;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import dao.stock.StockDao;
import model.stock.Stock;

public class StockServiceImpl implements StockService {

	@Autowired
	StockDao stockDao;

	public Collection<Stock> getAll() {

		Collection<Stock> stocks = stockDao.findAll();
		return stocks;
	}
	
	public Collection<Stock> getAllLike(String key) {
		return stockDao.fingAllLike(key);
	}

	public Stock getById(int id) {
		return stockDao.findById(id);
	}

	public void add(Stock stock) {
		stockDao.insert(stock);

	}

	public void update(Stock stock) {
		stockDao.update(stock);

	}

	public void delete(int id) {
		stockDao.delete(id);

	}



}
