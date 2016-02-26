package dao.currency;

import java.util.Collection;

import model.currency.Currency;

public interface CurrencyDao {
	
	Collection<Currency> findAll();
	
	Collection<Currency> findAllLike(String key);

	Currency findById(int id);

	void insert(Currency currency);

	void update(Currency currency);

	void delete(int id);

}
